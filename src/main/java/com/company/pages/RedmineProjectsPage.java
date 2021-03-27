package com.company.pages;

import com.company.models.RedmineProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void clickNewProject(){
        driver.findElement(btnNewProject).click();
    }

    public void createProject(RedmineProject project){

        driver.findElement(txtNameProject).sendKeys(project.getName());
        driver.findElement(txtDescription).sendKeys(project.getDescription());
        driver.findElement(txtHomePage).sendKeys(project.getHomePage());

        WebElement checkboxPublic = driver.findElement(chbxPublicProject);

        if(project.getPublic()){
            if(!checkboxPublic.isSelected())
                checkboxPublic.click();
        }else{
            if(checkboxPublic.isSelected())
                checkboxPublic.click();
        }

        driver.findElement(btnCreate).click();
    }

    public String getUIMessage(){

        return driver.findElement(lblMessage).getText();
    }

}
