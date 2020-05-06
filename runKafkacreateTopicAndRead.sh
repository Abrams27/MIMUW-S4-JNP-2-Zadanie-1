#!/bin/bash

TOPIC_NAME=jnp-mail

docker-compose up -d

kafka-topics --create --zookeeper localhost:2181 --topic ${TOPIC_NAME} --replication-factor 1 --partitions 1
kafka-console-consumer --bootstrap-server localhost:9092 --topic ${TOPIC_NAME} --from-beginning

docker-compose down
