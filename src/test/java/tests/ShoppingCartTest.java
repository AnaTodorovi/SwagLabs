package tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


public class ShoppingCartTest extends BaseTests {

//    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    YourCartPage yourCartPage = new YourCartPage(driver);
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);



    @Test
    public void shoppingCartTestForItemSauceLabsBackpack() throws InterruptedException {
        Assert.assertTrue("Izabrani proizvod ne postoji.", productsPage.displayedInventoryItemBackpackAddToCartButton()==true);

                productsPage.clickInventoryItemBackpackAddToCartButton();
                Thread.sleep(500);
                productsPage.clickShoppingCartLink();
                Thread.sleep(500);
                Assert.assertTrue("Proizvod nije ubacen u korpu.", yourCartPage.displayedCartItem()==true);


                yourCartPage.clickCheckoutButton();
                Thread.sleep(1000);
                checkoutYourInformationPage.yourInformation();

                Thread.sleep(500);


                js.executeScript("window.scrollBy(0,1000)", "");


                checkoutYourInformationPage.clickCountinueButton();
                Thread.sleep(500);
                checkoutOverviewPage.clickFinishButton();
                Thread.sleep(1000);


                js.executeScript("window.scrollBy(0,-1000)", "");

        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        String returnedUrl = driver.getCurrentUrl();


        Assert.assertTrue("Kupovina nije uspesna", checkoutCompletePage.displayedTitleForSuccessfulShop()==true);
        Assert.assertTrue("Nije otvorena dobra stranica ili kupovina nije uspesna", expectedUrl.equals(returnedUrl));
    }
}




