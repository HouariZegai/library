#!/bin/sh

DB_URL="jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_DATABASE}?reWriteBatchedInserts=true"
#
DB_OPTS="-Dspring.datasource.username=${DB_USERNAME} -Dspring.datasource.password=${DB_PASSWORD} -Dspring.datasource.url=${DB_URL}"
#
export JAVA_OPTIONS="${JAVA_OPTIONS:-} ${DB_OPTS}"
