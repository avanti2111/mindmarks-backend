📌 MindMarks — Smart Bookmark Organizer

MindMarks is a personal bookmark management backend built with Spring Boot, allowing users to save links, organize them into collections, add notes, and search bookmarks securely using JWT authentication.

Deployed live on Render and backed by a Neon (PostgreSQL) database.

🚀 Features

🔐 User Authentication

Register & Login

Secure JWT-based authentication

🔖 Bookmark Management

Create bookmarks (with or without collections)

Add notes explaining why you saved a link

User-level access (each user sees only their bookmarks)

🗂️ Collections

Optional grouping of bookmarks

🔍 Search

Search bookmarks by title + notes

☁️ Cloud Ready

PostgreSQL (Neon DB)

Deployed on Render

🏗️ Architecture Overview

┌──────────────┐
│   Client     │
│ (Postman/UI) │
└──────┬───────┘
       │ HTTP (JSON)
       ▼
┌─────────────────────────┐
│   Spring Boot Backend   │
│                         │
│ ┌─────────────────────┐│
│ │ Auth Controller     ││
│ │ - Register/Login    ││
│ └─────────────────────┘│
│                         │
│ ┌─────────────────────┐│
│ │ Bookmark Controller ││
│ │ - CRUD              ││
│ │ - Search            ││
│ └─────────────────────┘│
│                         │
│ ┌─────────────────────┐│
│ │ Spring Security     ││
│ │ - JWT Filter        ││
│ │ - User Context      ││
│ └─────────────────────┘│
│                         │
│ ┌─────────────────────┐│
│ │ Service Layer       ││
│ │ - Business Logic    ││
│ └─────────────────────┘│
│                         │
│ ┌─────────────────────┐│
│ │ JPA Repositories    ││
│ └─────────────────────┘│
└──────────┬──────────────┘
           │
           ▼
┌─────────────────────────┐
│   PostgreSQL (Neon DB)  │
│ - users                │
│ - bookmarks            │
│ - collections          │
└─────────────────────────┘

👩‍💻 Author

Avanti Tambe
Backend Engineer | Java | Spring Boot | AWS
