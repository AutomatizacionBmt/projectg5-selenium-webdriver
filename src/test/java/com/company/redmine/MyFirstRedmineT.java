package com.company.redmine;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstRedmineT {


    @Test
    public void myFirstT(){

        //Para Windows
        //System.setProperty("webdriver.chrome.driver","resources/drivers/chrome/chromedriver.exe");

        //Para Linux o macOS
        System.setProperty("webdriver.chrome.driver","resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://198.211.98.120:8081/");

        //Maximizar la ventana
        //driver.manage().window().maximize();

        //Pantalla completa
        //driver.manage().window().fullscreen();


        //Espicificando una dimención, por ejemplo (iPhoneX)
        driver.manage().window().setSize(new Dimension(375,812));

        System.out.println("stop...");
        driver.quit();
    }

    @Test
    public void loginRedmineT(){

        System.setProperty("webdriver.chrome.driver","resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://198.211.98.120:8081/");


        By linkIniciarSesion = By.linkText("Iniciar sesión");
        WebElement webElementLinkLogin = driver.findElement(linkIniciarSesion);
        webElementLinkLogin.click();

        By txtUsername = By.id("username");
        WebElement webElementUserName = driver.findElement(txtUsername);
        webElementUserName.sendKeys("user");

        WebElement webElementPassword = driver.findElement(By.name("password"));
        webElementPassword.sendKeys("bitnami1");

        //XPath Relativo para boton
        //*[@id="login-submit"]

        //XPath Absoluto
        // /html/body/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/form/input[6]

        WebElement webElementLogin = driver.findElement(By.xpath("//*[@id=\"login-submit\"]"));
        webElementLogin.click();


        WebElement webElementUsuario = driver.findElement(By.id("loggedas"));

        String userExpected = "user";
        String userActual = webElementUsuario.getText();

        Assert.assertEquals("Error en login",
                "Logged in as "+userExpected,
                userActual);

        driver.quit();


    }



}
