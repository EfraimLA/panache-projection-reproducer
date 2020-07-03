#!/usr/bin/env bash
echo "Starting Containers..."
cd scripts/test
docker-compose -f docker-compose.yml up -d
