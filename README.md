# 🚀 REST Assured API Automation Framework

A scalable and enterprise-grade REST API Automation Framework built using **Java, REST Assured, TestNG, and Maven**. The framework follows industry best practices including Builder Pattern, POJO Serialization & Deserialization, JSON Schema Validation, Data-Driven Testing, API Chaining, reusable utilities, reporting, logging, and modular architecture to support maintainable and scalable API automation.

![Java](https://img.shields.io/badge/Java-17-orange)
![REST Assured](https://img.shields.io/badge/REST--Assured-Latest-green)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

# 📑 Table of Contents

- 📌 Key Highlights
- 🏗️ Tech Stack
- 🎯 Framework Objectives
- 🌐 Application Under Test
- 📂 Project Structure
- ⚙️ Features
- 🔄 API Automation Coverage
- ✅ Prerequisites
- ▶️ How to Run the Framework
- 📊 Framework Flow
- 🎯 Framework Design Goals
- 📸 Execution Reports
- 🔄 Future Enhancements
- 🔗 Related Repositories
- 👩‍💻 Author
- 📄 License

---

# 📌 Key Highlights

✔️ Enterprise Layered Framework Architecture

✔️ Builder Pattern Implementation

✔️ REST Assured Request Specification

✔️ POJO Serialization

✔️ POJO Deserialization

✔️ Dynamic PATCH Request using Map

✔️ JSON Schema Validation

✔️ Data-Driven Testing using Excel

✔️ API Chaining (CRUD Workflow)

✔️ Response Validation Utilities

✔️ Extent HTML Reporting

✔️ Log4j2 Logging

✔️ Configurable Environment

✔️ Modular & Reusable Utilities

✔️ Enterprise-ready Folder Structure

---

# 🏗️ Tech Stack

| Component | Technology |
|-----------|------------|
| Programming Language | Java |
| API Automation | REST Assured |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Builder Pattern |
| Serialization | Jackson POJO |
| Schema Validation | JSON Schema Validator |
| Test Data | Excel (Apache POI) |
| Reporting | Extent Reports |
| Logging | Log4j2 |
| Configuration | Properties File |
| Version Control | Git & GitHub |
| IDE | Eclipse / IntelliJ IDEA |

---

# 🎯 Framework Objectives

The framework is designed to:

- Deliver scalable API automation.
- Promote reusable and maintainable code.
- Demonstrate enterprise REST Assured framework design.
- Support contract validation using JSON Schema.
- Showcase industry best practices for API testing.
- Provide a portfolio-ready automation framework.

---

# 🌐 Application Under Test

**Website**

https://restful-booker.herokuapp.com

The framework automates complete CRUD operations including:

- Authentication
- Create Booking
- Get Booking
- Update Booking
- Partial Update Booking
- Delete Booking
- Complete Booking Workflow
- Schema Validation
- Response Validation

---

# 📂 Project Structure

```text
.
├── src
│
├── test
│   ├── java
│   │   ├── api
│   │   ├── builders
│   │   ├── dataprovider
│   │   ├── endpoints
│   │   ├── listeners
│   │   ├── models
│   │   ├── reports
│   │   ├── specifications
│   │   ├── tests
│   │   ├── utilities
│   │   └── validators
│   │
│   └── resources
│       ├── schema
│       ├── testdata
│       ├── config.properties
│       └── log4j2.xml
│
├── pom.xml
├── testng.xml
└── README.md
```

---

# ⚙️ Features

🔥 Layered Framework Design

🔥 Builder Pattern

🔥 Request Specification Factory

🔥 POJO Serialization

🔥 POJO Deserialization

🔥 Dynamic PATCH Requests

🔥 JSON Schema Validation

🔥 Response Validation

🔥 Excel Data-Driven Testing

🔥 API Chaining

🔥 Extent HTML Reports

🔥 Log4j2 Logging

🔥 Configurable Environment

🔥 Reusable Utility Classes

🔥 Maven Dependency Management

🔥 Enterprise-ready Framework

---

# 🔄 API Automation Coverage

The framework currently automates:

✅ Authentication

✅ Create Booking

✅ Get Booking

✅ Update Booking

✅ Partial Update Booking

✅ Delete Booking

✅ CRUD Workflow Testing

✅ Schema Validation

✅ Response Validation

---

# ✅ Prerequisites

- Java 17 or above
- Maven 3.8+
- Eclipse / IntelliJ IDEA
- Git

---

# ▶️ How to Run the Framework

## Clone Repository

```bash
git clone https://github.com/Dishi-Gogia/rest-assured-api-framework.git
```

## Navigate to Project

```bash
cd rest-assured-api-framework
```

## Install Dependencies

```bash
mvn clean install
```

## Execute Tests

```bash
mvn clean test
```

## Execute TestNG Suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

# 📊 Framework Flow

```text
            TestNG Suite
                 │
                 ▼
          Test Execution
                 │
                 ▼
            Builder Pattern
                 │
                 ▼
          Request Specification
                 │
                 ▼
          REST Assured API
                 │
                 ▼
         Response Validation
                 │
                 ▼
        Schema Validation
                 │
                 ▼
      Serialization / Deserialization
                 │
                 ▼
         Extent Report & Logs
```

---

# 🎯 Framework Design Goals

- Scalability
- Reusability
- Maintainability
- Readability
- Modular Architecture
- Enterprise-ready API Automation

---

# 📸 Execution Reports

The framework automatically generates:

- Extent HTML Reports
- TestNG Reports
- Log4j2 Execution Logs

> **Note:** Generated reports and logs are excluded from Git using `.gitignore`.

---

# 🔄 Future Enhancements

- ✅ Jenkins CI/CD Integration
- ✅ GitHub Actions
- ✅ Docker Support
- ✅ Parallel Execution
- ✅ API Mocking
- ✅ Allure Reporting
- ✅ Environment Profiles
- ✅ OAuth 2.0 Framework
- ✅ API + UI Integrated Framework

---

# 🔗 Related Repositories

- Selenium Java Hybrid Automation Framework
- Cucumber BDD Framework
- REST Assured API Automation Framework
- Playwright Framework *(Coming Soon)*
- Java for QA Engineers *(Coming Soon)*

---

# 👩‍💻 Author

## Dishi Gogia

**Senior QA Manager | Quality Engineering | Selenium | REST Assured | Java | Salesforce CRM | Oracle CPQ | API Testing**

- **GitHub:** https://github.com/Dishi-Gogia
- **LinkedIn:** https://www.linkedin.com/in/dishi-gogia

---

# 📄 License

This project is licensed under the **MIT License**.

---

# ⭐ Support

If you found this project useful, consider giving it a **Star ⭐**.

Feedback, suggestions, and contributions are always welcome.

---

# 📌 Disclaimer

This project was developed for learning, demonstration, portfolio, and interview preparation purposes to showcase enterprise API automation framework design and best practices using Java, REST Assured, TestNG, Maven, Builder Pattern, JSON Schema Validation, and Data-Driven Testing.
