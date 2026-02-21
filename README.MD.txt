ForoHub

Descripcion del proyecto

Este es un proyecto que hice para el desafío de Alura Latam. es una aplicación que funciona como la parte trasera (el servidor) de un foro. Sirve para que los usuarios puedan publicar temas de discusión, leer lo que otros escribieron, corregir sus mensajes o borrarlos si ya no los quieren

Para que sirve la aplicación

Registro de usuarios: Primero tienes que crear un usuario y una contraseña para poder entrar.

Entrar al sistema (Login): Cuando pones tu usuario, el sistema te da una clave digital (un token) para que puedas usar el resto de las funciones.

Escribir un tema: Puedes publicar un título y un mensaje. El sistema revisa que no estés publicando el mismo tema dos veces.

Ver los temas: Puedes ver una lista de todos los mensajes que se han publicado, y el sistema los separa por páginas para que no se vea todo amontonado.

Editar y borrar: Si te equivocas en algo, puedes cambiar el mensaje o eliminar el tema por completo de la base de datos.

recursos usados para construilo

Java: El lenguaje que usé para escribir todo el código.

Spring Boot: La herramienta que me ayudó a que todo funcionara más rápido y organizado.

MySQL: Aquí es donde se guardan todos los usuarios y los temas que se publican.

Maven: Lo usé para descargar y manejar las librerías que necesitaba el proyecto.

JSON Web Token: Es la tecnología que usé para que la aplicación sea segura y solo los que tienen el token puedan entrar.

Cómo probarlo

Descarga el código en tu computadora.

Abre el proyecto en IntelliJ.

Asegúrate de tener instalado MySQL y configura tu usuario y contraseña en el archivo de configuración.

Dale a "Run" para que el servidor empiece a funcionar.

Usa un programa como Insomnia para mandar los datos de login y empezar a publicar temas.