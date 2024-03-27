#!/bin/bash

# Get all namespaces that are stuck in Terminating status
TERMINATING_NAMESPACES=$(kubectl get ns --field-selector=status.phase=Terminating -o jsonpath='{.items[*].metadata.name}')

# Loop through each namespace and remove finalizers
for ns in $TERMINATING_NAMESPACES; do
    echo "Removing finalizers from namespace: $ns"
    # Patch the namespace to remove finalizers
    kubectl patch namespace "$ns" --type='json' -p='[{"op": "remove", "path": "/spec/finalizers"}]'
    kubectl delete namespace "$ns"
done

echo "All terminating namespaces have been processed."
