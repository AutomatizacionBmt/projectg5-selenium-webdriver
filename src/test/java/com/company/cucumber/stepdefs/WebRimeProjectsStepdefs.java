package com.company.cucumber.stepdefs;

import com.company.models.RedmineProject;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineProjectsPage;
import com.company.utils.AppUtil;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;

import java.util.Map;

public class WebRimeProjectsStepdefs {

    BaseStepdefs baseStepdefs;
    RedmineProjectsPage redmineProjectsPage;

    public WebRimeProjectsStepdefs(BaseStepdefs baseStepdefs) {
        this.baseStepdefs = baseStepdefs;
    }

    @Cuando("Yo registro un proyecto")
    public void yoRegistroUnProyecto(Map<String, String> projectData) {


        RedmineHomePage redmineHomePage = (RedmineHomePage) baseStepdefs.currentPage;
        redmineProjectsPage = redmineHomePage.clickOnMenuProjects();
        redmineProjectsPage.clickNewProject();

        String randomNumber = AppUtil.generateRandomNumber();

        RedmineProject project = new RedmineProject();
        project.setName(projectData.get("name") + randomNumber);
        project.setDescription(projectData.get("description") + randomNumber);
        project.setHomePage(projectData.get("homepage") + randomNumber);
        project.setPublic(Boolean.parseBoolean(projectData.get("public")));

        redmineProjectsPage.createProject(project);

    }


    @Entonces("Yo deberia visualizar un mensaje satisfactorio {string}")

    public void yoDeberiaVisualizarUnMensajeSatisfactorio(String message) {
        Assert.assertEquals("Ocurrió un error al crear proyecto",
                message,
                redmineProjectsPage.getUIMessage());

    }
}
