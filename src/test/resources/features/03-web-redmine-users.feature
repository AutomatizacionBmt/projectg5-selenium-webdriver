# language: es

Característica: Web UI - Redmine - Users
  Como usuario admin,
  Yo deseo crear un nuevo usuario

  @gui @Working
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