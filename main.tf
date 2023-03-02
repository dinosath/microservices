module "olm" {
  source  = "tensor5/olm/kubernetes"
  version = "0.2.0"
}

resource "helm_release" "redis" {
  name       = "redis"
  repository = "https://charts.bitnami.com/bitnami"
  chart      = "redis"
}

resource "helm_release" "nginx_ingress" {
  name             = "nginx-ingress-controller"
  repository       = "https://charts.bitnami.com/bitnami"
  chart            = "nginx-ingress-controller"
  namespace        = "nginx-ingress-controller"
  create_namespace = true
  force_update     = true

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
  version          = "v1.4.4"
  create_namespace = true
  force_update     = true

  set {
    name  = "installCRDs"
    value = "true"
  }
}


data "kustomization" "redpanda-crd" {
  provider = kustomization
  path = "github.com/redpanda-data/redpanda/src/go/k8s/config/crd?ref=v23.1.1"
}

resource "kustomization_resource" "redpanda-crd" {
  provider = kustomization

  for_each = data.kustomization.redpanda-crd.ids
  manifest = data.kustomization.redpanda-crd.manifests[each.value]
  depends_on = [module.olm,data.kustomization.redpanda-crd]
}

resource "helm_release" "redpanda-operator" {
  name             = "redpanda-operator"
  repository       = "https://charts.vectorized.io/"
  chart            = "redpanda-operator"
  namespace        = "operators"
  create_namespace = true
  force_update     = true
  depends_on = [
    helm_release.cert-manager,
    resource.kustomization_resource.redpanda-crd
  ]
}

data "http" "postgresql-operator" {
  url = "https://operatorhub.io/install/postgresql.yaml"
}

resource "kubectl_manifest" "postgresql-operator" {
  yaml_body  = data.http.postgresql-operator.response_body
  depends_on = [module.olm]
}

data "local_file" "postgres" {
  filename = "k8s/postgres-cluster.crd.yaml"
}


resource "kubectl_manifest" "postgresql" {
  yaml_body  = data.local_file.postgres.content
  depends_on = [resource.kubectl_manifest.postgresql-operator]
}

data "http" "redpanda-cluster" {
  url = "https://raw.githubusercontent.com/redpanda-data/redpanda/dev/src/go/k8s/config/samples/one_node_cluster.yaml"
}

resource "kubectl_manifest" "redpanda-cluster" {
  yaml_body  = data.http.redpanda-cluster.response_body
  depends_on = [helm_release.redpanda-operator]
}

data "http" "apicurio-registry-operator" {
  url = "https://operatorhub.io/install/apicurio-registry.yaml"
}

resource "kubectl_manifest" "apicurio-registry-operator" {
  yaml_body  = data.http.apicurio-registry-operator.response_body
  depends_on = [module.olm]
}

data "local_file" "apicurio-registry" {
  filename = "k8s/apicurio-registry.yaml"
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
