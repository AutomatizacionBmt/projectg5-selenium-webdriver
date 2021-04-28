package com.company.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesT {

    @Test
    public void selectingCheckbox(){

        System.setProperty("webdriver.chrome.driver","resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg5-selenium-webdriver/webapp/checkboxes.html");


        Boolean selected = false;

        WebElement checkbox = driver.findElement(By.id("lettuceCheckbox"));

        checkbox.click();
        //selected = checkbox.isSelected();

        checkbox.click();
        //selected = checkbox.isSelected();

        checkbox.click();
        //selected = checkbox.isSelected();

        //checkbox.click();

        Assert.assertTrue("El checkbox no esta seleccionado",
                checkbox.isSelected());

        driver.quit();
    }


}
