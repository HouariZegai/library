FROM openjdk:17-alpine

USER root

ENV APP_FILE book-api-fat.jar

ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ${JAVA_APP_DIR}/${APP_FILE}

ARG RUN_ENV_FILE=run-env.sh

COPY ${RUN_ENV_FILE} ${JAVA_APP_DIR}/
RUN chmod 755 ${JAVA_APP_DIR}/${RUN_ENV_FILE}

EXPOSE 8080