#!/bin/bash
templatefile=$1
resourcegroup=$2
az group deployment create \
     --name createVstsAgentDeployment \
     --resource-group $resourcegroup \
     --template-file  vsts-buildagent.json \
     --parameters @$templatefile
