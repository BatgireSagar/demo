# Backend – AI Onboarding System

## Overview
Spring Boot backend for the AI-powered client onboarding automation system. Exposes REST APIs, integrates with PostgreSQL, Camunda, and AWS Bedrock.

## Main Modules
- Entities & JPA Repositories
- DTOs for API and service layers
- REST Controllers (OpenAPI annotated)
- AI Service (Bedrock integration)
- Camunda workflow integration

## How to Run
```bash
cd backend
mvn clean package
java -jar target/backend-1.0-SNAPSHOT.jar
```

## Configuration
- Edit `src/main/resources/application.yaml` for DB, AWS, and Camunda settings.

## API Endpoints
- `POST /api/client/capture` – Submit CDD info
- `GET /api/data/compare/{caseId}` – Compare data
- `POST /api/ai/analyze` – AI analysis
- `POST /api/contact-client/{caseId}` – Contact client
- `GET /api/journey/decision/{caseId}` – Journey recommendation

## API Docs
- Swagger UI: `http://localhost:8080/swagger-ui.html`

## AWS Bedrock Integration
- Configure credentials in `application.yaml`
- Uses model: `LAGLamda-cddGen`

## Camunda Integration
- BPMN file: `../camunda/onboarding.bpmn`
- Camunda Zeebe client configured in `application.yaml`

---
For more details, see the top-level README.