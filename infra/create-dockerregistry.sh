#!/bin/bash
resourcegroup=$1
dregistryname=$2
azure group deployment create $resourcegroup -p "{\"registries_dregistry_name\":{\"value\":\"""$dregistryname""\"}}" --template-file docker-registry.json
