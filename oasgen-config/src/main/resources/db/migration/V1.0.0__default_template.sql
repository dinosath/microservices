CREATE TABLE oasgen_templates
(
    id INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    downloadUrl VARCHAR(50) NOT NULL,
    fileSubDirectory VARCHAR(50) NOT NULL,
    image VARCHAR(50) NOT NULL,
    commands VARCHAR(50) NOT NULL,
);

INSERT INTO oasgen_templates(id,name,downloadUrl,outputDirectory,image,commands) VALUES (1,"quarkus","https://github.com/dinosath/openapi-generator-templates/archive/refs/heads/main.zip","openapi-generator-templates-main","maven:3-eclipse-temurin-17-alpine","mvn,package,-Pnative")
