package com.company.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableTest {

    @Test
    public void gettingTableData(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg5-selenium-webdriver/webapp/table.html");

        WebElement outerTable = driver.findElement(By.tagName("table"));
        WebElement innerTable = outerTable.findElement(By.tagName("table"));

        //List<WebElement> listTd = innerTable.findElements(By.tagName("td"));
        //WebElement td1 = listTd.get(1);

        WebElement td1 = innerTable.findElements(By.tagName("td")).get(1);

        String expectedText = "Table 2 Row 2";
        String actualText = td1.getText();

        Assert.assertEquals("El texto es incorrecto",
                expectedText,
                actualText);

        driver.quit();
    }
}
