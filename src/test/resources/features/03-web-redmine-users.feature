# language: es

Característica: Web UI - Redmine - Users
  Como usuario admin,
  Yo deseo crear un nuevo usuario

  @gui @Workings
  Escenario: Crear un nuevo usuario satisfactoriamente
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales user "user" y password "bitnami1"
    Y Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Cuando Yo registro un usuario
      | userName      | user              |
      | firstName     | userfirstName     |
      | lastName      | userlastName      |
      | email         | @mail.com         |
      | language      | Spanish (Español) |
      | administrator | true              |
      | password      | 12345678          |
    Entonces El usuario se registro satisfactoriamente

  @gui @Workings
  Escenario: Crear un nuevo usuario y eliminarlo
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales user "user" y password "bitnami1"
    Y Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Cuando Yo registro un usuario
      | userName      | user              |
      | firstName     | userfirstName     |
      | lastName      | userlastName      |
      | email         | @mail.com         |
      | language      | Spanish (Español) |
      | administrator | true              |
      | password      | 12345678          |
    Y El usuario se registro satisfactoriamente
    Cuando Yo elimino el usuario de la lista de usuarios
    Entonces El usuario no deberia visualizarce en la lista usuarios

  @gui @Workings
  Escenario: Crear un nuevo usuario y no eliminarlo
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales user "user" y password "bitnami1"
    Y Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Cuando Yo registro un usuario
      | userName      | user              |
      | firstName     | userfirstName     |
      | lastName      | userlastName      |
      | email         | @mail.com         |
      | language      | Spanish (Español) |
      | administrator | true              |
      | password      | 12345678          |
    Y El usuario se registro satisfactoriamente
    Cuando Yo no elimino el usuario de la lista de usuarios
    Entonces El usuario deberia visualizarce en la lista usuarios
