#!/bin/bash

# Get the list of namespaces in terminating state
terminating_namespaces=$(kubectl get namespaces --field-selector=status.phase=Terminating -o=jsonpath='{.items[*].metadata.name}')

# Iterate through each namespace and perform the necessary actions
for ns in $terminating_namespaces
do
    kubectl delete all -n $ns --all
done
