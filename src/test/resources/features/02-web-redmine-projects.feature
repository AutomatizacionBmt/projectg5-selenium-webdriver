# language: es

Característica: Web UI Redmine Projects
  Como usuario,
  Yo deseo crear un Proyecto en Redmine

  @gui @Workings
  Escenario: Crear un proyecto satisfactoriamente
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales user "user" y password "bitnami1"
    Y Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Cuando Yo registro un proyecto
      | name        | RedmineProject                    |
      | description | Esta es una descripcion de prueba |
      | homepage    | RedmineProject                    |
      | public      | true                              |
    Entonces Yo deberia visualizar un mensaje satisfactorio "Successful creation."