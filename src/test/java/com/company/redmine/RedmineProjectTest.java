package com.company.redmine;

import com.company.base.BaseTest;
import com.company.models.RedmineProject;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLoginPage;
import com.company.pages.RedmineProjectsPage;
import com.company.utils.AppUtil;
import org.junit.Assert;
import org.junit.Test;

public class RedmineProjectTest extends BaseTest {

    @Test
    public void testCreateProject() {

        RedmineLoginPage redmineLoginPage = redmineLandingPage.clickLinkLogin();
        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        String expectedUser = "Logged in as user";
        String actualUser = redmineHomePage.getUserLogged();

        Assert.assertEquals("Login Fallido",
                expectedUser,
                actualUser);

        RedmineProjectsPage redmineProjectsPage = redmineHomePage.clickOnMenuProjects();
        redmineProjectsPage.clickNewProject();

        String randomNumber = AppUtil.generateRandomNumber();

        RedmineProject project = new RedmineProject();
        project.setName("RedmineProject" + randomNumber);
        project.setDescription("Esta es una descripcion " + randomNumber);
        project.setHomePage("RedmineProject" + randomNumber);
        project.setPublic(true);

        redmineProjectsPage.createProject(project);

        Assert.assertEquals("Ocurrió un error al crear proyecto",
                "Successful creation.",
                redmineProjectsPage.getUIMessage());
    }


}
