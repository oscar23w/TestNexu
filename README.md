# Prueba Técnica Nexu - Backend Developer

Este proyecto es una solución para la prueba técnica de Backend para Nexu. Es una aplicación construida con **Java** y **Spring Boot**, diseñada para cumplir con los requisitos planteados en el ejercicio.

## Endpoints desarrollados:
* GET    /brands **(Completo)**
* GET    /brands/:id/models **(Completo)**
* POST   /brands **(Completo)**
* POST   /brands/:id/models **(Completo)**
* PUT    /models/:id **(No completado)**
* GET    /models **(No completado)**

Por falta de tiempo no se pudieron desarrollar los ultimos dos endpoints, cabe mencionar que si bien la recomendación de tiempo era de dos horas, llegado un punto estuve mas absorto en el código que en el propio tiempo, razón por la cual dedique alrededor de 2 horas y 40 minutos aproximadamente a este desarrollo. En caso de haberme limitado unicamente a las 2 horas previstas puedo decir con seguridad que solo habria terminado los dos endpoints de tipo POST. 

## Arquitectura:
Decidí tomar un enfoque de arquitectura limpia, mas especificamente opte por la arquitectura hexagonal, esto debido a que ultimamente me he encontrado algo mas familiarizado con ella y por eso decidi utilizarla, de igual manera aunque al principio usar esta arquitectura me quito tiempo, fue tambien gracias a ella que despues de un rato pude acelerar el ritmo de desarrollo.

## Siguientes pasos
Lo siguiente que harua seria comenzar a realizar los endpoints faltantes, si bien creo que con el PUT no habria mucho problema, al analizar los requisitos del último metodo GET, me di cuenta que tiene una dificultad adicional, esta es una de las razones por las que lo deje para el final, para asi poder avanzar y completar otros endpoints que me tomarian menos tiempo, en lo que respecta a este metodo, el hecho de tener que filtrar los resultados por precios mayores y menores me genero varias ideas, primero pense en hacerlo mediante una consulta donde extragera todos los datos de los modelos existentes y despues los filtrara mediante un bucle for, si bien esta fue la primer idea que se me ocurrio, no tarde en darme cuenta que pensando a gran escala esto seria inviable, por eso estoy convencido que la manera correcta de realizar este endpoint seria llevando los filtros del precio directamente hasta la consulta que se hace a la BD, optimizando recursos y tiempos de procesamiento.

De igual manera si pudiera dedicar mas tiempo a continuar con la codificación de este proyecto hay varios aspectos que se podria mejorar, empezando por dejar un poco mas limpios los endpoints, ya que en este momento en el código propio de los endpoints tambien hay código para mapear las respuestas o solicitudes y creo que este codigo se podria simplificar utilizando una libreria como Mapstruc y al mismo tiempo se podria migrar dicho código a la capa del caso de uso o incluso al adaptador para asi mantener los endpoints lo mas limpios y aislados posibles. Tambien se podrian hacer mejoras en las excepciones y en el manejador global de excepciones, y mejorar las validaciones para hacerlas mas robustas.

## Problemas encontrados
Creo que el mayor problema que enfrente fue al migrar los datos del Json a la BD del programa, sobre todo debido a que los datos en el Json tenian una id definida, mientras que la base de datos esta configurada para establecer de forma automatica ese id, este detalle hizo que durante el desarrollo el programa fallara en mas de una ocación pero se soluciono bien.
Ademas de ese problema hubo otro en algunos momentos donde no definia bien algun metodo, o incluso al consultar o guardar información, sin embargo fueron errores menores.

## Notas
Tengo que mencionar que si bien yo escribi el código, y gran parte de el son cosas que ya sabia hacer, tambien durante el desarrollo llegue a hacer consultas en internet para aclarar algo que no recordaba bien o buscar algun metodo que me funcionara para algo en especifico.

## Requisitos Previos

Para ejecutar este proyecto, solo necesitas tener instalado:

* **Java JDK 17** (o superior), aunque yo recomiendo el 21.
* **Git** (opcional, para clonar el repositorio).
* **Postman** para probar los endpoints de manera local.

> **Nota:** No es necesario instalar Maven manualmente ni configurar una base de datos externa (MySQL/PostgreSQL), ya que el proyecto utiliza **Maven Wrapper** incluido y una base de datos en memoria **H2** para facilitar la revisión.

## Instrucciones de Instalación y Ejecución

Sigue estos pasos para levantar la aplicación en tu entorno local:

### 1. Clonar el repositorio
(Omite este paso si ya tienes el archivo comprimido)
```bash
git clone [URL_DE_TU_REPOSITORIO](https://github.com/oscar23w/TestNexu.git)
cd TestNexu
```

### 2. Ejecutar la aplicación
El proyecto incluye el Maven Wrapper (mvnw), que se encarga de descargar todas las dependencias necesarias automáticamente.
#### En Windows (CMD / PowerShell):
```PowerShell
./mvnw spring-boot:run
```
Una vez veas el log Started TestNexuApplication in ... seconds, la aplicación estará corriendo en:
URL: http://localhost:8080

### 3. Ejecución de Pruebas (Testing)
El proyecto incluye pruebas unitarias y de integración utilizando JUnit 5 y DataJpaTest.
#### En Windows (CMD / PowerShell):
```PowerShell
./mvnw test
```
Esto compilará el proyecto y ejecutará todos los tests definidos, mostrando un reporte final en la consola indicando si los tests pasaron (BUILD SUCCESS).

### Tecnologías Utilizadas
* **Java 17**: Lenguaje principal.
* **Spring Boot 3.4.1**: Framework web.
* **Spring Data JPA**: Persistencia de datos.
* **H2 Database**: Base de datos en memoria (para desarrollo/test).
* **JUnit 5 & Mockito**: Pruebas unitarias y de integración.
* **Lombok**: Reducción de código boilerplate.
* **Maven**: Gestión de dependencias.

Elegí estas tecnologías por la familiaridad que me representaban, si bien reconozco que para la complejidad del test existian mas opciones y mas rapidas preferi optar por tecnologias conocidas para poder presentar mejores resultados, esto teniendo en cuenta tambien el tiempo que mehabria tomado investigar y adaptarme a alguna otra tecnología.

#### Gracias por leer y  por su atención en mi desarrollo, adjunto mi correo electronico a continuación, saludos :)
*oscarabelgv@gmail.com*
