terraform {
  required_providers {
    kubernetes = {
      source  = "hashicorp/kubernetes"
      version = ">= 2.11.0"
    }
    kubectl = {
      source  = "gavinbunney/kubectl"
      version = ">= 1.7.0"
    }
    helm = {
      source  = "hashicorp/helm"
      version = ">= 2.12.1"
    }
    kustomization = {
      source = "kbst/kustomization"
      version = "0.9.2"
    }
  }
}

provider "kubernetes" {
  config_path    = "~/.kube/config"
}

provider "helm" {
  kubernetes {
    config_path = "~/.kube/config"
  }
}

locals {
  keycloak_internal_url = "${helm_release.keycloak.name}.${helm_release.keycloak.namespace}.svc.cluster.local"
  postgresql_internal_url = "${helm_release.postgres.name}-postgresql-ha-pgpool.${helm_release.postgres.namespace}.svc.cluster.local"
}


# Helm chart for postgres
# https://artifacthub.io/packages/helm/bitnami/postgresql
# https://github.com/bitnami/charts/tree/main/bitnami/postgresql
resource "helm_release" "pgadmin4" {
  name       = "pgadmin"
  repository = "https://helm.runix.net"
  chart      = "pgadmin4"
  namespace = "pgadmin"
  create_namespace = true
}

resource "helm_release" "postgres" {
  name       = "postgres"
  repository = "https://charts.bitnami.com/bitnami"
  chart      = "postgresql-ha"
  namespace = "postgres"
  create_namespace = true
}

resource "kubernetes_namespace" "apicurio" {
  metadata {
    name = "apicurio"
  }
  
}

data "kubernetes_secret" "postgres" {
  metadata {
    name      = "${helm_release.postgres.metadata[0].name}-postgresql-ha-postgresql"
    namespace = helm_release.postgres.metadata[0].namespace
  }
  depends_on = [ helm_release.postgres ]
}

data "kubernetes_secret" "keycloak_secret" {
  metadata {
    name      = helm_release.keycloak.metadata[0].name
    namespace = helm_release.keycloak.metadata[0].namespace
  }
  depends_on = [helm_release.keycloak]
}

resource "kubernetes_secret" "postgres_apicurio" {
  metadata {
    name      = "postgres"
    namespace = resource.kubernetes_namespace.apicurio.metadata[0].name
  }
  data = data.kubernetes_secret.postgres.data
  type = data.kubernetes_secret.postgres.type
  depends_on = [ resource.kubernetes_namespace.apicurio ]
}

resource "kubernetes_job" "create_db" {
  depends_on = [helm_release.postgres]

  metadata {
    name = "create-apicurio-db"
    namespace = helm_release.postgres.namespace
  }

  spec {
    ttl_seconds_after_finished = 10
    template {
      metadata {
        name = "create-apicurio-db"
      }
      spec {
        container {
          image = "bitnami/postgresql:latest"
          name  = "create-db"
          command = ["/bin/sh", "-c","PGPASSWORD=$POSTGRES_PASSWORD psql -h $DB_HOST -U $POSTGRES_USER -d $POSTGRES_DB -tc \"SELECT 1 FROM pg_database WHERE datname = '$DB_NAME'\" | grep -q 1 || psql -h $DB_HOST -U $POSTGRES_USER -d $POSTGRES_DB -c \"CREATE DATABASE '$DB_NAME'\""
          ]
          
          env {
            name  = "DB_HOST"
            value = "${helm_release.postgres.name}-postgresql-ha-pgpool.${helm_release.postgres.namespace}.svc.cluster.local"
          }
          env {
            name  = "POSTGRES_USER"
            value = "postgres"
          }

          env {
            name  = "POSTGRES_PASSWORD"
            value_from {
              secret_key_ref {
                name = "${helm_release.postgres.name}-postgresql-ha-postgresql"
                key = "password"
              }
            }
          }

          env {
            name  = "POSTGRES_DB"
            value = "postgres"
          }

          env {
            name = "DB_NAME"
            value = "apicurio"
          }
        }

        restart_policy = "Never"
      }
    }

    backoff_limit = 4
  }
}


resource "helm_release" "redis-cluster" {
  name       = "redis-cluster"
  repository = "https://charts.bitnami.com/bitnami"
  chart      = "redis-cluster"
}

resource "helm_release" "nginx_ingress" {
  name             = "nginx-ingress-controller"
  repository       = "https://charts.bitnami.com/bitnami"
  chart            = "nginx-ingress-controller"
  namespace        = "nginx-ingress-controller"
  create_namespace = true
  set {
    name  = "service.type"
    value = "ClusterIP"
  }
}

resource "helm_release" "cert-manager" {
  name             = "cert-manager"
  repository       = "https://charts.jetstack.io"
  chart            = "cert-manager"
  namespace        = "cert-manager"
  create_namespace = true

  set {
    name  = "installCRDs"
    value = "true"
  }
}


