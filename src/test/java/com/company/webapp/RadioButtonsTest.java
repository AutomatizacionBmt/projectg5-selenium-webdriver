package com.company.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonsTest {

    @Test
    public void choosingRadioButton(){

        System.setProperty("webdriver.chrome.driver","resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg5-selenium-webdriver/webapp/radibuttons.html");

        List<WebElement> radioButtons = driver.findElements(By.name("color"));

        //Dar click al segundo radio button
        radioButtons.get(1).click();

        //Dar click al tercer radio button
        radioButtons.get(2).click();

        //Dar click al primer radio button
        radioButtons.get(0).click();

        driver.quit();
    }

    @Test
    public void gettingRadioButtonValue(){

        System.setProperty("webdriver.chrome.driver","resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg5-selenium-webdriver/webapp/radibuttons.html");

        List<WebElement> radioButtons = driver.findElements(By.name("color"));

        //Dar click al segundo radio button
        radioButtons.get(1).click();

        String colorActual = "";
        String colorExpected = "green";

        for (WebElement radioButton: radioButtons){

            if(radioButton.isSelected()){
                colorActual = radioButton.getAttribute("value");
                break;
            }
        }

        Assert.assertEquals("Color inválido",
                colorExpected,
                colorActual);

        driver.quit();
    }
}
