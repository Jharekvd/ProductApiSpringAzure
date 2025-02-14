# 📌 Especificaciones de la Aplicación

## 📌 Descripción
Esta aplicación gestiona productos permitiendo operaciones CRUD (Crear, Leer, Actualizar y Eliminar). Está desarrollada en **Java con Spring Boot**(IntelliJ IDEA) y utiliza **JPA para la persistencia de datos**.
Base de datos usada **SQLServer**, **grupo de recursos** ,despligue de proyecto con **App Service**, **Git Hub Action** en **Azure**

## 📌 Tecnologías Utilizadas
- **Spring Boot** (para la arquitectura backend)
- **Spring Data JPA** (para la gestión de la base de datos)
- **Spring Validation** (para validaciones)
- **Spring Exception Handling** (para el manejo de excepciones)
- **Base de Dato** (MySQL Worbench)
- **Azure:** 
- **Base de Dato** (SQLServer)
- **Git Hub Action** (.yml)
- **Despliegue de App** (App Service)
## 📌 Funcionalidades

### 🟢 Gestión de Productos
La aplicación permite:
- Crear un producto
- Obtener un producto por su ID
- Listar todos los productos
- Actualizar un producto existente
- Eliminar un producto
- Buscar productos por nombre

### 🛠 Manejo de Excepciones
Se han definido excepciones personalizadas para manejar diferentes errores en la aplicación:
- **ProductNotFound**: Se lanza cuando un producto no es encontrado en la base de datos.
- **InvalidInputException**: Se lanza cuando un campo obligatorio es nulo o inválido.
- **MethodArgumentNotValidException**: Maneja errores de validación en los campos de entrada.
- **Exception**: Captura cualquier otro error inesperado en la aplicación.

## 📌 Arquitectura
La aplicación sigue una arquitectura basada en capas:

```
com.JjTFProducts.Producto_TareaFinal
│── Controller    # Controladores REST para manejar las solicitudes HTTP
│── Service       # Capa de negocio y lógica de la aplicación
│── Repository    # Interacción con la base de datos usando JPA
│── Model         # Definición de entidades (Product, etc.)
│── Utiles        # Excepciones personalizadas y manejadores globales
```

## 📌 Endpoints

| Método | Endpoint             | Descripción                            |
|--------|----------------------|----------------------------------------|
| POST   | `/products`           | Crea un nuevo producto                |
| GET    | `/products/{id}`      | Obtiene un producto por su ID         |
| GET    | `/products`           | Obtiene la lista de productos         |
| PUT    | `/products/{id}`      | Actualiza un producto existente       |
| DELETE | `/products/{id}`      | Elimina un producto                   |
| GET    | `/products/name/{name}` | Busca productos por nombre            |

## 📌 Ejemplo de Respuesta
Si un producto no se encuentra:
```json
{
  "timestamp": "2025-02-13T12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Producto no encontrado con ID 10",
  "path": "/products/10"
}
```

## 📌 Consideraciones de Seguridad
- Validación de datos en las solicitudes para evitar datos inconsistentes.
- Manejo de excepciones para evitar caídas inesperadas de la aplicación.
- Posibilidad de agregar autenticación y autorización con **Spring Security**.

## 📌 Futuras Mejoras
- Agregar autenticación y autorización con JWT.
- Implementar Swagger para la documentación de la API.
- Mejorar el rendimiento con caché en consultas frecuentes.

---
### 🚀 Desarrollado con Spring Boot 🚀


