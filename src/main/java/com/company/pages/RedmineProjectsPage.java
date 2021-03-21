package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineProjectsPage extends RedmineLandingPage{

    private By btnNewProject = By.xpath("//a[text()='New project']");
    private By txtNameProject = By.id("project_name");
    private By txtDescription = By.id("project_description");
    private By txtHomePage = By.id("project_homepage");
    private By chbxPublicProject = By.id("project_is_public");
    private By btnCreate = By.name("commit");

    private By lblMessage = By.id("flash_notice");




    public RedmineProjectsPage(WebDriver driver) {
        super(driver);
    }
}
