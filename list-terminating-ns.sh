#!/bin/bash

# Get the list of namespaces in terminating state
terminating_namespaces=$(kubectl get namespaces --field-selector=status.phase=Terminating -o=jsonpath='{.items[*].metadata.name}')

# Iterate through each namespace and perform the necessary actions
for namespace in $terminating_namespaces
do
    # Check for finalizers
    finalizers=$(kubectl get namespace $namespace -o=json | jq -r ".spec.finalizers[]")
    if [ -n "$finalizers" ]; then
        echo "Namespace $namespace has finalizers: $finalizers"
        # Perform actions to remove finalizers
        # Example: kubectl patch namespace $namespace -p '{"metadata":{"finalizers":[]}}' --type=merge
    fi

    # Force delete the namespace
    kubectl delete namespace $namespace --grace-period=0 --force
done
