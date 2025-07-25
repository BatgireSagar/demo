# AI-Powered Client Onboarding Automation System

## Overview
This project is a production-grade prototype for an AI-powered client onboarding automation system used in investment banking. It assists operations teams in verifying KYC (Know Your Customer) information using AI, based on client-submitted data and external/internal sources.

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

## Modules
- **Frontend**: React + TailwindCSS, modern UI, API integration
- **Backend**: Spring Boot (Java 21), REST APIs, OpenAPI docs, JPA, AI integration
- **Database**: PostgreSQL, JPA entities
- **AI Integration**: AWS Bedrock (LAGLamda-cddGen)
- **Orchestration**: Camunda 8 BPMN workflow
- **DevOps**: Docker Compose for local development

## Setup Instructions

### Prerequisites
- Docker & Docker Compose
- Java 21, Maven (for backend dev)
- Node.js, npm (for frontend dev)

### 1. Clone the Repository
```bash
git clone <repo-url>
cd <repo-root>
```

### 2. Run with Docker Compose
```bash
docker-compose up --build
```
- This will start backend, frontend, PostgreSQL, and Camunda.

### 3. Backend (Spring Boot)
- API docs available at: `http://localhost:8080/swagger-ui.html`
- Main endpoints:
  - `POST /api/client/capture` – Submit CDD info
  - `GET /api/data/compare/{caseId}` – Compare data
  - `POST /api/ai/analyze` – AI analysis
  - `POST /api/contact-client/{caseId}` – Contact client
  - `GET /api/journey/decision/{caseId}` – Journey recommendation

### 4. Frontend (React)
- Runs on `http://localhost:3000`
- Modern UI for operations teams

### 5. Database (PostgreSQL)
- Connection: `postgres:postgres@postgres:5432/onboarding`
- Tables auto-created by JPA

### 6. Camunda 8
- BPMN workflow for onboarding automation
- Camunda UI: `http://localhost:8081` (if mapped)

### 7. AI Integration
- AWS Bedrock (LAGLamda-cddGen) integration in backend
- Configure credentials in `backend/src/main/resources/application.yaml`

## Development Workflow
- Backend: Standard Spring Boot dev cycle
- Frontend: Standard React dev cycle
- Database: Use Docker or local PostgreSQL
- Camunda: Model BPMN in `camunda/onboarding.bpmn`

## API Documentation
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI annotations in all controllers

## Contributing
- PRs welcome! Please follow code style and add tests where possible.

---

For detailed module documentation, see the `/docs` folder (to be created for extended docs).