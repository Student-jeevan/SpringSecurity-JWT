# 🔐 Spring Boot JWT Authentication API: jeevansingh

This is a **stateless REST API backend** built on **Spring Boot** and **Spring Security** that utilizes **JSON Web Tokens (JWT)** for secure, token-based authentication and authorization.

## 🛠️ Tech Stack & Configuration

| Technology | Role |
| :--- | :--- |
| **Spring Boot** | Application Framework |
| **Spring Security 6+** | Authentication & Authorization |
| **JWT** | Stateless Authentication Tokens |
| **MySQL** | Persistent Database Storage |
| **Spring Data JPA** | Data Access / ORM |
| **Lombok** | Boilerplate code reduction |

---

## 🌐 API Endpoints

The API base URL is `http://localhost:8080`.

### Authentication & Public Endpoints (No JWT Required)

These endpoints handle user creation and token retrieval.

| Method | URL | Description |
| :--- | :--- | :--- |
| `POST` | `/register` | Creates a new user account with a hashed password. |
| `POST` | `/login` | Authenticates the user and returns the **JWT** string on success. |
| `GET` | `/home` | Simple public welcome message. |

### Secured Resource Endpoints (JWT Required)

To access these, you must include the JWT in the request header: **`Authorization: Bearer <token>`**.

| Method | URL | Description |
| :--- | :--- | :--- |
| `GET` | `/student` | Retrieves the list of sample students. |
| `POST` | `/student` | Adds a new student record to the list. |
| `*` | **All Other Endpoints** | Any request not explicitly listed above is secured by default. |

---
### 🌐 Full API Endpoint URLs

| Endpoint Type | Method | Path | Full Local URL (Assuming port 8080) | Authentication Required? |
| :--- | :--- | :--- | :--- | :--- |
| **Public** | `POST` | `/register` | `http://localhost:8080/register` | No |
| **Public** | `POST` | `/login` | `http://localhost:8080/login` | No |
| **Public** | `GET` | `/home` | `http://localhost:8080/home` | No |
| **Secured** | `GET` | `/student` | `http://localhost:8080/student` | **Yes** (Requires JWT) |
| **Secured** | `POST` | `/student` | `http://localhost:8080/student` | **Yes** (Requires JWT) |
| **Secured** | `GET` | `/csrf-token` | `http://localhost:8080/csrf-token` | **Yes** (Requires JWT) |

***

**Note on Secured Endpoints:** Requests to secured paths must include a valid JWT in the `Authorization` header, formatted as: `Authorization: Bearer <your_jwt_token_here>`.

## 💡 Authentication Flow Overview

The security is based on a stateless JWT approach:

1.  A successful **`POST /login`** request returns a **JWT** (JSON Web Token).
2.  The client stores this token and includes it in the `Authorization: Bearer <token>` header for subsequent requests to secured endpoints (like `/student`).
3.  The **`JwtFilter`** intercepts these requests, validates the token, and grants access if the token is valid.
4. 
