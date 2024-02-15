# Album API

Esta aplicación obtiene los album y los rellena con las fotos asociadas, a traves de dos endpoints externos.

# Arquitectura

He elegido una arquitectura tipica MVC, debido a la sencillez de requisitos y a la homegeneidad de los requisitos, queremos guardar y obtener los albums, tanto desde base de datos cómo desde un endpoint externo.

# Tecnologías
He utilizado SpringBoot Vesion 3.1.7, Java 17, Junit 5, Jacoco 0.8.8, JPA y Base de datos H2.

# Patrones Diseño

Inyección de Dependencias (Dependency Injection):

Este patrón es fundamental en Spring Framework. A través de la anotación @Autowired que se utiliza para inyectar dependencias en los controladores y servicios de Spring.

Transfer Object (DTO):

Utilización DTOs (Data Transfer Objects) para transferir datos entre las diferentes capas de la aplicación. Los DTOs (por ejemplo, AlbumDTO y PhotoDTO) se utilizan para representar los datos que se envían entre el cliente y el servidor o entre diferentes componentes de la aplicación.

Repositorio (Repository):

Este es un patrón comúnmente utilizado en aplicaciones de persistencia de datos. Spring Data JPA implementa este patrón proporcionando repositorios que abstraen la capa de acceso a datos y proporcionan métodos para interactuar con la base de datos.

Builder (Constructor de Objetos):

El patrón Builder a menudo se usa para construir objetos complejos, especialmente en el proceso de construcción de DTOs u objetos de dominio. Este patrón ayuda a crear objetos paso a paso y proporciona una interfaz fluida para la construcción de objetos.

Patrón DAO (Data Access Object):

La combinación de Spring Data JPA y el repositorio proporciona una abstracción similar al patrón DAO. Este patrón separa la lógica de acceso a datos de la lógica de negocio y proporciona una capa de abstracción sobre la capa de persistencia. En este caso he decidido seguir manteniendo el nombre de las entidades para equipararlas a las tablas.

# Estructura

1- Controlador
@PostMapping("/saveAlbum"): Esta anotación indica que el método saveAlbum() manejará las solicitudes HTTP POST dirigidas a la ruta "/api/saveAlbum".

@GetMapping("/getAlbum"): Esta anotación indica que el método getAlbum() manejará las solicitudes HTTP GET dirigidas a la ruta "/api/getAlbum".

@GetMapping("/getAlbumFromDatabase"): Esta anotación indica que el método getAlbumFromDatabase() manejará las solicitudes HTTP GET dirigidas a la ruta "/api/getAlbumFromDatabase".

Métodos de controlador: Cada método de controlador (saveAlbum(), getAlbum(), getAlbumFromDatabase()) realiza una acción específica basada en el tipo de solicitud HTTP y devuelve una respuesta adecuada, que generalmente incluye una entidad ResponseEntity con un código de estado HTTP y un cuerpo de respuesta.

2- Servicio
Guardar Álbumes desde una Fuente Externa: El método saveAlbum() se encarga de obtener datos de álbumes y fotos desde una API externa (en este caso, jsonplaceholder.typicode.com), organizar las fotos por álbum y guardar los álbumes junto con sus fotos asociadas en la base de datos.

Obtener Álbumes desde una Fuente Externa: El método getAlbum() obtiene datos de álbumes y fotos desde una API externa, organiza las fotos por álbum y devuelve una lista de objetos AlbumDTO que representan los álbumes con sus fotos asociadas.

Obtener Álbumes desde la Base de Datos: El método getAlbumFromDatabase() recupera los álbumes almacenados en la base de datos. Si la base de datos está vacía, invoca al método saveAlbum() para llenarla previamente. Luego, convierte los álbumes recuperados en objetos AlbumDTO para su posterior uso.

3- Repository
Al extender JpaRepository, la interfaz AlbumRepository hereda automáticamente métodos para realizar operaciones CRUD en la entidad Album. No es necesario que implementes estos métodos manualmente; Spring Data JPA los generará automáticamente.

## Test

@Post http://localhost:8080/api/saveAlbum
Para guardar álbumes en la base de datos H2.

@Get http://localhost:8080/api/getAlbum
Para obtener los álbumes de los endpoint externos.

@Get http://localhost:8080/api/getAlbumFromDatabase
Obtiene los álbumes de la base de datos de memoria H2.

Test Unitarios integrados se pueden lanzar con el comando -> mvn clean install

Se puede probar la cobertura del código con Jacoco.


