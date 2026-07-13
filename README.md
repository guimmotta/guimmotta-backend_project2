# Sistema de Vendas (Generic DAO)

A sales management system in core Java, built around a generic DAO/Service architecture using generics, reflection, and a custom annotation to identify each entity's primary key dynamically.

## Overview

The application models clients, products, and sales, with sales enforcing business rules such as preventing modification of a completed sale and automatically recalculating totals as products are added or removed. Rather than writing a separate DAO for every entity, the project centers on a single generic, reusable persistence layer shared across all of them.

## Features

- Generic DAO and Service layers (`GenericDAO<T, E>`, `GenericService<T, E>`) shared by all entities, avoiding duplicated CRUD code
- Custom `@TipoChave` annotation combined with reflection to locate each entity's primary key at runtime, instead of hardcoding it per class
- Singleton-based in-memory storage (`SingletonMap`) shared across all DAO instances, keyed by entity type
- Custom checked exception (`TipoChaveNaoEncontradaException`) for domain-level error handling
- Rich `Venda` (sale) domain model with business rules: adding and removing products recalculates the total automatically, and a completed sale becomes immutable
- Unit tests with JUnit covering DAOs and services, using mock DAOs and a test suite (`AllTests`)

## Tech Stack

- Java
- JUnit 4
- Java Reflection API
- Design patterns: Generic DAO, Singleton, Service Layer

## Project Structure

```
backend_project2/
└── src/
    ├── main/java/
    │   ├── anotacao/
    │   │   └── TipoChave.java
    │   └── br/com/.../
    │       ├── dao/
    │       │   ├── generic/
    │       │   ├── ClienteDAO.java
    │       │   ├── ProdutoDAO.java
    │       │   └── VendaDAO.java
    │       ├── domain/
    │       │   ├── Cliente.java
    │       │   ├── Produto.java
    │       │   ├── ProdutoQuantidade.java
    │       │   └── Venda.java
    │       ├── exceptions/
    │       └── services/
    │           ├── generic/
    │           ├── ClienteService.java
    │           └── ProdutoService.java
    └── test/java/
        └── br/com/.../
            ├── ClienteDAOTest.java
            ├── ClienteServiceTest.java
            ├── ProdutoDAOTest.java
            ├── ProdutoServiceTest.java
            ├── VendaDAOTest.java
            └── AllTests.java
```

## How to Run

1. Make sure you have JDK 8 or higher installed.
2. Clone the repository and open it in IntelliJ IDEA or your IDE of choice.
3. Run the test suite (`AllTests`) to verify the DAO and service layers.

```bash
git clone https://github.com/your-username/backend_project2.git
```

## Notes

This project was developed as part of my full stack Java formation, focused on practicing generics, reflection, and reusable design patterns (Generic DAO, Singleton, Service Layer) with automated testing, as a step toward building REST APIs with Spring Boot.

## Possible Improvements

- Replace the in-memory `SingletonMap` storage with real persistence using JPA and a relational database
- Expose the sales, products, and clients services through a REST API with Spring Boot
- Add validation and tests for the `Venda` business rules (immutability after completion, total recalculation)
