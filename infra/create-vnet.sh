#!/bin/bash
resourcegroup=$1
vnetName=$2
azure group deployment create $resourcegroup -p "{\"vnetName\":{\"value\":\"""$vnetName""\"}}" --template-file vnet.json
