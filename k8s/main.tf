locals {
  keycloak_internal_url = "${helm_release.keycloak.name}.${helm_release.keycloak.namespace}.svc.cluster.local"
  postgresql_internal_url = "${helm_release.postgresql.name}-postgresql-ha-pgpool.${helm_release.postgresql.namespace}.svc.cluster.local"
}


# Helm chart for postgres
# https://artifacthub.io/packages/helm/bitnami/postgresql
# https://github.com/bitnami/charts/tree/main/bitnami/postgresql
resource "helm_release" "postgresql" {
  name       = "postgresql"
  repository = "https://charts.bitnami.com/bitnami"
  chart      = "postgresql-ha"
  namespace = "postgresql"
  create_namespace = true
}

data "kubernetes_secret" "postgresql_secret" {
  metadata {
    name      = "${helm_release.postgresql.metadata[0].name}-postgresql-ha-postgresql"
    namespace = helm_release.postgresql.metadata[0].namespace
  }

  depends_on = [ helm_release.postgresql ]
}

data "kubernetes_secret" "keycloak_secret" {
  metadata {
    name      = helm_release.keycloak.metadata[0].name
    namespace = helm_release.keycloak.metadata[0].namespace
  }

  depends_on = [helm_release.keycloak]
}

resource "kubernetes_secret" "apicurio_keycloak_secret" {
  metadata {
    name      = data.kubernetes_secret.keycloak_secret.metadata[0].name
    namespace = "apicurio"
  }

  data = data.kubernetes_secret.keycloak_secret.data
  type = data.kubernetes_secret.keycloak_secret.type


  depends_on = [ data.kubernetes_secret.keycloak_secret, helm_release.apicurio ]
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
   create_namespace = true

  set {
    name  = "mode"
    value = "deployment"
  }
  set {
    name  = "ingress.enabled"
    value = "true"
  }	

  set {
    name  = "rbac.create"
    value = "true"
  }	
  set {
    name  = "serviceAccount.name"
    value = "keycloak-service-account"
  }

  set {
    name  = "rbac.rules[0].apiGroups[0]"
    value = ""
  }

  set {
    name  = "rbac.rules[0].resources[0]"
    value = "secrets"
  }

  set {
    name  = "rbac.rules[0].verbs[0]"
    value = "get"
  }

  set {
    name  = "rbac.rules[0].verbs[1]"
    value = "watch"
  }

  set {
    name  = "rbac.rules[0].verbs[2]"
    value = "list"
  }

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
  namespace  = "apicurio"
  chart      = "../charts/apicurio"
  create_namespace = true

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
    name  = "externalDatabase.host"
    value = "postgresql-postgresql-ha-pgpool.postgresql.svc.cluster.local"
  }
  set {
    name  = "externalDatabase.secret.password"
    value = "Bveq9D8rYY"
  }
  set {
    name  = "externalDatabase.secret.username"
    value = "postgres"
  }
  
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