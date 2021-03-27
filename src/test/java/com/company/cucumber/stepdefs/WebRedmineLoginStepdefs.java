package com.company.cucumber.stepdefs;

import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLoginPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;

public class WebRedmineLoginStepdefs {

    BaseStepdefs baseStepdefs;
    RedmineLoginPage redmineLoginPage;
    RedmineHomePage redmineHomePage;

    public WebRedmineLoginStepdefs(BaseStepdefs baseStepdefs){
        this.baseStepdefs = baseStepdefs;
    }

    @Dado("Yo voy a la pagina de login de Redmine")
    public void yoVoyALaPaginaDeLoginDeRedmine() {

        System.out.println("Yo voy a la pagina de login de Redmine");
        redmineLoginPage = baseStepdefs.currentPage.clickLinkLogin();

    }

    @Cuando("Yo inicio sesion con mis credenciales user {string} y password {string}")
    public void yoInicioSesionConMisCredencialesYPassword(String user, String password) {

        System.out.println("Yo inicio sesion con mis credenciales user {string} y password {string}");
        redmineHomePage = redmineLoginPage.login(user, password);
        baseStepdefs.currentPage = redmineHomePage;
    }


    @Entonces("Yo deberia visualizar en la pagina de inicio mi usuario {string}")
    public void yoDeberiaVisualizarEnLaPaginaDeInicioMiUsuario(String user) {

        System.out.println("Yo deberia visualizar en la pagina de inicio mi usuario {string}");
        String expectedUser = "Logged in as " + user;
        String actualUser = redmineHomePage.getUserLogged();

        Assert.assertEquals("Inicio se sesión incorrecto: ",
                expectedUser,
                actualUser);
    }



}
