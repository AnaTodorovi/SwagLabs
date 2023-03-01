package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    //---------------ATRIBUTI------------------
    public WebDriver driver;
    public By headerTitleLogoForProductsPage = By.xpath("//*[@class='peek']");
    public By twitterLink = By.xpath("//footer/ul/li[@class='social_twitter']");

    public By facebookLink = By.xpath("//footer/ul/li[@class='social_facebook']");

    public By linkedinLink = By.xpath("//footer/ul/li[@class='social_linkedin']");

    public By shoppingCartLink = By.xpath("//a[@class='shopping_cart_link']");

    public By inventoryItem = By.xpath("//div[@class='inventory_item']");

    public By inventoryItemBackpackAddToCartButton = By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']");
    public By inventoryItemBoltShirtAddToCartButton = By.xpath("//*[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']");

    public By inventoryItemBackpackRemoveButton = By.xpath("//*[@data-test='remove-sauce-labs-backpack']");
    public By inventoryItemBoltShirtRemoveButton = By.xpath("//*[@data-test='remove-sauce-labs-bolt-t-shirt']");
    public By buttonMenu = By.xpath("//button[@id='react-burger-menu-btn']");


    public By buttonMenuLinkLogout = By.xpath("//*[@id='logout_sidebar_link']");


    //------------------METODE---------------

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    //----header
    public void clickShoppingCartLink (){
        driver.findElement(shoppingCartLink).click();
    }
    public void clickButtonMenu (){
        driver.findElement(buttonMenu).click();
    }

    public void clickButtonMenuLinkLogout (){
        driver.findElement(buttonMenuLinkLogout).click();
    }
    public boolean displayedHeaderTitleLogo (){
        return driver.findElement(headerTitleLogoForProductsPage).isDisplayed();
    }


    //------LINKOVI
    public void clickTwitterLink (){
        driver.findElement(twitterLink).click();
    }

    public void clickFacebookLink (){
        driver.findElement(facebookLink).click();
    }

    public void clickLinkedinLink (){
        driver.findElement(linkedinLink).click();
    }


    //--------Backpack
    public boolean displayedInventoryItemBackpackAddToCartButton (){
        return driver.findElement(inventoryItemBackpackAddToCartButton).isDisplayed();
    }
    public boolean displayedInventoryItemBackpackRemoveButton (){
        return driver.findElement(inventoryItemBackpackRemoveButton).isDisplayed();
    }

    public void clickInventoryItemBackpackAddToCartButton (){
        driver.findElement(inventoryItemBackpackAddToCartButton).click();
    }


    //---------BoltShirt
    public boolean displayedInventoryItemBoltShirtAddToCartButton (){
        return driver.findElement(inventoryItemBoltShirtAddToCartButton).isDisplayed();
    }
    public boolean displayedInventoryItemBoltShirtRemoveButton (){
        return driver.findElement(inventoryItemBoltShirtRemoveButton).isDisplayed();
    }

    public void clickInventoryItemBoltShirtAddToCartButton (){
        driver.findElement(inventoryItemBoltShirtAddToCartButton).click();
    }




}
