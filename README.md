<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:0f2027,100:2c5364&height=200&section=header&text=Selenium%20Java%20Hybrid%20Framework&fontSize=38&fontColor=ffffff"/>
</p>

# 🚀 REST Assured API Automation Framework

A scalable, enterprise-grade REST API Automation Framework built using **Java, REST Assured, TestNG, and Maven**. The framework demonstrates modern API automation best practices including layered architecture, Builder Pattern, POJO Serialization & Deserialization, JSON Schema Validation, Data-Driven Testing, API Chaining, reusable utilities, centralized validations, reporting, and logging to deliver a maintainable, scalable, and production-ready automation solution.

![Java](https://img.shields.io/badge/Java-17-orange)
![REST Assured](https://img.shields.io/badge/REST--Assured-Latest-green)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)
![GitHub last commit](https://img.shields.io/github/last-commit/Dishi-Gogia/rest-assured-api-framework)
![GitHub Repo stars](https://img.shields.io/github/stars/Dishi-Gogia/rest-assured-api-framework?style=social)

---

# 📑 Table of Contents

- 📌 Key Highlights
- 🏗️ Tech Stack
- 🏛️ Framework Architecture
- 🎯 Framework Objectives
- 🌐 Application Under Test
- 📂 Project Structure
- ⚙️ Features
- 🧩 Design Patterns Used
- ⭐ Enterprise Features
- 🔄 API Test Coverage
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

✔️ REST Assured API Layer

✔️ Builder Pattern Implementation

✔️ Request Specification Factory

✔️ POJO Serialization

✔️ POJO Deserialization

✔️ Dynamic PATCH Request using Map

✔️ Authentication Layer

✔️ JSON Schema Validation

✔️ Data-Driven Testing using Excel

✔️ API Chaining (CRUD Workflow)

✔️ Response Validation Utilities

✔️ Extent HTML Reporting

✔️ Log4j2 Logging

✔️ Configurable Environment

✔️ Modular & Reusable Utility Classes

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

# 🏛️ Framework Architecture

```text
                 TestNG Suite
                      │
                      ▼
                Test Classes
                      │
                      ▼
              BookingAPI Layer
                      │
                      ▼
      RequestSpecificationFactory
                      │
                      ▼
              REST Assured Client
                      │
                      ▼
                 API Response
                      │
          ┌───────────┴────────────┐
          ▼                        ▼
 Response Validation      Schema Validation
          │                        │
          └────────────┬───────────┘
                       ▼
       Serialization / Deserialization
                       │
                       ▼
            Extent Reports & Log4j2
```

---

# 🎯 Framework Objectives

The framework is designed to:

- Deliver scalable REST API automation.
- Promote reusable and maintainable code.
- Demonstrate enterprise REST Assured framework design.
- Validate API contracts using JSON Schema.
- Showcase modern API automation best practices.
- Provide a portfolio-ready enterprise automation framework.
- Simplify payload creation using Builder Pattern.
- Improve framework extensibility through modular architecture.

---

# 🌐 Application Under Test

### Website

https://restful-booker.herokuapp.com

The framework automates complete REST API CRUD operations including:

- Authentication
- Create Booking
- Get Booking
- Update Booking
- Partial Update Booking (PATCH)
- Delete Booking
- Complete Booking Workflow
- JSON Schema Validation
- Response Validation
- API Chaining

# 📂 Project Structure

```text
.
├── src
│
├── test
│   ├── java
│   │
│   │── api
│   │     └── BookingAPI.java
│   │
│   │── builders
│   │     ├── AuthBuilder.java
│   │     ├── BookingBuilder.java
│   │     └── PatchBuilder.java
│   │
│   │── dataprovider
│   │     └── BookingDataProvider.java
│   │
│   │── endpoints
│   │     └── Routes.java
│   │
│   │── listeners
│   │     └── TestListener.java
│   │
│   │── models
│   │     ├── AuthRequest.java
│   │     ├── Booking.java
│   │     ├── BookingDates.java
│   │     └── BookingResponse.java
│   │
│   │── reports
│   │     └── ExtentManager.java
│   │
│   │── specifications
│   │     └── RequestSpecificationFactory.java
│   │
│   │── tests
│   │     ├── CreateBookingTest.java
│   │     ├── GetBookingTest.java
│   │     ├── UpdateBookingTest.java
│   │     ├── PartialUpdateBookingTest.java
│   │     ├── DeleteBookingTest.java
│   │     └── BookingWorkflowTest.java
│   │
│   │── utilities
│   │     ├── ConfigReader.java
│   │     ├── EnvironmentUtils.java
│   │     ├── ExcelUtils.java
│   │     ├── ExtentLogger.java
│   │     ├── JsonUtils.java
│   │     └── LoggerUtils.java
│   │
│   └── validators
│         └── ResponseValidator.java
│
├── src/test/resources
│     ├── config.properties
│     ├── log4j2.xml
│     ├── schema
│     └── testdata
│
├── testng.xml
├── pom.xml
└── README.md
```

---

# ⚙️ Features

🔥 Enterprise Layered Framework Architecture

🔥 REST Assured API Layer

🔥 Builder Pattern Implementation

🔥 Factory Pattern for Request Specifications

🔥 Authentication Module

🔥 POJO Serialization using Jackson

🔥 POJO Deserialization

🔥 Dynamic PATCH Requests using Map

🔥 Request Specification Factory

🔥 JSON Schema Validation

🔥 Centralized Response Validation

🔥 API Chaining

🔥 CRUD Workflow Automation

🔥 Excel Data-Driven Testing

🔥 Configurable Environment

🔥 Extent HTML Reporting

🔥 Log4j2 Logging

🔥 Reusable Utility Classes

🔥 Maven Dependency Management

🔥 Modular & Maintainable Framework

🔥 GitHub Portfolio Ready

---

# 🧩 Design Patterns Used

The framework follows several industry-standard design patterns to improve scalability, maintainability, and code reusability.

| Design Pattern | Purpose |
|---------------|---------|
| Builder Pattern | Reusable request payload creation |
| Factory Pattern | Centralized Request Specification creation |
| Singleton Pattern | Extent Report instance management |
| POJO Pattern | Serialization & Deserialization |
| Data Provider Pattern | Excel-based Data-Driven Testing |
| Layered Architecture | Separation of framework responsibilities |
| Utility Pattern | Reusable helper methods |

---

# ⭐ Enterprise Features

The framework has been designed following enterprise automation standards.

✔ Layered Framework Architecture

✔ Reusable API Layer

✔ Centralized Request Specifications

✔ Centralized Response Validators

✔ Dynamic Request Payload Creation

✔ Builder-based Payload Design

✔ Authentication Layer

✔ API Chaining

✔ CRUD Workflow Automation

✔ JSON Contract Validation

✔ Schema Validation

✔ Data-Driven Testing

✔ Extent HTML Reporting

✔ Log4j2 Logging

✔ Environment-based Configuration

✔ Modular & Scalable Framework Design

✔ GitHub Portfolio Ready

---

# 🔄 API Test Coverage

The framework currently automates the following REST API scenarios:

| Module | Status |
|---------|:------:|
| Authentication | ✅ |
| Create Booking | ✅ |
| Get Booking | ✅ |
| Update Booking | ✅ |
| Partial Update Booking | ✅ |
| Delete Booking | ✅ |
| Complete CRUD Workflow | ✅ |
| API Chaining | ✅ |
| JSON Schema Validation | ✅ |
| Response Validation | ✅ |
| POJO Serialization | ✅ |
| POJO Deserialization | ✅ |
| Data-Driven Testing | ✅ |
| Dynamic PATCH Request | ✅ |

---

# ✅ Prerequisites

Before running the framework, ensure the following software is installed:

- Java 17 or above
- Maven 3.8+
- Eclipse IDE / IntelliJ IDEA
- Git
- Internet Connection (for Restful Booker API)

---

# ▶️ How to Run the Framework

## 1️⃣ Clone Repository

```bash
git clone https://github.com/Dishi-Gogia/rest-assured-api-framework.git
```

---

## 2️⃣ Navigate to Project

```bash
cd rest-assured-api-framework
```

---

## 3️⃣ Install Dependencies

```bash
mvn clean install
```

---

## 4️⃣ Execute Complete Test Suite

```bash
mvn clean test
```

---

## 5️⃣ Execute TestNG Suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## 6️⃣ Execute Individual Test Classes

Examples:

```bash
CreateBookingTest

GetBookingTest

UpdateBookingTest

PartialUpdateBookingTest

DeleteBookingTest

BookingWorkflowTest
```

---

## 7️⃣ Generated Outputs

After execution, the framework automatically generates:

- 📊 Extent HTML Report
- 📄 TestNG Reports
- 📝 Log4j2 Execution Logs

> **Note:** Generated reports and logs are ignored through `.gitignore` and are not committed to the repository.

# 📊 Framework Flow

```text
                          TestNG Suite
                               │
                               ▼
                         Test Execution
                               │
                               ▼
                    Data Provider (Excel)
                               │
                               ▼
                    Builder Pattern (Payload)
                               │
                               ▼
                        API Layer (BookingAPI)
                               │
                               ▼
               RequestSpecificationFactory
                               │
                               ▼
                      REST Assured Client
                               │
                               ▼
                          API Execution
                               │
                               ▼
                           API Response
                               │
                ┌──────────────┴──────────────┐
                ▼                             ▼
       Response Validation          JSON Schema Validation
                │                             │
                └──────────────┬──────────────┘
                               ▼
                POJO Deserialization / Validation
                               │
                               ▼
                Extent Reports & Log4j2 Logging
```

---

# 🎯 Framework Design Goals

The framework has been designed with enterprise automation principles in mind.

✔ Scalable Architecture

✔ Modular Design

✔ Code Reusability

✔ Easy Maintenance

✔ Readable & Clean Code

✔ Separation of Concerns

✔ Centralized Configurations

✔ Reusable API Components

✔ Data-Driven Testing

✔ Enterprise-ready Automation Framework

✔ GitHub Portfolio Ready

---

# 📸 Execution Reports

The framework automatically generates the following execution artifacts:

- 📊 Extent HTML Report
- 📄 TestNG Reports
- 📝 Log4j2 Execution Logs

The reports provide:

- Test Execution Summary
- Pass / Fail Status
- Request Body
- Response Body
- HTTP Method
- API Endpoint
- Status Code
- Response Time
- Exception Details (if any)

> **Note:** Generated reports and logs are excluded from version control using `.gitignore`.

---

# 🚀 Why This Framework?

This project demonstrates modern enterprise API automation practices rather than simple API test scripts.

Key engineering decisions include:

- Layered framework architecture
- Builder Pattern for request payload creation
- POJO Serialization & Deserialization using Jackson
- Factory Pattern for Request Specifications
- JSON Schema Validation
- Dynamic PATCH implementation using `Map<String, Object>`
- Centralized Response Validation
- API Chaining
- Data-Driven Testing using Excel
- Reusable utility components
- Extent Reporting
- Log4j2 Logging

---

# 🔄 Future Enhancements

The following enhancements are planned for future versions:

- ✅ OAuth 2.0 Authentication Support
- ✅ Jenkins CI/CD Integration
- ✅ GitHub Actions Pipeline
- ✅ Docker Support
- ✅ Parallel Test Execution
- ✅ API Mocking (WireMock)
- ✅ Contract Testing
- ✅ Environment Profiles
- ✅ Allure Reporting
- ✅ API + UI Unified Automation Framework
- ✅ Cloud Execution Support

---

# 🔗 Related Repositories

### 🚀 Selenium Java Hybrid Automation Framework

Enterprise UI Automation Framework using Selenium WebDriver, Java, TestNG, Maven, Page Object Model (POM), Excel Data-Driven Testing, Extent Reports, and Log4j2.

---

### 🚀 Cucumber BDD Automation Framework *(Coming Soon)*

Enterprise BDD Automation Framework using Cucumber, Selenium, Java, TestNG, Maven, and Page Object Model.

---

### 🚀 Playwright Automation Framework *(Coming Soon)*

Modern Automation Framework using Playwright, Java, TypeScript, API Testing, and CI/CD.

---

### 🚀 Java for QA Engineers *(Coming Soon)*

Comprehensive Java concepts, coding exercises, collections, OOPs, exception handling, Java 8 features, and interview preparation designed specifically for QA Automation Engineers.

---

# 👩‍💻 Author

## Dishi Gogia

**Senior QA Manager | Quality Engineering | Test Automation | REST Assured | Selenium | Java | Salesforce CRM | Oracle CPQ | API Testing**

Passionate about building scalable automation frameworks and sharing practical knowledge with the QA community.

- 🌐 GitHub: https://github.com/Dishi-Gogia
- 💼 LinkedIn: https://www.linkedin.com/in/dishi-gogia

---

# 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

If you'd like to improve the framework:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Raise a Pull Request.

---

# ⭐ Support

If you found this project useful, please consider giving it a **⭐ Star**.

It helps others discover the project and motivates continued improvements.

---

# 📄 License

This project is licensed under the **MIT License**.

---

# 📌 Disclaimer

This framework was developed for **learning, portfolio, demonstration, and interview preparation** purposes.

It showcases enterprise API automation best practices using Java, REST Assured, TestNG, Maven, Builder Pattern, POJO Serialization & Deserialization, JSON Schema Validation, API Chaining, and Data-Driven Testing.

The framework is intended as a reference implementation for QA Engineers and Test Automation professionals looking to understand scalable REST API automation design.

---

## ⭐ Repository Status

![GitHub last commit](https://img.shields.io/github/last-commit/Dishi-Gogia/rest-assured-api-framework)
![GitHub repo size](https://img.shields.io/github/repo-size/Dishi-Gogia/rest-assured-api-framework)
![GitHub stars](https://img.shields.io/github/stars/Dishi-Gogia/rest-assured-api-framework?style=social)

🚀 **Built with Java • REST Assured • TestNG • Maven**
