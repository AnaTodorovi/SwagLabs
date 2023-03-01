package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //-------------ATRIBUTI------------------
    public WebDriver driver;

    public By userNameField = By.xpath("//input[@data-test='username']");

    public By passwordField = By.xpath("//input[@data-test='password']");

    public By loginButton = By.xpath("//input[@name='login-button']");

    public By errorMessageField = By.xpath("//h3[@data-test='error']");

    public By logoLoginPage = By.xpath("//*[@class='login_logo']");


    //------------------METODE----------------
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName (String username){
        driver.findElement(userNameField).sendKeys(username);
    }

    public void enterPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton (){
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessageField).getText();
    }


    public boolean displayedLogoLoginPage(){
        return driver.findElement(logoLoginPage).isDisplayed();
    }


    public void validLogin() {
        driver.findElement(userNameField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }
}
