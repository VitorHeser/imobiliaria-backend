#!/bin/bash

echo "🏠 Iniciando Sistema de Imobiliária..."
echo "======================================"

# Verificar se o Docker está rodando
if ! docker info > /dev/null 2>&1; then
    echo "❌ Docker não está rodando. Por favor, inicie o Docker Desktop."
    exit 1
fi

echo "✅ Docker está rodando"

# Verificar se o Java está instalado
if ! command -v java &> /dev/null; then
    echo "❌ Java não está instalado. Por favor, instale o Java 17."
    exit 1
fi

echo "✅ Java está instalado: $(java -version 2>&1 | head -n 1)"

# Iniciar o banco de dados
echo "🐘 Iniciando PostgreSQL..."
docker-compose up -d

# Aguardar o banco estar pronto
echo "⏳ Aguardando o banco de dados estar pronto..."
sleep 10

# Verificar se o banco está rodando
if docker ps | grep -q "imobiliaria_backend"; then
    echo "✅ PostgreSQL está rodando"
else
    echo "❌ Erro ao iniciar PostgreSQL"
    exit 1
fi

# Executar a aplicação
echo "🚀 Iniciando aplicação Spring Boot..."
echo "📱 A aplicação estará disponível em: http://localhost:8080"
echo "🛑 Pressione Ctrl+C para parar a aplicação"
echo ""

./mvnw spring-boot:run 