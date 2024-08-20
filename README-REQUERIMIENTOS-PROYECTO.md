# ANÁLISIS DE REQUERIMIENTOS.
La compañía **_Apollonia Dental Practice_** nos solicita que desarrollemos una base de datos y una aplicación web que refleje su organización actual.

Los requisitos expresados son poder crear registros de empleados con Nombre, Apellido y Departamento, así como una lista de Departamentos disponibles en la clínica.

El equipo utilizará nuestro desarrollo para comenzar a crear un nuevo sistema de gestión de empleados digital para gestionar mejor su práctica dental y su fuerza laboral.

Este proyecto será un paso inicial hacia la construcción posterior de una aplicación completa de gestión de relaciones con empleados y clientes.

## Propuesta de arquitectura.
Este proyecto RESTFULL usaremos para la parte de Backend y BBDD las siguientes tecnologías:
 - Spring Boot.
 - Java 17.
 - MySQL.

 Usaremos el patrón de diseño MVC pero adaptado a la aruitectura REST (es parecido a MVC pero el cliente o FrontEnd realiza la función de vista).
 ![enter image description here](https://terasolunaorg.github.io/guideline/5.2.0.RELEASE/en/_images/RESTOverviewApplicationConstitutionOnSpringMVC.png)


Para el FrontEnd solo por el momento se empleara una solución de HTML, CSS y JavaScript, para futuros proyectos de mejora del FrontEnd podríamos mirar de implementar esta parte en React JS o Angular.

Descargaremos una plantilla **_“sb-admin-2”_** que obtendremos de la web:

[https://startbootstrap.com/theme/sb-admin-2](https://startbootstrap.com/theme/sb-admin-2)

La modificaremos a voluntad para encajarla en nuestro proyecto.

Además se deberá dockerizar la aplicación para que pueda ser implantada rápidamente en cualquier servidor que tenga la configuración adecuada para soportarlo.

## Propuesta de diseño BD de la solución.
A nivel de BD el proyecto deberá contemplar la información que hace referencia a:

**Empleados**: Código empleado, nombre-apellidos, E-mail, teléfono, cargo (responsable, empleado), nombre departamento, salario anual, contraseña (campo para permitir el acceso).

**Departamentos**:  Código departamento, nombre departamento, descripción.


## Propuesta del diseño del FrontEnd.

Desde un punto de vista funcional la aplicación funcionara de la siguiente manera (se detalla las páginas más importantes):

### Página inicial (index.html).
Mostraremos una lista de todos los empleados ordenados por código de empleado.
Prestemos atención al campo “Acciones”, que contiene para cada entrada los iconos de “borrar registro”, “editar/ver registro”.

Tendremos un menú de gestión en el lado izquierdo de la página principal que nos permita:

 - Ir a “Pagina central” (index.html).
 - Alta empleado (alta-empleado.html).
 - Ir a “Departamentos” (departmentos.html).
 - Salir.

### Página departamentos (Departamentos.html).

Al igual que la página principal, mostrara un listado de departamentos ordenados por el código de departamento (con el mismo estilo).

Tendrá un campo llamado “Acciones” para cada entrada de departamento con los iconos de “borrar registro”, “editar/ver registro”.
Tendremos un menú de gestión en el lado izquierdo de la página departamentos que nos permita:

 - Ir a “Departamentos” (departamentos.html).
 - Alta departamento (alta-departamento.html).
 - Ir a “Pagina central” (index.html).
 - Salir.

### Páginas para las altas de empleado y departamento (alta-empleado.html, alta-departamento.html).
Ambas páginas mostraran un formulario para las altas de nuevos registros de empleados y departamento. Tendremos de tener cuidado de mantener una estética parecida a las anteriores páginas que hemos comentado.

Mostrara todos los campos de cada tabla para ser rellenado y los botones de guardar o descartar el alta.

Una vez se pulse uno de los botones inmediatamente nos iremos a index.html (listado de empleados) o departamentos.html (listado de departamentos).

En ambas pantallas mantendremos un menú de gestión en el lado izquierdo que contendrá:

 - Ir a “Página principal” (index.html).
 - Ir a “Departamentos” (departamentos.html).
 - Salir.


