# 🛠️ ServiceHub API

API RESTful desenvolvida com Spring Boot 3 para gestão e cadastro de serviços, utilizando PostgreSQL como base de dados.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA / Hibernate**
- **PostgreSQL 16**
- **Maven**

## ⚙️ Como Executar o Projeto Localmente

### Pré-requisitos
- Java 17 instalado
- PostgreSQL 16 a rodar localmente
- Base de dados criada: `servicehub_db`

### Passos
1. Clone o repositório:
bash
git clone https://github.com/joaovictor13mastercode/servicehub-api.git
2. Configure as credenciais da base de dados em `src/main/resources/application.properties`.
3. Execute a aplicação via Maven ou VS Code:
bash
./mvnw spring-boot:run
4. A API estará acessível em `http://localhost:8080`.

## 📌 Endpoints da API

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/servicos` | Listar todos os serviços |
| `GET` | `/servicos/{id}` | Buscar serviço por ID |
| `POST` | `/servicos` | Criar um novo serviço |
| `PUT` | `/servicos/{id}` | Atualizar um serviço existente |
| `DELETE` | `/servicos/{id}` | Remover um serviço |