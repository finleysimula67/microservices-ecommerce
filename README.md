
---

# Microservices E-commerce Platform

## 📋 Overview

A scalable e-commerce platform built with **Java Spring Boot**. This project implements a distributed microservices architecture to manage online shopping operations independently. It is designed to demonstrate best practices in backend development, containerized infrastructure, and database management.

## 🏗️ System Architecture

The application is structured as a **Monorepo**, where each microservice is developed and managed within its own directory for better coordination and simplified deployment.

## 🛠️ Tech Stack

* **Language:** Java 25
* **Framework:** Spring Boot 4.0.7
* **Data Layer:** PostgreSQL with Spring Data JPA/Hibernate
* **Infrastructure:** Docker & Docker Compose
* **Build Tool:** Maven

## 🚀 Getting Started

### Prerequisites

* [Docker Desktop](https://www.docker.com/products/docker-desktop/) (must be running)
* [JDK 25](https://adoptium.net/)

### Installation

1. Clone this repository:
```bash
git clone https://github.com/finleysimula67/microservices-ecommerce.git

```


2. Navigate to the project root:
```bash
cd microservices-ecommerce

```



### Running the Services

1. **Start Infrastructure:** Use Docker Compose to spin up your PostgreSQL databases:
```bash
docker compose up -d

```


2. **Run Services:** Navigate to your specific service folder and start it via the Maven wrapper:
```bash
cd product-service
.\mvnw spring-boot:run

```



## 📂 Project Structure

```text
microservices-ecommerce/
├── .git/                 # Git tracking
├── .gitignore            # Excludes build artifacts and IDE files
├── docker-compose.yml    # Infrastructure orchestration
├── LICENSE               # MIT License
├── README.md             # Project documentation
└── product-service/      # Current active microservice

```

## ⚖️ License

This project is licensed under the **MIT License**. See the `LICENSE` file for more information.

---

### How to push this update:

1. Save the above text into your `README.md` file.
2. Run the following commands in your terminal:
```powershell
git add README.md
git commit -m "docs: update professional README.md"
git push origin main

```