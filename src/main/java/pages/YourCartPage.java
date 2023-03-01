package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class YourCartPage {
    //---------------ATRIBUTI------------------
    public WebDriver driver;
    public By cartItem = By.xpath("//*[@class='cart_item']");
    public By checkoutButton = By.xpath("//*[@id='checkout']");

    //-----BoltShirt
    public By cartItemBoltShirt = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    public By removeButtonForItemBoltShirt = By.xpath("//button[@data-test='remove-sauce-labs-bolt-t-shirt']");

    //------Backpack
    public By cartItemBackpack = By.xpath("//div[text()='Sauce Labs Backpack']");
    public By removeButtonForItemBackpack = By.xpath("//button[@data-test='remove-sauce-labs-backpack']");







    //------------METODE-------------
    public YourCartPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean displayedCartItem(){
        return driver.findElement(cartItem).isDisplayed();
    }
    public void clickCheckoutButton (){
        driver.findElement(checkoutButton).click();
    }


    //-----BoltShirt
    public boolean displayedCartItemBoltShirt(){
        return driver.findElement(cartItemBoltShirt).isDisplayed();
    }

    public void clickRemoveButtonForItemBoltShirt (){
        driver.findElement(removeButtonForItemBoltShirt).click();
    }



    //------Backpack
    public boolean displayedCartItemBackpack(){
        return driver.findElement(cartItemBackpack).isDisplayed();
    }
    public void clickRemoveButtonForItemBackpack(){
        driver.findElement(removeButtonForItemBackpack).click();
    }

}
