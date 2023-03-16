Creación de Backend para mantener una base de datos de gestión de una biblioteca.

Debe permitir:
- Acceder al conjunto de libros (<span style="color:orange"> *getAll* </span>)
- Acceder al detalle de cada libro (<span style="color:orange"> *getById* </span>)
- Crear los datos del libro (<span style="color:orange"> *create* </span>)
- Borrar el libro (<span style="color:orange"> *deleteById* </span>)
- Controlar si está prestado o no (<span style="color:orange"> *isLoaned:True/False* </span>)

Como detalles de "libro" se define:
- Título
- Carátula
- Está prestado (o no)
- Author

Se crea una "clase" denominada "Author" para poder almacenarlos de manera separada a los "libros".

Como detalle de "Author" se define con los parámetros:
- Nombre
- Nacionalidad

Los "libros" y "autores" se almacenan en una base de datos ===> <span style="color:blue"> *resources / data.sql*</span>

Se crean bases relacionales para que cada "Author" pueda relacionarse a varios libros.
Relación  *Many To One*.

El proyecto se estructura con Spring Boot y se utilizan las librerías
- JPA
- Lombok
- Gradle (como gestor de paquetes)

Se ha procurado tener el máximo de código refactorizado para cumplir con los principios S.O.L.I.D

Se ha creado un *AdviseCintroller* para manejar las excepciones.

Todos estos datos se vincularán al Frontend mediante llamadas realizadas en un proyecto de React.

enlace https://github.com/Menchu02/LibraryProject



