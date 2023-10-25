module "olm" {
  source  = "tensor5/olm/kubernetes"
  version = "0.2.0"
}

resource "helm_release" "redis-cluster" {
  name       = "redis-cluster"
  repository = "oci://registry-1.docker.io/bitnamicharts"
  chart      = "redis-cluster"
}

resource "helm_release" "nginx_ingress" {
  name             = "nginx-ingress-controller"
  repository       = "https://charts.bitnami.com/bitnami"
  chart            = "nginx-ingress-controller"
  namespace        = "nginx-ingress-controller"

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

data "http" "postgresql-operator" {
  url = "https://operatorhub.io/install/postgresql.yaml"
}

resource "kubectl_manifest" "postgresql-operator" {
  yaml_body  = data.http.postgresql-operator.response_body
  depends_on = [module.olm]
}

data "local_file" "postgres" {
  filename = "resources/postgres-cluster.crd.yaml"
}


resource "kubectl_manifest" "postgresql" {
  yaml_body  = data.local_file.postgres.content
  depends_on = [resource.kubectl_manifest.postgresql-operator]
}

data "http" "apicurio-registry-operator" {
  url = "https://operatorhub.io/install/apicurio-registry.yaml"
}

resource "kubectl_manifest" "apicurio-registry-operator" {
  yaml_body  = data.http.apicurio-registry-operator.response_body
  depends_on = [module.olm]
}

data "local_file" "apicurio-registry" {
  filename = "resources/apicurio-registry.yaml"
}

resource "kubectl_manifest" "apicurio-registry" {
  yaml_body  = data.local_file.apicurio-registry.content
  depends_on = [resource.kubectl_manifest.apicurio-registry-operator]
}

data "http" "keycloak-crd" {
  url = "https://raw.githubusercontent.com/keycloak/keycloak-k8s-resources/21.0.1/kubernetes/keycloaks.k8s.keycloak.org-v1.yml"
}

resource "kubectl_manifest" "keycloak-crd" {
  yaml_body  = data.http.keycloak-crd.response_body
  depends_on = [module.olm]
}

data "http" "keycloak-realm-imports" {
  url = "https://raw.githubusercontent.com/keycloak/keycloak-k8s-resources/21.0.1/kubernetes/keycloakrealmimports.k8s.keycloak.org-v1.yml"
}

resource "kubectl_manifest" "keycloak-realm-imports" {
  yaml_body  = data.http.keycloak-realm-imports.response_body
  depends_on = [data.http.keycloak-crd]
}

data "http" "keycloak-operator" {
  url = "https://raw.githubusercontent.com/keycloak/keycloak-k8s-resources/21.0.1/kubernetes/kubernetes.yml"
}

resource "kubectl_manifest" "keycloak-operator" {
  yaml_body  = data.http.keycloak-operator.response_body
  depends_on = [data.http.keycloak-realm-imports]
}

resource "kubernetes_secret" "postgres-secret" {
  metadata {
    name = "postgres-secret"
  }

  data = {
    username = "postgres"
    password = "postgres"
  }

  type = "kubernetes.io/basic-auth"
}



resource "kubernetes_secret" "crazyfly-tls-secret" {
  metadata {
    name = "crazyfly-tls-secret"
  }

  data = {
    "tls.crt" = file("${path.module}/certs/certificate.pem")
    "tls.key" = file("${path.module}/certs/key.pem")
  }


  type = "kubernetes.io/tls"
}

data "local_file" "kc-postgres" {
  filename = "resources/postgres.yaml"
}

resource "kubectl_manifest" "kc-postgres" {
  yaml_body = data.local_file.kc-postgres.content
}

data "local_file" "keycloak" {
  filename = "resources/keycloak.yaml"
}

resource "kubectl_manifest" "keycloak" {
  yaml_body  = data.local_file.keycloak.content
  depends_on = [resource.kubectl_manifest.keycloak-operator, resource.kubectl_manifest.kc-postgres, resource.kubernetes_secret.crazyfly-tls-secret, resource.kubernetes_secret.postgres-secret]
}


resource "helm_release" "argo-events" {
  name             = "argo-events"
  repository       = "https://argoproj.github.io/argo-helm"
  chart            = "argo-events"
  namespace        = "default"
  create_namespace = true
}


resource "helm_release" "opentelemetry-operator" {
  name             = "opentelemetry-operator"
  repository       = "https://open-telemetry.github.io/opentelemetry-helm-charts"
  chart            = "opentelemetry-operator"
  namespace        = "operators"
  create_namespace = true
  depends_on       = [module.olm, helm_release.cert-manager]
}

data "local_file" "opentelemetry-collector" {
  filename = "resources/otel.yaml"
}

resource "kubectl_manifest" "opentelemetry-collector" {
  yaml_body  = data.local_file.opentelemetry-collector.content
  depends_on = [data.local_file.opentelemetry-collector, resource.helm_release.opentelemetry-operator]
}


# resource "helm_release" "kafka" {
#   name             = "kafka"
#   repository       = "https://packages.vectorized.io/public/console/helm/charts/"
#   chart            = "console"
#   namespace        = "default"
#   create_namespace = true
# }

resource "helm_release" "kafka-ui" {
  name             = "kafka-ui"
  repository       = "https://provectus.github.io/kafka-ui"
  chart            = "kafka-ui"
  namespace        = "default"
  create_namespace = true

  set {
    name  = "envs.config.KAFKA_CLUSTERS_0_NAME"
    value = "local"
  }

  set {
    name  = "envs.config.KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS"
    value = "redpanda:29092"
#    value = "kafka-cluster-kafka-bootstrap.kafka.svc.cluster.local:9092"
  }
}


//===============================================================================
//============================ REDPANDA HELM ====================================
//===============================================================================

# resource "helm_release" "redpanda" {
#   name             = "redpanda"
#   repository       = "https://charts.redpanda.com"
#   chart            = "redpanda"
#   namespace        = "redpanda"
#   create_namespace = true

#   set {
#     name  = "installCRDs"
#     value = "true"
#   }
# }

//===============================================================================
//===============================================================================
//===============================================================================




//===============================================================================
//============================ REDPANDA OPERATOR ================================
//===============================================================================

resource "kubernetes_namespace" "redpanda" {
  metadata {
    labels = {
      mylabel = "redpanda"
    }

    name = "redpanda"
  }
}

data "kustomization" "redpanda-crd" {
  provider = kustomization
  path     = "github.com/redpanda-data/redpanda/src/go/k8s/config/crd?ref=v23.1.1"
}

resource "kustomization_resource" "redpanda-crd" {
  provider = kustomization

  for_each   = data.kustomization.redpanda-crd.ids
  manifest   = data.kustomization.redpanda-crd.manifests[each.value]
  depends_on = [module.olm, data.kustomization.redpanda-crd, kubernetes_namespace.redpanda]
}

resource "helm_release" "redpanda-operator" {
  name             = "redpanda-operator"
  repository       = "https://charts.vectorized.io/"
  chart            = "redpanda-operator"
  namespace        = "operators"
  create_namespace = true
  depends_on = [
    helm_release.cert-manager,
    resource.kustomization_resource.redpanda-crd
  ]
}

data "local_file" "redpanda" {
  filename = "resources/redpanda.yaml"
}

resource "kubectl_manifest" "redpanda" {
  yaml_body  = data.local_file.redpanda.content
  depends_on = [helm_release.redpanda-operator, kubernetes_namespace.redpanda]
}

data "local_file" "redpanda-console" {
  filename = "resources/redpanda-console.yaml"
}

resource "kubectl_manifest" "redpanda-console" {
  yaml_body  = data.local_file.redpanda-console.content
  depends_on = [helm_release.redpanda-operator, kubernetes_namespace.redpanda]
}


//===============================================================================
//========================= APACHE APISIX APIGATEWAY ============================
//===============================================================================

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

//===============================================================================
//================================== KEDA =======================================
//===============================================================================

resource "helm_release" "keda" {
  name             = "keda"
  repository       = "https://kedacore.github.io/charts"
  chart            = "keda"
  namespace        = "keda"
  create_namespace = true
}

//===============================================================================
//=============================== PROMETHEUS ====================================
//===============================================================================

data "http" "prometheus-operator" {
  url = "https://github.com/prometheus-operator/prometheus-operator/releases/download/v0.62.0/bundle.yaml"
}

resource "kubectl_manifest" "prometheus-operator" {
  yaml_body  = data.http.prometheus-operator.response_body
  depends_on = [module.olm]
}

//===============================================================================
//================================= KAFKA =======================================
//===============================================================================
resource "helm_release" "kafka-operator" {
  chart      = "strimzi-kafka-operator"
  name       = "kafka-operator"
  namespace  = "kafka"
  create_namespace = true
  repository = "https://strimzi.io/charts/"
  depends_on = [module.olm]
}

data "local_file" "kafka" {
  filename = "resources/kafka.yaml"
}

resource "kubectl_manifest" "kafka" {
  yaml_body  = data.local_file.kafka.content
  depends_on = [helm_release.kafka-operator]
}

//===============================================================================
//================================= HARBOR ======================================
//===============================================================================

resource "helm_release" "harbor" {
  chart      = "harbor"
  name       = "harbor"
  namespace  = "harbor"
  create_namespace = true
  repository = "https://helm.goharbor.io"
}