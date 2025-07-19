"token de prueba": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc1Mjc5NDgyMCwiZXhwIjoxNzUyODgxMjIwfQ.6_pgp5vZDyxhlaDEyGYcrMW_jU7uap0tvesWq4KPKAI"

Balanceo de carga:
.\mvnw spring-boot:run -D"spring-boot.run.profiles"="instancia1"

.\mvnw spring-boot:run -D"spring-boot.run.profiles"="instancia2"

.\mvnw spring-boot:run -D"spring-boot.run.profiles"="cliente"
