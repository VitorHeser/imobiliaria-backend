@echo off
echo 🏠 Iniciando Sistema de Imobiliária...
echo ======================================

REM Verificar se o Docker está rodando
docker info >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Docker não está rodando. Por favor, inicie o Docker Desktop.
    pause
    exit /b 1
)

echo ✅ Docker está rodando

REM Verificar se o Java está instalado
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Java não está instalado. Por favor, instale o Java 17.
    pause
    exit /b 1
)

echo ✅ Java está instalado

REM Iniciar o banco de dados
echo 🐘 Iniciando PostgreSQL...
docker-compose up -d

REM Aguardar o banco estar pronto
echo ⏳ Aguardando o banco de dados estar pronto...
timeout /t 10 /nobreak >nul

REM Verificar se o banco está rodando
docker ps | findstr "imobiliaria_backend" >nul
if %errorlevel% neq 0 (
    echo ❌ Erro ao iniciar PostgreSQL
    pause
    exit /b 1
)

echo ✅ PostgreSQL está rodando

REM Executar a aplicação
echo 🚀 Iniciando aplicação Spring Boot...
echo 📱 A aplicação estará disponível em: http://localhost:8080
echo 🛑 Pressione Ctrl+C para parar a aplicação
echo.

mvnw.cmd spring-boot:run 