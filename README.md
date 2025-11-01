# 🔐 LoginApp - Sistema de Autenticação Spring Boot (API REST)

**Desenvolvido por: Kaio Alexsander da Silva de Sá**

Este projeto é uma API RESTful simples para gerenciamento de usuários e autenticação (Login/Cadastro), construída com Spring Boot, Spring Data JPA e MySQL (via XAMPP). O objetivo é demonstrar uma arquitetura de back-end em camadas (Controller, Service, Repository) com persistência de dados.

---

## 🚀 Tecnologias Utilizadas

| Categoria | Tecnologia | Versão |
| :--- | :--- | :--- |
| **Framework** | Spring Boot | 3.x (Baseado no seu log) |
| **Linguagem** | Java | 21 (Baseado no seu log) |
| **Build** | Maven | |
| **Persistência** | Spring Data JPA (Hibernate) | |
| **Banco de Dados** | MySQL / MariaDB (via XAMPP) | |
| **Ferramenta Auxiliar** | Lombok | |

---

## 📐 Arquitetura do Projeto

O projeto segue o padrão **MVC (Model-View-Controller)**, focado no backend, com a seguinte separação de responsabilidades (camadas):

1.  **`Controller`**: Recebe requisições HTTP (`@RestController`). O `UserController` gerencia os endpoints de `/users/register` e `/users/login`.
2.  **`Service`**: Contém a lógica de negócio. O `UserService` valida dados, implementa a lógica de registro e realiza a autenticação (login).
3.  **`Model` (Entidade)**: Representação dos dados no banco de dados. A classe `User.java` é mapeada para a tabela `tb_users` no MySQL.
4.  **`Repository`**: Interface que estende `JpaRepository`, fornecendo métodos de CRUD (Create, Read, Update, Delete) prontos para a entidade `User` e métodos de consulta personalizados (como `findByUsername`).

---

## ⚙️ Como Configurar e Rodar o Projeto

Siga os passos abaixo para colocar a aplicação em funcionamento:

### 1. Configuração do Banco de Dados (XAMPP)

1.  Inicie os serviços **Apache** e **MySQL** no **XAMPP Control Panel**.
2.  Acesse o **phpMyAdmin** (`http://localhost/phpmyadmin`) e crie um banco de dados com o nome: `db_login_sistema` (conforme definido na sua configuração).

---

### 2. Configuração do Spring Boot

Localize o arquivo de configuração em `src/main/resources/application.properties` e defina as credenciais do MySQL (XAMPP):


# Configuração para XAMPP padrão
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/db_login_sistema?serverTimezone=America/Sao_Paulo&useSSL=false
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

```

# Configuração do JPA (Hibernate)
```bash
spring.jpa.hibernate.ddl-auto=update # Cria/Atualiza tabelas automaticamente
spring.jpa.show-sql=true

```
---

### 3\. Execução da Aplicação

1.  **Compile e Inicie:** Utilize o método principal (`main`) na classe `DemoApplication.java` para iniciar o servidor.

      * **Via IDE (VS Code/IntelliJ):** Clique no botão "Run" ao lado do método `main`.
      * **Via Terminal (após configurar o Maven):** `mvn spring-boot:run`

---

2.  Aguarde a mensagem no console: `Tomcat started on port 8080 (http)`.

## 🧪 Testando os Endpoints

Com a aplicação rodando, use ferramentas como **Postman** ou **Insomnia** para enviar requisições para a porta `8080`.

### 1\. Cadastro de Novo Usuário

Este endpoint registra um novo usuário na tabela `tb_users`.

| Método | URL |
| :--- | :--- |
| **`POST`** | `http://localhost:8080/users/register` |

**Corpo da Requisição (JSON):**

```json
{
    "username": "kaio_admin",
    "password": "uma_senha_forte",
    "email": "kaio.dev@exemplo.com"
}
```

### 2\. Endpoint de Login (Autenticação Simplificada)

Este endpoint simula o processo de autenticação (a implementação real de segurança com BCrypt deve ser feita na camada Service).

| Método | URL |
| :--- | :--- |
| **`POST`** | `http://localhost:8080/users/login` |

**Corpo da Requisição (JSON):**

```json
{
    "username": "kaio_admin",
    "password": "uma_senha_forte"
}
```

-----

