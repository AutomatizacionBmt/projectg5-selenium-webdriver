package com.company.base;

import com.company.pages.RedmineLandingPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static WebDriver driver;

    protected static RedmineLandingPage redmineLandingPage;

    @BeforeClass
    public static void setUpAndLaunchApp() {

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");

        driver = new ChromeDriver();

        driver.get("http://198.211.98.120:8081/");
        driver.manage().window().maximize();

        redmineLandingPage = new RedmineLandingPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
