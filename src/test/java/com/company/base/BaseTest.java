package com.company.base;

import com.company.pages.RedmineLandingPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;

    protected static RedmineLandingPage redmineLandingPage;

    @BeforeClass
    public static void setUpAndLaunchApp() {


        String browserName = System.getenv("browserName");
        browserName = (browserName == null) ? "chrome" : browserName.toLowerCase();

        switch (browserName){
            case "firefox":
                setFirefoxDriverProperty();
                break;
            case "safari":
                setSafariDriverProperty();
                break;
            case "chrome":
                setChromeDriverProperty();
                break;
            default:
                throw new IllegalStateException("The browserName " +browserName+ " option is not present");
        }

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://47f453d6c51e.ngrok.io");
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

    public static void setChromeDriverProperty(){

        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver.exe");
        }else if(System.getProperty("os.name").toLowerCase().contains("mac")){
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        }else{
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriverlinux");
        }

        driver = new ChromeDriver();
    }

    public static void setFirefoxDriverProperty(){

        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            System.setProperty("webdriver.gecko.driver", "resources/drivers/firefox/geckodriver.exe");
        }else if(System.getProperty("os.name").toLowerCase().contains("mac")){
            System.setProperty("webdriver.gecko.driver", "resources/drivers/firefox/geckodriver");
        }else{
            System.setProperty("webdriver.gecko.driver", "resources/drivers/firefox/geckodriverlinux");
        }

        driver = new FirefoxDriver();
    }

    private static void setSafariDriverProperty(){

        driver = new SafariDriver();

    }
}
