package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    //-------------ATRIBUTI-------------
    public WebDriver driver;
    public By yourInformationFirstNameFiled = By.xpath("//*[@data-test='firstName']");
    public By yourInformationLastNameFiled = By.xpath("//*[@data-test='lastName']");
    public By yourInformationPostalCodeFiled = By.xpath("//*[@data-test='postalCode']");
    public By continueButton = By.xpath("  //*[@data-test='continue']");



    //--------------METODE-----------
    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver=driver;
    }
//    public void enterYourInformationFirstNameFiled (String name){
//        driver.findElement(yourInformationFirstNameFiled).sendKeys(name);
//    }
//    public void enterYourInformationLastNameFiled (String lastName){
//        driver.findElement(yourInformationLastNameFiled).sendKeys(lastName);
//    }
//
//    public void enterYourInformationPostalCodeFiled (String postalCode){
//        driver.findElement(yourInformationPostalCodeFiled).sendKeys(postalCode);
//    }
    public void clickCountinueButton (){
        driver.findElement(continueButton).click();
    }

    public void yourInformation() {
        driver.findElement(yourInformationFirstNameFiled).sendKeys("Ana");
        driver.findElement(yourInformationLastNameFiled).sendKeys("Todorovic");
        driver.findElement(yourInformationPostalCodeFiled).sendKeys("1234");
    }
}
