# Todo API

## Descripción

Este proyecto es una API desarrollada en Java 17 utilizando Spring Boot y está basada en una arquitectura hexagonal. La API permite gestionar tareas (tasks) y está construida con las siguientes tecnologías:

- Java 17
- Spring Boot
- Maven
- JPA (Java Persistence API)
- Hibernate
- MySQL

## Requisitos

- JDK 17
- Maven
- MySQL

## Configuración de la base de datos

Antes de ejecutar la aplicación, asegúrate de que tienes un esquema llamado `todo` en tu base de datos MySQL. Hibernate se encargará de generar las tablas necesarias automáticamente.

### Creación del esquema en MySQL

Puedes crear el esquema `todo` ejecutando el siguiente comando en tu cliente de MySQL:

```sql
CREATE DATABASE todo;
```

### Configuración de la aplicación
La configuración de la base de datos se encuentra en el archivo src/main/resources/application.properties:

```spring.datasource.url=jdbc:mysql://localhost:3306/todo?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=""
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

## Ejecución de la aplicación
Para ejecutar la aplicación, sigue estos pasos:

#### 1. Clona el repositorio:


``` 
git clone https://github.com/tu-usuario/todo-api.git
```

#### 2. Navega al directorio del proyecto:
```
cd todo-api
```

#### 3. Compila y ejecuta la aplicación usando Maven:
```
mvn spring-boot:run
```
La API estará disponible en http://localhost:8080/


## Endpoints de la API
### Crear una tarea
* URL: /api/tasks

* Método: POST

* Body:
```
{
    "title": "Título de la tarea",
    "description": "Descripción de la tarea",
    "completed": false
}
```
* Respuesta:

    * Código de estado: 201 Created.
    * Body: Task con el ID asignado y la fecha de creación.

### Obtener una tarea por ID
* URL: /api/tasks/{taskId}
* Método: GET
* Respuesta:
    * Código de estado: 200 OK si la tarea existe
    * Código de estado: 404 Not Found si la tarea no existe
    * Body: Task
        ```
        {
            "id": 2,
            "title": "titulo 2",
            "description": "descripcion 2",
            "creationDate": "2024-07-26T11:51:47.267007",
            "completed": false
        }
        ```
### Obtener todas las tareas
* URL: /api/tasks
* Método: GET
* Respuesta:
    * Código de estado: 200 OK
    * Body: List<Task>

### Actualizar una tarea
* URL: /api/tasks/{taskId}

* Método: PUT

* Body:

    ```
    {
        "title": "Título actualizado",
        "description": "Descripción actualizada",
        "completed": true
    }
    ```
* Respuesta:

    * Código de estado: 200 OK si la tarea se actualiza con éxito
    * Código de estado: 404 Not Found si la tarea no existe
    * Body: Tarea actualizada

### Eliminar una tarea
* URL: /api/tasks/{taskId}
* Método: DELETE
* Respuesta:

    * Código de estado: 200 OK si la tarea se elimina con éxito
    * Código de estado: 404 Not Found si la tarea no existe
    * Body: Boolean indicando si la eliminación fue exitosa

### Obtener información adicional de una tarea
* URL: /api/tasks/{taskId}/additionalInfo
* Método: GET
* Respuesta:
    * Código de estado: 200 OK
    * Body: AdditionalTaskInfo
    ```
    {
        "userId": 1,
        "username": "Leanne Graham",
        "userEmail": "Sincere@april.biz"
    }
    ```