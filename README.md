# 📌 MindMarks — Smart Bookmark Organizer

**MindMarks** is a secure, backend-first bookmark management system built with **Spring Boot**.  
It allows users to save, organize, and search bookmarks, optionally group them into collections, and attach notes explaining why a link was saved — all protected with **JWT-based authentication**.

The application is **deployed on Render** and uses **Neon (PostgreSQL)** as its cloud database.

---

## 🚀 Features

### 🔐 User Authentication
- User registration and login
- Secure JWT-based authentication
- Stateless authorization using Spring Security

---

### 🔖 Bookmark Management
- Create bookmarks with title, URL, and notes
- Optional association with collections
- User-level data isolation (users can only access their own bookmarks)

---

### 🗂️ Collections
- Group related bookmarks into collections
- Flexible organization (bookmarks can exist with or without collections)

---

### 🔍 Search
- Search bookmarks by title and notes
- Fast and user-scoped search results

---

### ☁️ Cloud Ready
- PostgreSQL hosted on **Neon**
- Backend deployed on **Render**
- Environment-based configuration for secrets and database credentials

---

## 🏗️ Architecture Overview

![Architecture Diagram](https://github.com/user-attachments/assets/f262cf75-59b8-453c-abad-1d8fd6510e99)

**High-level flow:**
- Client → REST APIs (Spring Boot)
- Authentication via JWT
- Business logic handled in service layer
- Data persisted in PostgreSQL (Neon)
- Deployed and hosted on Render

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security + JWT**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL (Neon)**
- **Render (Deployment)**
- **Maven**

---

## 👩‍💻 Author

**Avanti Tambe**  
Backend Engineer  
Java • Spring Boot • Cloud-Native Backend Systems

