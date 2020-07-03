#!/usr/bin/env bash
echo "Stopping Containers..."
cd scripts/test
docker-compose -f docker-compose.yml down