resource "helm_release" "keycloak" {
   name             = "keycloak"
   repository       = "https://charts.bitnami.com/bitnami"
   chart            = "keycloak"
   namespace        = "keycloak"
   version = "19.3.3"
   create_namespace = true

  set {
    name  = "mode"
    value = "deployment"
  }
  set {
    name  = "ingress.enabled"
    value = "true"
  }	

  # set {
  #   name  = "rbac.create"
  #   value = "true"
  # }	
  # set {
  #   name  = "serviceAccount.name"
  #   value = "keycloak-service-account"
  # }

  # set {
  #   name  = "rbac.rules[0].apiGroups[0]"
  #   value = ""
  # }

  # set {
  #   name  = "rbac.rules[0].resources[0]"
  #   value = "secrets"
  # }

  # set {
  #   name  = "rbac.rules[0].verbs[0]"
  #   value = "get"
  # }

  # set {
  #   name  = "rbac.rules[0].verbs[1]"
  #   value = "watch"
  # }

  # set {
  #   name  = "rbac.rules[0].verbs[2]"
  #   value = "list"
  # }

  # set {
  #   name  = "postgresql.enabled"
  #   value = "false"
  # }	

  # set {
  #   name  = "externalDatabase.host"
  #   value = "${local.postgresql_internal_url}"
  # }	
  # set {
  #   name  = "externalDatabase.user"
  #   value = "postgres"
  # }	

  # set {
  #   name  = "externalDatabase.password"
  #   value = data.kubernetes_secret.postgresql_secret.data["password"]
  # }	

  # depends_on = [ data.kubernetes_secret.postgresql_secret ]
  
 }


resource "helm_release" "apicurio" {
  name       = "apicurio"
  namespace  = resource.kubernetes_namespace.apicurio.metadata[0].name
  chart      = "./charts/apicurio"

  set {
    name  = "auth.secret.adminUsername"
    value = "user"
  }
  set {
    name  = "auth.secret.adminPassword"
    value = "eAdu6JAJFN"
  }
  set {
    name  = "externalDatabase.enabled"
    value = "true"
  }

  set {
    name  = "externalDatabase.existingSecret"
    value = "postgres"
  }

  set {
    name  = "externalDatabase.existingSecretPasswordKey"
    value = "password"
  }  

  set {
    name  = "externalDatabase.host"
    value = "${helm_release.postgres.metadata[0].name}-postgresql-ha-pgpool.${helm_release.postgres.namespace}.svc.cluster.local"
  }
  set {
    name  = "externalDatabase.username"
    value = "postgres"
  }
  
  depends_on = [ kubernetes_job.create_db, resource.kubernetes_secret.postgres_apicurio ]
}



 resource "helm_release" "opentelemetry-collector" {
   name             = "opentelemetry-collector"
   repository       = "https://open-telemetry.github.io/opentelemetry-helm-charts"
   chart            = "opentelemetry-collector"
   namespace        = "opentelemetry-collector"
   create_namespace = true

  set {
    name  = "mode"
    value = "deployment"
  }

 }

 resource "helm_release" "dragonfly" {
   name             = "dragonfly"
   repository       = "oci://ghcr.io/dragonflydb/dragonfly/helm/dragonfly"
   chart            = "dragonfly"
   namespace        = "dragonfly"
   create_namespace = true
   version          = "v1.15.1"
 }

 resource "helm_release" "redpanda" {
   name             = "redpanda"
   repository       = "https://charts.redpanda.com"
   chart            = "redpanda"
   namespace        = "redpanda"
   create_namespace = true

   set {
    name = "statefulset.replicas"
    value = "1"
   }

  depends_on = [
    helm_release.cert-manager
  ]

 }


resource "helm_release" "apisix" {
  name             = "apisix"
  repository       = "https://charts.apiseven.com"
  chart            = "apisix"
  namespace        = "ingress-apisix"
  create_namespace = true

  set {
    name  = "gateway.type"
    value = "NodePort"
  }

  set {
    name  = "ingress-controller.enabled"
    value = "true"
  }

  set {
    name  = "ingress-controller.config.apisix.serviceNamespace"
    value = "ingress-apisix"
  }
}

resource "helm_release" "apisix-dashboard" {
  name       = "apisix-dashboard"
  repository = "https://charts.apiseven.com"
  chart      = "apisix-dashboard"
  namespace  = "ingress-apisix"

  depends_on = [
    helm_release.apisix
  ]
}

resource "helm_release" "keda" {
  name             = "keda"
  repository       = "https://kedacore.github.io/charts"
  chart            = "keda"
  namespace        = "keda"
  create_namespace = true
}


resource "helm_release" "prometheus" {
  name             = "prometheus"
  repository       = "https://prometheus-community.github.io/helm-charts"
  chart            = "prometheus"
  namespace        = "prometheus"
  create_namespace = true
}

resource "helm_release" "microcks" {
  chart      = "microcks"
  name       = "microcks"
  namespace  = "microcks"
  create_namespace = true
  repository = "https://microcks.io/helm"
  version = "1.8.1"
}

resource "helm_release" "harbor" {
  chart      = "harbor"
  name       = "harbor"
  namespace  = "harbor"
  create_namespace = true
  repository = "https://helm.goharbor.io"
}