package com.company.cucumber.stepdefs;

import com.company.models.RedmineUser;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineUserPage;
import com.company.utils.AppUtil;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;

import java.util.Map;

public class WebRedmineUserStepdefs {

    BaseStepdefs baseStepdefs;
    RedmineUserPage redmineUserPage;
    RedmineUser user;

    public WebRedmineUserStepdefs(BaseStepdefs baseStepdefs) {
        this.baseStepdefs = baseStepdefs;
    }

    @Cuando("Yo registro un usuario")
    public void yoRegistroUnUsuario(Map<String, String> userData) {

        RedmineHomePage redmineHomePage = (RedmineHomePage) baseStepdefs.currentPage;
        redmineUserPage = redmineHomePage.clickOnMenuAdministration();

        redmineUserPage.clickOnLinkUsers();
        redmineUserPage.clickOnLinkNewUsers();

        String number = AppUtil.generateRandomNumber();

        user = new RedmineUser();
        user.setUserName(userData.get("userName") + number);
        user.setFirstName(userData.get("firstName") + number);
        user.setLastName(userData.get("lastName") + number);
        user.setEmail(user.getUserName() + userData.get("email"));
        user.setLanguage(userData.get("language"));
        user.setAdministrator(Boolean.parseBoolean(userData.get("administrator")));
        user.setPassword(userData.get("password"));

        redmineUserPage.createNewUser(user);
    }


    @Entonces("El usuario se registro satisfactoriamente")
    public void elUsuarioSeRegistroSatisfactoriamente() {

        //User cpulache created.
        Assert.assertEquals("No se registró correctamente el usuario",
                "User " + user.getUserName() + " created.",
                redmineUserPage.getUIMessageCreateUser());

        System.out.println("Se registró correctamente el usuario: " + user.getUserName());
    }
}
