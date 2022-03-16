#!/bin/bash
./gradlew build

java \
  -javaagent:dd-java-agent.jar \
  -Ddd.logs.injection=true \
  -Ddd.service=my-project-app \
  -Ddd.env=dev \
  -jar build/libs/spring-dd-agent-0.0.1-SNAPSHOT.jar