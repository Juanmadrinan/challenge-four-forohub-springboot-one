<h1>Challenge ForoHub ONE - Oracle Next Education</h1>

<p>Un saludo especial al equipo de revisión de ONE, les presento mi API REST ForoHub desarrollado conforme a los requisitos del proyecto.</p>

<h2>Presentacion de la API REST ForoHub</h2>
<p>Este proyecto se desarrollo en Spring Boot del lenguaje de programación Java, acontinuacion el listado de temas a tratar en este README</p>

<ul>
  <li>Explicación mi API REST (FOROHUB)</li>
  <li>Explicación Basica sobre la Logica y Estructura del Proyecto</li>
  <li>Evidencia Funcionamiento de la Aplicación 😀</li>
</ul>

<h3>Explicación de mi API REST (FOROHUB)</h3>
<p>Esta Api Rest implemento diferentes tecnologias utilizadas para el desarrollo de software que permiten el manejo de peticiones y respuestas (servidor, cliente) manejando distintas capas para un desarrollo escalable y seguro, manteniendo la mejora continua de los servicios ofrecidos. En esta actividad aprendi a hacer peticiones HTTP del lado del cliente y aprender a manejarlas de lado del servidor, controlando los errores de manera eficaz y dando niveles de acceso a los usuarios del sistema para interactuar con la API.</p>

![image](https://github.com/user-attachments/assets/8474a857-6344-43bc-998e-87609c70e635)

<h3>Explicación Basica sobre la Logica y Estructura del Proyecto</h3>

<ul>
  <li>
    <p>Controller</p>
    <p>Aqui se encuentra la logica principal de las peticion HTTP, en el archivo TopicoController esta la implementacion de @RestController que me permite trabajar con las peticiones para interactuar con la informacion contenida en cada petición, de esta manera desarrollando un CRUD, que permita el manejo de los Topicos en el ForoHub, de igual forma el UserController maneja @RestController para validar la contraseña encriptada de los usuarios con autorizacion admin para manejar las operacion de Crear, Editar, Visualizar y Eliminar con los Topicos en la base de datos.</p>
  
  ![image](https://github.com/user-attachments/assets/cb348dc3-ca94-40aa-9912-7003c522e704)
    
  </li>
  <li>
    <p>Domain</p>
    <p>Este directorio se utilizo para guardar las clases y los record que permitieron el manejo de los datos tanto de los topicos como del usuario para validarlo</p>
    
  ![image](https://github.com/user-attachments/assets/b5893c46-4dd6-49d1-8f37-ef7537d3f0be)
    
  </li>
  <li>
    <p>Infra</p>
    <p>En el directorio Infra se hizo el manejo de excepciones posibles durante la interaccion entre usuario y servidor, algunas excepciones se trataron directamente en el TopicoController y otras en el archivo TratamientoExceptions</p>
    
  ![image](https://github.com/user-attachments/assets/7fe1fe2a-09d2-4d8d-a26a-fba3133a5b56)

  <p>Como se ve en la imagen se encontro otro directorio llamado Security, el cual tiene las clases: </p>

  <p><b>TokenJWT</b></p>
  <p>En el cual cumple con crear el Token y tambien con Validarlo</p>

  <p><b>SecurityFilter</b></p>
  <p>Autentica al usuario y filtra el "Bearer" dejando solo como respueta el Token</p>

  <p><b>SecurityConfigure</b></p>
  <p>Este archivo configura los roles necesarios para cada peticion, permitiendo que en el path ("/login") se de acceso a todo usuario para logearse, en el path ("topicos") para que solo los usuario logueados puedan hacer GET, POST, PUT y DELETE para tratar con los datos de los Topicos en la base de datos</p>

  <p><b>Record -> DatosJWTToken</b></p>
  <p>Guarda el Token JWT</p>

  <p><b>AuthenticationUsers</b></p>
  <p>Busca al usuario por medio de Repository para validar la autenticacion en el sistema</p>
  </li>
  <li>
    <p>Repository</p>
    <p>Aqui se crea las interfaz que implementan JpaRepository que permiten interactuar con los datos de la base de datos</p>
    
  ![image](https://github.com/user-attachments/assets/1da4defa-481a-419a-bf89-84ff6d3d34ba)
    
  </li>
</ul>

<h3>Evidencia Funcionamiento de la Aplicación 😀</h3>

<h4>Base de datos</h4>

![image](https://github.com/user-attachments/assets/3d3b889f-13cd-4206-97ec-239f539a076a)




