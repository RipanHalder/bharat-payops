# BharatPayOps AI

Production-grade event-driven payment and order reliability platform with AI Incident Copilot.

## Why I built this
To demonstrate backend engineering depth across payments, distributed systems, Kafka, idempotency, observability, and AI-assisted incident debugging.

## Tech Stack
Java 17, Spring Boot 3, PostgreSQL, Kafka, Redis, Docker, Spring Security, JWT, OpenAPI, Prometheus, Grafana, OpenTelemetry, Python FastAPI, Vector Store.

## Architecture
[diagram]

## Core Features
- Order lifecycle management
- UPI-style payment orchestration
- Idempotency keys
- Kafka event-driven workflows
- Retry and DLQ handling
- Audit ledger
- Risk rule engine
- AI incident copilot

## System Design Decisions
- Why Kafka?
- Why idempotency?
- Why outbox pattern?
- Why separate payment state?
- How duplicate payment events are handled

## How to Run
docker compose up

## API Examples
[Postman collection]

## Observability
[Grafana screenshots]

## Future Enhancements
- Kubernetes deployment
- AWS ECS/EKS deployment
- Advanced fraud scoring
- Real-time alerting