**BCI test Users management**


Api para el manejo de usuarios
V 1.0 

Author: Gonzalo Demangel 
gonzalo.demangel@bci.cl


El proyecto consta de una API REST FULL que permite guardar usuarios con multiples datos. Segun especificaciones entregadas para el desafio. 

La persistencia ser realiza en memoria, por medio de una BBD H2, por lo que una vez detenido el proyecto esta se borra.

Para consultar la BBDD, con el proyecto ejecutandose, abrir la siguiente url en algun navegador web: 

http://localhost:8080/h2-console/
username: bci_usuarioAdmin
password: bci_usuarioAdmin2023

**Como probar: **

1 Descarga el repositorio.<br>		
2 Abre el proyecto con algun IDE como Eclipse o InteliJ.<br>
3 Ejecuta el proyecto como  spring boot aplication (Run ass -> Spring boot app )<br>
4 Inicia postman e importa postman.collection incluida en este repositorio<br>
5 Ejecuta las consultas de la coleccion teniendo las siguientes precauciones: <br>

Crear usuario: 
	Permite crear un usuario con 0 o mas numeros de telefonos, los cuales se guardaran asociados a el. 
	
Consultar por todos los usuarios:
	Trae una lista con todos los usuarios registrados en la base de datos 	
	
Borrar un usuario:
	Permite borrar un usuario, pasandole por parametro en la url su "userId" (se puede obtener al registrarlo o al consultar por todos los usuarios)
	Ej: http://localhost:8080/v1/api/deleteUser/75f2f898-9043-4551-8a93-85db30ffbf09
	userId : 75f2f898-9043-4551-8a93-85db30ffbf09

Consultar por un usuario:
	Permite consultar un usuario, pasandole por parametro en la url su "userId" (se puede obtener al registrarlo o al consultar por todos los usuarios)
	Ej: http://localhost:8080/v1/api/getUser/75f2f898-9043-4551-8a93-85db30ffbf09
	userId : 75f2f898-9043-4551-8a93-85db30ffbf09
	
Editar un usuario:
	Permite editar los campos nombre, email y password, ademas de añadir telefonos. Se debe indicar el userId en la url ademas de los cambios que se requieren
	en el body. 
	
Consultar por todos los telefonos:
	Permite consultar todos los telefonos que estan guardados en la BBDD. 

Consultar por los telefonos de un usuario:
	Permite consultar los telefonos asociados a un usuario, indicando su userId en la url. 
	



**Para test unitarios: **

Ejecuta el proyecto como JUnit test (Run ass -> JUnit test).










************************************   
** Proximas mejoras: **

Aumentar coverage a un 90%.

Implementar authorizacion por medio de spring security y JWT. 






