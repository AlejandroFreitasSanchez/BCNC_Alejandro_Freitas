# Prueba Técnica Alejandro Freitas Sánchez - BCNC

Este proyecto es una solución de ejemplo para la prueba técnica de **BCNC**. Implementa una API REST utilizando **Java Spring Boot** con una arquitectura hexagonal, diseñada para ser modular, escalable y fácil de mantener.

---

## Descripción

La aplicación permite gestionar precios asociados a productos de diferentes marcas. Incluye las siguientes funcionalidades:
- Consultar el precio de un producto en función de la fecha de aplicación, identificador de la marca y el producto.
- Respetar las prioridades en las tarifas aplicables cuando existen solapamientos.

El diseño sigue la arquitectura hexagonal (puertos y adaptadores) para asegurar independencia entre las capas de dominio, infraestructura y aplicación.

---

## Tabla de Contenidos
- [Requisitos Previos](#requisitos-previos)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Arquitectura](#arquitectura)
- [Uso](#uso)
- [Test](#Test)
- [Comentarios](#Comentarios)


---

## Requisitos Previos

Asegúrate de tener instalado lo siguiente:

- **Java 17**
- **Maven 3.8** o superior
- **Un ide como Eclipse**

---

## Instalación y Ejecución

1. Clona este repositorio:
   
        git clone https://github.com/usuario/bcnc-prueba-tecnica.git
        cd bcnc-prueba-tecnica
    
2. Compila el proyecto usando Maven:

        Ejecutando el comando "mvn clean install", o bien utilizando el IDE.

3. Ejecuta la aplicación:

        Ejecuta el comando "mvn spring-boot:run", o desde el IDE, como anteriormente.

        La aplicacion se levantara en: **http://localhost:8080**

    Para ver la base de datos en memoria:
         **http://localhost:8080/h2-console**

        -> Los scripts sql estan en la carpeta resources.

        -> Las credenciales estan el archivo aplication.properties, pero son las siguientes:
            -JDBC URL: **jdbc:h2:mem:testdb**
            -User Name: **BCNC**
            -Password: **BCNC**
            
    Para acceder a swagger y poder probar la API directamente:
         **http://localhost:8080/swagger-ui/index.html**

--

## Arquitectura

La aplicación sigue una arquitectura hexagonal, que separa las responsabilidades de la siguiente manera:

Dominio:

    -Contiene la lógica de negocio (entidades y servicios).
     Independiente de las capas externas.

Aplicación:

    -Proporciona casos de uso que interactúan con el dominio.
     Implementa los puertos de entrada.

Infraestructura:

    -Gestiona la persistencia de datos (repositorios) y la exposición de la API REST.
     Implementa los puertos de salida.

--

## Uso

Endpoints Disponibles
Método	Endpoint	Descripción
GET	/prices/{productId}/{brandId}/{applicationDate}	Consulta el precio aplicable para un producto.

-Ejemplo de Solicitud:
    Consulta el precio de un producto con una herramienta como postman, con swagger o bien con el siguiente comando:

    curl -X GET "http://localhost:8080/BCNC/price/35455/1/2020-06-14T21:00:00"

    Respuesta Ejemplo

    {
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "startDate": "2020-06-14T00:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 35.50
    }

--

## Test
Ejecuta las pruebas unitarias y de integración con el IDE o bien con Maven con el siguiente comando: -> mvn test


Cobertura de Pruebas
Se utilizan las siguientes herramientas para asegurar calidad en el código:

JUnit 5: Para pruebas unitarias.
Spring MockMvc: Para pruebas de los endpoints REST.

--

## Comentarios

Debido a que estoy realizando varias pruebas técnicas a la vez y al trabajo no dispongo de todo el tiempo que me gustaría para realizar las mejoras convenientes,
pero serían las siguientes:

-1. Gestión de Errores:

    Implementar excepciones personalizadas y centralizar el manejo de errores.
    Mejorar los mensajes de error en las respuestas HTTP para facilitar el debug.
    Creación de Enums para dichos mensajes.

-2. Validaciones:

    Usar anotaciones como @Valid en Spring Boot para validar datos de entrada.
    Incluir mensajes de error claros cuando los datos no cumplan con los criterios esperados.

-3. Consultas:

    Reemplazar las consultas jpa generadas automáticamente por consultas personalizadas, ya que en este caso las consultas automáticas resultan poco legibles y difíciles de entender.


