# Rotiseria App

Sistema backend para gestionar productos, clientes y pedidos de una rotiseria.

El proyecto se construye como practica integradora de Laboratorio de Software, aplicando Java, Maven, Spring Boot, MVC, JPA, Hibernate y patrones de diseno.

## Tecnologias

- Java 17
- Maven
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- H2 Database

## Estructura inicial

```text
controller -> recibe requests HTTP
service    -> contiene reglas de negocio
repository -> acceso a datos con JPA
model      -> entidades del dominio
strategy   -> comportamientos intercambiables
```

## Como ejecutar

```bash
./mvnw spring-boot:run
```

En Windows PowerShell o CMD:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicacion levanta en:

```text
http://localhost:8080
```

