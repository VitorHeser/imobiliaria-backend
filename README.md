# 🏠 Sistema de Imobiliária - Backend

Este é o backend de um sistema de controle de imobiliárias desenvolvido em **Spring Boot** com **Java 17**.

## 📋 Pré-requisitos

Antes de começar, você precisa ter instalado no seu computador:

### 1. Docker Desktop
- **Windows/Mac**: Baixe e instale o [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- **Linux**: Instale o Docker Engine seguindo a [documentação oficial](https://docs.docker.com/engine/install/)

### 2. Java 17 (JDK)
- **Windows**: Baixe o [OpenJDK 17](https://adoptium.net/) ou use o [Oracle JDK](https://www.oracle.com/java/technologies/downloads/#java17)
- **Mac**: Use o Homebrew: `brew install openjdk@17`
- **Linux**: `sudo apt install openjdk-17-jdk` (Ubuntu/Debian)

### 3. Maven
- **Windows**: Baixe o [Maven](https://maven.apache.org/download.cgi) e configure as variáveis de ambiente
- **Mac**: `brew install maven`
- **Linux**: `sudo apt install maven` (Ubuntu/Debian)

## 🚀 Como Executar o Projeto

### Passo 1: Clone o Repositório
```bash
git clone [URL_DO_SEU_REPOSITORIO]
cd imobiliaria-backend
```

### Passo 2: Inicie o Banco de Dados com Docker
```bash
docker-compose up -d
```

**O que este comando faz:**
- Cria um container PostgreSQL na porta 5432
- Configura o banco de dados `imobiliaria_db`
- Usuário: `imobiliaria`
- Senha: `imobiliaria`

### Passo 3: Verifique se o Banco Está Rodando
```bash
docker ps
```

Você deve ver um container chamado `imobiliaria_backend` rodando.

### Passo 4: Execute a Aplicação
```bash
./mvnw spring-boot:run
```

**Ou se você estiver no Windows:**
```bash
mvnw.cmd spring-boot:run
```

### Passo 5: Acesse a Aplicação
A aplicação estará disponível em: **http://localhost:8080**

## ⚡ Inicialização Rápida (Scripts)

Para facilitar ainda mais, você pode usar os scripts de inicialização:

### Linux/Mac:
```bash
./start.sh
```

### Windows:
```cmd
start.bat
```

**O que os scripts fazem:**
- ✅ Verificam se o Docker está rodando
- ✅ Verificam se o Java está instalado
- ✅ Iniciam o PostgreSQL automaticamente
- ✅ Aguardam o banco estar pronto
- ✅ Iniciam a aplicação Spring Boot

## 🔧 Configurações do Projeto

### Banco de Dados
- **Tipo**: PostgreSQL 15
- **Host**: localhost
- **Porta**: 5432
- **Database**: imobiliaria_db
- **Usuário**: imobiliaria
- **Senha**: imobiliaria

### Aplicação Spring Boot
- **Porta**: 8080
- **Java**: 17
- **Framework**: Spring Boot 3.5.3

## ⚙️ Configurações Personalizadas

Se você quiser personalizar as configurações, pode:

1. **Copiar o arquivo de exemplo:**
   ```bash
   cp config.example.properties config.properties
   ```

2. **Editar as configurações** no arquivo `config.properties`

3. **Usar variáveis de ambiente** para sobrescrever configurações:
   ```bash
   export DB_PASSWORD=sua_senha_segura
   export APP_PORT=9090
   ```

## 📁 Estrutura do Projeto

```
imobiliaria-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/heserproject/imobiliaria/
│   │   │       └── ImobiliariaApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
├── docker-compose.yml
├── docker-compose.full.yml
├── Dockerfile
├── .dockerignore
├── start.sh
├── start.bat
├── config.example.properties
├── pom.xml
└── README.md
```

## 🐳 Containerização (Opcional)

O projeto inclui um `Dockerfile` para containerizar a aplicação completa. Isso é útil para:

- **Deploy em produção**
- **Ambientes de desenvolvimento isolados**
- **CI/CD pipelines**

### Como usar o Dockerfile:

```bash
# Construir a imagem
docker build -t imobiliaria-app .

# Executar o container (certifique-se de que o banco está rodando)
docker run -p 8080:8080 --name imobiliaria-app imobiliaria-app

# Ou usar docker-compose para tudo (incluindo banco)
docker-compose -f docker-compose.full.yml up -d
```

### Opções de Execução:

1. **Apenas banco com Docker + aplicação local** (recomendado para desenvolvimento):
   ```bash
   docker-compose up -d
   ./mvnw spring-boot:run
   ```

2. **Tudo containerizado** (recomendado para produção):
   ```bash
   docker-compose -f docker-compose.full.yml up -d
   ```

## 🛠️ Comandos Úteis

### Docker
```bash
# Iniciar o banco de dados
docker-compose up -d

# Parar o banco de dados
docker-compose down

# Ver logs do banco
docker-compose logs postgres

# Remover tudo (incluindo dados)
docker-compose down -v

# Containerizar a aplicação completa (opcional)
docker build -t imobiliaria-app .
docker run -p 8080:8080 --name imobiliaria-app imobiliaria-app
```

### Maven
```bash
# Compilar o projeto
./mvnw compile

# Executar testes
./mvnw test

# Limpar e compilar
./mvnw clean compile

# Executar a aplicação
./mvnw spring-boot:run
```

## 🔍 Troubleshooting

### Problema: "Porta 5432 já está em uso"
**Solução:**
```bash
# Pare outros serviços PostgreSQL
sudo service postgresql stop

# Ou use uma porta diferente no docker-compose.yml
ports:
  - "5433:5432"  # Mude para 5433
```

### Problema: "Docker não está rodando"
**Solução:**
- Abra o Docker Desktop
- Aguarde até aparecer "Docker Desktop is running"
- Execute `docker ps` para verificar

### Problema: "Java não encontrado"
**Solução:**
```bash
# Verifique se o Java está instalado
java -version

# Se não estiver, instale o Java 17
# Windows: Baixe do site oficial
# Mac: brew install openjdk@17
# Linux: sudo apt install openjdk-17-jdk
```

### Problema: "Maven não encontrado"
**Solução:**
```bash
# Use o Maven Wrapper (já incluído no projeto)
./mvnw --version

# Ou instale o Maven globalmente
# Mac: brew install maven
# Linux: sudo apt install maven
```

## 📝 Próximos Passos

1. **Configurar o banco de dados**: Adicione as configurações de conexão no `application.properties`
2. **Criar entidades**: Desenvolva os modelos de dados (Clientes, Imóveis, etc.)
3. **Implementar APIs**: Crie os controllers REST
4. **Adicionar validações**: Implemente regras de negócio
5. **Configurar segurança**: Adicione autenticação e autorização

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📞 Suporte

Se você encontrar algum problema ou tiver dúvidas:

1. Verifique se todos os pré-requisitos estão instalados
2. Confirme se o Docker está rodando
3. Verifique os logs da aplicação
4. Abra uma issue no repositório

---

**Desenvolvido com ❤️ usando Spring Boot**
