# Conceito de Microserviços
 Escopo de microservices em Java com Spring aplicando conceitos de escalbilidade utilizando:
   - Java 17
   - Spring Boot 3
   - Service Registry (Eureka)
   - Feign Client
   - Load Balance
   - API Gateway
   - Documentação com Swagger (OpenAPI v2.2.0)
   - Mysql (v8.0.32)
   - Flyway
   - Spring Data JPA

 ## Urls:
 - Eureka (Naming Server) --> http://localhost:8761/
 - API Gateway Swagger    --> http://localhost:8765/swagger-ui/index.html
 - API Gateway Cambio     --> http://localhost:8765/cambio-service/{amount}/{original_currency}/{to_currency}
 - API Gateway Book       --> http://localhost:8765/book-service/{amount}/{to_currency}
 - Cambio Microservice    --> http://localhost:8001/cambio-service/{amount}/{original_currency}/{to_currency}
 - Book Microservice      --> http://localhost:8100/book-service/{amount}/{to_currency}
