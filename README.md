# 🚛 Fleet Management System (Enterprise Grade)

An advanced full-stack application for managing vehicle fleets, drivers, and trip logistics. Built to demonstrate **Enterprise Software Architecture** principles including Automation, Aspect-Oriented Programming (AOP), and Role-Based Access Control (RBAC).

## 🚀 Key Features (Technical Highlights)

### 1. 🤖 Automated Background Tasks (The Scheduler)
- **Problem:** Manual tracking of trips is error-prone and slow.
- **Solution:** Implemented a **Spring Scheduler** (`@Scheduled`) that runs every 10 seconds to monitor trip lifecycles. It automatically detects expired trips and updates their status to "Completed" in the database without human intervention.

### 2. 🛡️ Professional Audit Logging (AOP)
- **Problem:** Writing `System.out.println` mixes business logic with logging code (tight coupling).
- **Solution:** Used **Aspect-Oriented Programming (AOP)** to decouple logging. An `Aspect` intercepts service layer execution to provide a centralized audit trail of all system activities.

### 3. 🔐 Security & Robustness
- **RBAC:** Secured using **Spring Security** with role-based access (Admins vs. Regular Users).
- **Validation:** Implemented **Java Bean Validation** (`@NotNull`, `@Size`) to ensure data integrity and prevent SQL injection/bad data entry.
- **Unit Testing:** Business logic is verified using **JUnit 5** and **Mockito**.

## 🛠️ Tech Stack
- **Backend:** Java 21, Spring Boot 3.3.0
- **Frontend:** Thymeleaf (Server-side rendering), HTML5, Bootstrap
- **Database:** MySQL
- **Tools:** Maven, Lombok, Spring Actuator, Swagger UI

## ⚙️ How to Run Locally

1. **Clone the Repo**
   ```bash
   git clone [https://github.com/phemlata/Fleet_Management_System.git](https://github.com/phemlata/Fleet_Management_System.git)
   cd Fleet_Management_System
