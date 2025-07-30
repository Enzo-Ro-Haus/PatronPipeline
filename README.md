
# 🔄 Ejercicio: Implementación del Patrón Pipeline

## 📝 Descripción
Este proyecto es un ejercicio práctico que demuestra la implementación del Patrón de Diseño Pipeline en una aplicación Spring Boot. El sistema procesa información de contactos de usuarios a través de una serie de handlers (manejadores) que transforman y enriquecen los datos de manera secuencial.

## 🎯 Objetivo
Desarrollar una API REST que reciba un email con formato `nombre.apellido@correodenegocio.com` y, mediante el patrón Pipeline, procese la información del contacto a través de diferentes etapas de transformación.

## 🛠️ Tecnologías Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (Base de datos en memoria)
- Lombok
- Maven
- Hibernate

## 📋 Requisitos del Ejercicio
1. Implementar una API REST que reciba un email empresarial/institucional/ como parámetro.
2. Crear un pipeline que procese el contacto a través de diferentes handlers:
   - ParseEmailHandler: Extrae información del email.
   - CapitalizeNamesHandler: Capitaliza los nombres.
   - InstagramHandler: Procesa información relacionada con Instagram.
   - BuildWebHandler: Construye información web relacionada.

## 🗄️ Configuración de la Base de Datos
La aplicación utiliza H2, una base de datos en memoria, pero puede adaptalo a su base de datos. La configuración está en `application.properties`:
```
properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
```
Puedes acceder a la consola H2 en: `http://localhost:8080/h2-console`


## 🚀 Cómo Usar la API

### Endpoint para Crear Contacto
- **URL**: `/contactos`
- **Método**: POST
- **Parámetro**: `email` (query param)
- **Ejemplo de uso**:
```
bash
curl -X POST "http://localhost:8080/contactos?email=maria.hernandez@fullmascotas.com"
```
### Respuesta Esperada
La API retornará un objeto JSON con la información del contacto procesada a través del pipeline.

`
{
    "id": 1,
    "nombre": "Maria",
    "apellido": "Hernandez",
    "correo": "maria.hernandez@fullmascotas.com",
    "instagram": "@fullmascotas",
    "web": "https://fullmascotas.com"
}
`


## 💡 Ejercicio Propuesto
1. Implementar el patrón Pipeline siguiendo el ejemplo proporcionado en `PatronPipelineApplication.java`
2. Crear los diferentes handlers mencionados
3. Implementar la lógica de procesamiento en cada handler
4. Integrar el pipeline con el endpoint REST
5. Agregar validaciones y manejo de errores
6. (Opcional) Agregar nuevos handlers para extender la funcionalidad

## 🏗️ Estructura del Proyecto
```

src/
├── main/
│   ├── java/
│   │   └── com/patronpipeline/
│   │       ├── controllers/
│   │       ├── entities/
│   │       ├── services/
│   │       └── handlers/
│   └── resources/
│       └── application.properties
```
## 📚 Dependencias Maven
```
xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web-services</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.session</groupId>
            <artifactId>spring-session-jdbc</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>jakarta.ws.rs</groupId>
            <artifactId>jakarta.ws.rs-api</artifactId>
            <version>4.0.0</version>
        </dependency>
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>3.2.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>3.5.4</version>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.232</version>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>7.0.8.Final</version>
        </dependency>
    </dependencies>
```
## 📚 MUCHOS EXISTOS! 