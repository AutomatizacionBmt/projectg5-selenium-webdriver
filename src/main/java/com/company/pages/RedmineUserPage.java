package com.company.pages;

import com.company.models.RedmineUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RedmineUserPage extends RedmineLandingPage{


    private By linkUsers = By.xpath("//a[@href='/users']");
    private By linkNewUsers = By.xpath("//a[@href='/users/new']");

    private By txtUserName = By.xpath("//*[@id=\"user_login\"]");
    private By txtFirstName = By.xpath("//*[@id=\"user_firstname\"]");
    private By txtLastName = By.xpath("//*[@id=\"user_lastname\"]");
    private By txtEmail = By.xpath("//*[@id=\"user_mail\"]");
    private By cbxLanguage = By.xpath("//*[@id=\"user_language\"]");
    private By chbxAdministrator = By.xpath("//*[@id=\"user_admin\"]");
    private By txtPassword = By.xpath("//*[@id=\"user_password\"]");
    private By txtPasswordConfirmation = By.xpath("//*[@id=\"user_password_confirmation\"]");

    private By btnCreateUser = By.name("commit");
    private By lblUIMessage = By.id("flash_notice");

    private By linkDeleteUser = By.linkText("Delete");


    public RedmineUserPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLinkUsers(){
        driver.findElement(linkUsers).click();
    }

    public void clickOnLinkNewUsers(){
        driver.findElement(linkNewUsers).click();
    }

    public void createNewUser(RedmineUser user){

        driver.findElement(txtUserName).sendKeys(user.getUserName());
        driver.findElement(txtFirstName).sendKeys(user.getFirstName());
        driver.findElement(txtLastName).sendKeys(user.getLastName());
        driver.findElement(txtEmail).sendKeys(user.getEmail());

        WebElement webElementSelectLanguage = driver.findElement(cbxLanguage);

        Select selectLanguage = new Select(webElementSelectLanguage);
        selectLanguage.selectByVisibleText(user.getLanguage());

        driver.findElement(chbxAdministrator).click();

        driver.findElement(txtPassword).sendKeys(user.getPassword());
        driver.findElement(txtPasswordConfirmation).sendKeys(user.getPassword());
        driver.findElement(btnCreateUser).click();
    }

    public String getUIMessageCreateUser(){

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(lblUIMessage));
        return driver.findElement(lblUIMessage).getText();
    }

    public void clickLinkDeleteUser(String userName){

        List<WebElement> userList = driver.findElement(By.tagName("table"))
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        for (WebElement userRow: userList){
            String userNameRow = userRow.findElements(By.tagName("td")).get(0).getText();
            if(userName.equals(userNameRow)){
                userRow.findElements(By.tagName("td")).get(7)
                        .findElement(linkDeleteUser)
                        .click();
                break;
            }
        }
    }

    public void removeUser(){
        driver.switchTo().alert().accept();
    }

    public void doNotRemoveUser(){
        driver.switchTo().alert().dismiss();
    }

    public Boolean userIsOnList(String userName) {

        List<WebElement> userList = driver.findElement(By.tagName("table"))
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        for (WebElement userRow: userList){
            String userNameRow = userRow.findElements(By.tagName("td")).get(0).getText();
            if(userName.equals(userNameRow)){
                return true;
            }
        }
        return false;
    }
}
