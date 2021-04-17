# language: es

  Característica: Web UI Redmine Login
    Como usuario,
    Yo deseo iniciar sesión en la aplicación de Redmine

  @gui @Working
  Escenario: Iniciar sesión satisfactoriamente en Redmine
    Dado Yo voy a la pagina de login de Redmine
    #Esto es un Antipatron
    #Cuando yo ingreso mi usuario en la caja de texto user
    #Y Yo ingreso mi password en la caja de texto password
    #Y doy click en el boton ingresar
    Cuando Yo inicio sesion con mis credenciales user "user" y password "bitnami1"
    Entonces Yo deberia visualizar en la pagina de inicio mi usuario "user"


    @gui @Working
    Escenario: Iniciar sesión satisfactoriamente en Redmine presionando enter
      Dado Yo voy a la pagina de login de Redmine
      Cuando Yo inicio sesion con mis credenciales user "user" y password "bitnami1" y presiono enter
      Entonces Yo deberia visualizar en la pagina de inicio mi usuario "user"




