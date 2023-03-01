package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class BaseTests {

     static WebDriver driver;

    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        loginPage.validLogin();
        Thread.sleep(1000);
    }
    @After
    public void tearDown() throws Exception {
        productsPage.clickButtonMenu();
        Thread.sleep(1000);
        productsPage.clickButtonMenuLinkLogout();

    }
    @AfterClass
    public static  void afterClass() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
