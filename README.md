# 🔐 Spring Security + JWT Application

A **Spring Boot application** demonstrating **Spring Security** with **JWT-based authentication**.  
This project integrates **MySQL** for persistent user storage and provides secure REST APIs.

---

## 🏗️ Project Structure

SpringSecurity/
├── .idea/
├── .mvn/
├── src/
│ └── main/
│ └── java/jeevansingh/
│ ├── config/ # Security configuration & JWT filter
│ ├── controller/ # REST API controllers
│ ├── model/ # Entity classes (Users, Student)
│ ├── repo/ # Repositories (if using JPA)
│ ├── service/ # Service layer (UserService, MyUserDetailsService)
│ └── JeevansinghApplication.java
│ └── resources/
│ └── application.properties
├── test/ # Unit tests
├── target/ # Compiled artifacts
├── .gitignore
├── .gitattributes
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml # Maven project file


---

## ⚙️ Prerequisites

- Java 8 or higher
- Maven
- MySQL 5.7 or higher
- MySQL Connector/J (JDBC Driver)

---

## 🗄️ Database Setup

### Create Database

```sql
CREATE DATABASE springsecurity_jwt;
USE springsecurity_jwt;
Users Table
CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL
);
Note: Passwords should be BCrypt encoded if using BCryptPasswordEncoder.

🚀 Endpoints
1. Home (Public)
URL: http://localhost:8080/home

Method: GET

Response:

"welcome to home page"
2. Register User
URL: http://localhost:8080/register

Method: POST

Request Body:

{
  "id": 1,
  "username": "testuser",
  "password": "password123"
}
Response: Returns created user object

3. Login (Authenticate)
URL: http://localhost:8080/login

Method: POST

Request Body:

{
  "username": "testuser",
  "password": "password123"
}
Response: Returns JWT token

"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
4. Get Students (Secured)
URL: http://localhost:8080/student

Method: GET

Headers:

Authorization: Bearer <JWT_TOKEN>
Response: List of students

[
  {"id":1,"name":"jeevan","age":23},
  {"id":3,"name":"jai","age":34},
  {"id":2,"name":"ram","age":54}
]
5. Add Student (Secured)
URL: http://localhost:8080/student

Method: POST

Headers:

Authorization: Bearer <JWT_TOKEN>
Request Body:

{
  "id":4,
  "name":"kiran",
  "age":21
}
Response: Returns the added student

6. Get CSRF Token (Optional)
URL: http://localhost:8080/csrf-token

Method: GET

Response: Returns CSRF token for forms

⚡ How JWT Works in This Project
User sends credentials to /login.

Server validates credentials via MyUserDetailsService.

If valid, server generates a JWT token.

Client uses the token in Authorization: Bearer <token> header for secured endpoints.

JwtFilter validates token before processing requests.

▶️ Running the Application
Update MySQL credentials in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/springsecurity_jwt
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Build & run the project:

mvn clean install
mvn spring-boot:run
Access the app at: http://localhost:8080

🎯 Key Features
JWT-based stateless authentication

Password encryption using BCrypt

Role-based secured endpoints

MySQL integration with Spring Data JPA

Modular project structure

🐛 Troubleshooting
401 Unauthorized – Add valid JWT in Authorization header

Database Connection Failed – Verify MySQL is running and credentials are correct

CSRF Issues – Disabled in this project for stateless JWT usage

📄 License
This project is for educational purposes and demonstrates Spring Security with JWT authentication and MySQL integration
