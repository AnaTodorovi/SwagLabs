package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    //-----------ATRIBUTI---------
    public WebDriver driver;
    public By titleForSuccessfulShop = By.xpath("//h2[@class='complete-header']");


    //----------METODE--------

    public CheckoutCompletePage(WebDriver driver) {
        this.driver=driver;
    }
    public boolean displayedTitleForSuccessfulShop(){
        return driver.findElement(titleForSuccessfulShop).isDisplayed();
    }
}
