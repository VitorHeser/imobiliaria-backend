#!/bin/bash
set -e

echo "🔧 Gerando schema.sql a partir das entidades JPA..."
mvn clean compile spring-boot:run -Dspring.profiles.active=ci || echo "Ignorando erro de conexão DB"
