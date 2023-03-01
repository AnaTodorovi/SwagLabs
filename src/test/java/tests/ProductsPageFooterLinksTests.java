package tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.ArrayList;


public class ProductsPageFooterLinksTests extends BaseTests {

//    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);




    @Test
    public void openFace() throws InterruptedException {

        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(500);
        productsPage.clickFacebookLink();
        Thread.sleep(500);
        String expectedUrl = "https://www.facebook.com/saucelabs";
//        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(w.get(1));
        String returnedUrl = driver.getCurrentUrl();
        Thread.sleep(500);


      Assert.assertTrue("Niste na dobrom linku", expectedUrl.equals(returnedUrl));
        //umesto https://www.facebook.com/saucelabs  za returnedUrl vraca https://www.saucedemo.com/inventory.html
    }
    @Test
    public void openTwitter() throws InterruptedException {

        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(500);
        productsPage.clickTwitterLink();
        Thread.sleep(500);
        String expectedUrl = "https://twitter.com/saucelabs";
//        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(w.get(1));
        String returnedUrl = driver.getCurrentUrl();
        Thread.sleep(500);

        Assert.assertTrue("Niste na dobrom linku", expectedUrl.equals(returnedUrl));


        //umesto https://twitter.com/saucelabs za returnedUrl vraca https://www.saucedemo.com/inventory.html

    }
    @Test
    public void openLinkedin() throws InterruptedException {

        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(500);
        productsPage.clickLinkedinLink();
        Thread.sleep(500);
        String expectedUrl = "https://www.linkedin.com/company/sauce-labs/?original_referer=";
//        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(w.get(1));
        String returnedUrl = driver.getCurrentUrl();
        Thread.sleep(500);

        Assert.assertTrue("Niste na dobrom linku", expectedUrl.equals(returnedUrl));



        //umesto https://www.linkedin.com/company/sauce-labs/ za returnedUrl vracahttps://www.saucedemo.com/inventory.html
    }
}
