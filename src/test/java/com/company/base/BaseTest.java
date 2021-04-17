package com.company.base;

import com.company.pages.RedmineLandingPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;

    protected static RedmineLandingPage redmineLandingPage;

    @BeforeClass
    public static void setUpAndLaunchApp() {

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");

        driver = new ChromeDriver();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://8935fc85a347.ngrok.io");
        driver.manage().window().maximize();

        redmineLandingPage = new RedmineLandingPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
