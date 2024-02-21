locals {
  keycloak_internal_url = "http://${helm_release.keycloak.name}.${helm_release.keycloak.namespace}.svc.cluster.local"
}


# Helm chart for postgres
# https://artifacthub.io/packages/helm/bitnami/postgresql
# https://github.com/bitnami/charts/tree/main/bitnami/postgresql
resource "helm_release" "postgresql" {
  name       = "postgresql"
  repository = "https://charts.bitnami.com/bitnami"
  chart      = "postgresql"
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

resource "helm_release" "apicurio-registry" {
   name             = "apicurio-registry"
   repository       = "https://one-acre-fund.github.io/oaf-public-charts"
   chart            = "apicurio"
   namespace        = "apicurio-registry"
   create_namespace = true
   version = "1.0.15"
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
 }

 output "keycloak_url" {
  value = "http://${helm_release.keycloak.status.load_balancer.ingress[0].hostname}"
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