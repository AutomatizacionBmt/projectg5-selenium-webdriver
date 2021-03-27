package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage extends RedmineLandingPage{

    private By lblUserLogged = By.id("loggedas");

    private By menuMyProjects = By.xpath("//a[@href='/projects']");

    public RedmineHomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserLogged(){
        return driver.findElement(lblUserLogged).getText();
    }

    public RedmineProjectsPage clickOnMenuProjects(){
        driver.findElement(menuMyProjects).click();
        return new RedmineProjectsPage(driver);
    }

    public RedmineUserPage clickOnMenuAdministration(){

        //Dar click en el menu administration

        return  new RedmineUserPage(driver);
    }


}
