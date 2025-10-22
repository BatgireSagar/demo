# AI-Powered Client Onboarding Automation System

## Overview
This project is a production-grade prototype for an AI-powered client onboarding automation system used in investment banking. It assists operations teams in verifying KYC (Know Your Customer) information using AI, based on client-submitted data and external/internal sources.

---

## Architecture
```
+-----------+        +-----------+        +-----------------+
|  Frontend | <----> |  Backend  | <----> |  PostgreSQL DB  |
|  (React)  |        | (Spring)  |        +-----------------+
+-----------+        |           |        +-----------------+
                     |           | <----> |   Camunda 8     |
                     |           |        +-----------------+
                     |           | <----> | AWS Bedrock AI  |
                     +-----------+        +-----------------+
```

---

## Prerequisites
- **Docker** and **Docker Compose** (recommended for local development)
- **Java 21** and **Maven** (for backend development)
- **Node.js** (>=18) and **npm** (for frontend development)
- **AWS credentials** (for Bedrock integration, optional for local dev)

---

## Project Structure
```
/workspace/
├── backend/           # Spring Boot backend
├── frontend/          # React + TailwindCSS frontend
├── camunda/           # BPMN workflow files
├── docker-compose.yaml
├── README.md
```

---

## 1. Clone the Repository
```bash
git clone <repo-url>
cd <repo-root>
```

---

## 2. Environment Variables & Configuration

### Backend (`backend/src/main/resources/application.yaml`)
- **PostgreSQL**: Connection string, username, password
- **AWS Bedrock**: Region, access key, secret key, model ID (LAGLamda-cddGen)
- **Camunda**: Zeebe client config

Example:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://postgres:5432/onboarding
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

bedrock:
  region: us-east-1
  access-key: YOUR_AWS_ACCESS_KEY
  secret-key: YOUR_AWS_SECRET_KEY
  model-id: LAGLamda-cddGen

camunda:
  zeebe:
    client:
      broker:
        gateway-address: camunda:26500
      security:
        plaintext: true
```

---

## 3. Running with Docker Compose (Recommended)

### Start All Services
```bash
docker-compose up --build
```
This will start:
- **Backend** (Spring Boot, port 8080)
- **Frontend** (React, port 3000)
- **PostgreSQL** (port 5432)
- **Camunda 8** (if included in compose)

### Stopping
```bash
docker-compose down
```

---

## 4. Running Backend Locally (Without Docker)

### 1. Setup PostgreSQL
- Ensure PostgreSQL is running locally or via Docker
- Create a database named `onboarding` (or use the default in `application.yaml`)

### 2. Build and Run Backend
```bash
cd backend
mvn clean package
java -jar target/backend-1.0-SNAPSHOT.jar
```
- API available at: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 5. Running Frontend Locally (Without Docker)
```bash
cd frontend
npm install
npm start
```
- App available at: `http://localhost:3000`

---

## 6. Database Details
- **Default user:** `postgres`
- **Default password:** `postgres`
- **Default DB:** `onboarding`
- **Tables:**
  - `client_info`
  - `companies_house_data`
  - `customer_system_data`
  - `ai_results`
  - `case_journey`
- Tables are auto-created by JPA on first run.

---

## 7. Camunda Orchestration
- BPMN files in `/camunda/onboarding.bpmn`
- Camunda Zeebe client configured in backend
- Camunda UI (if mapped): `http://localhost:8081`

---

## 8. AI Integration (AWS Bedrock)
- Model: `LAGLamda-cddGen`
- Configure AWS credentials in `application.yaml`
- For local/mock development, the AI service returns a stubbed response

---

## 9. API Documentation
- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- All endpoints are annotated with OpenAPI for easy testing

---

## 10. Troubleshooting
- **Ports in use:** Make sure 5432 (Postgres), 8080 (backend), 3000 (frontend) are free
- **Database connection errors:** Check Docker Compose logs or your local Postgres instance
- **AWS errors:** Ensure credentials are set if using real Bedrock integration
- **Camunda not connecting:** Check Zeebe config in `application.yaml`

---

## 11. Development Workflow
- **Backend:**
  - Edit code in `backend/`, use `mvn spring-boot:run` for hot reload
- **Frontend:**
  - Edit code in `frontend/`, use `npm start` for hot reload
- **Database:**
  - Use Docker or local Postgres, tables auto-created
- **Camunda:**
  - Model BPMN in `/camunda/onboarding.bpmn`

---

## 12. Contributing
- PRs welcome! Please follow code style and add tests where possible.

---

## 13. Support
For issues, please open a GitHub issue or contact the maintainer.