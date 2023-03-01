package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginPageTests {

    public static WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);


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
    }

    @AfterClass
    public static  void afterClass() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void openApplication() throws InterruptedException {
        String expectedUrl = "https://www.saucedemo.com/";
        String returnedUrl = driver.getCurrentUrl();
        Thread.sleep(1000);
        Assert.assertTrue("Niste na dobrom linku", expectedUrl.equals(returnedUrl));
        Assert.assertTrue("Stranica nije otvorena", loginPage.displayedLogoLoginPage()==true);
    }
    @Test
    public void testLoginCorrectUserNameCorrectPassword() throws InterruptedException {
        loginPage.validLogin();
        Thread.sleep(1000);
        Assert.assertTrue("Login nije prosao ili se nije otvorila dobra stranica", productsPage.displayedHeaderTitleLogo()==true);
    }
    @Test
    public void testLoginInCorrectUserNameCorrectPassword() throws InterruptedException {
        loginPage.enterUserName("standard");
        loginPage.enterPassword("secret_sauce");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String returnedErrorMessage = loginPage.getErrorMessage();
        Thread.sleep(1000);
        Assert.assertTrue("Ne izlazi dobra poruka.", expectedErrorMessage.equals(returnedErrorMessage));
    }
    @Test
    public void testLoginCorrectUserNameInCorrectPassword() throws InterruptedException {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("s");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String returnedErrorMessage = loginPage.getErrorMessage();
        Thread.sleep(1000);
        Assert.assertTrue("Ne izlazi dobra poruka.", expectedErrorMessage.equals(returnedErrorMessage));
    }
    @Test
    public void testLoginEmptyUserNameCorrectPassword() throws InterruptedException {
        loginPage.enterUserName("");
        loginPage.enterPassword("secret_sauce");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        String expectedErrorMessage = "Epic sadface: Username is required";
        String returnedErrorMessage = loginPage.getErrorMessage();
        Thread.sleep(1000);
        Assert.assertTrue("Ne izlazi dobra poruka.", expectedErrorMessage.equals(returnedErrorMessage));
    }
    @Test
    public void testLoginCorrectUserNameEmptyPassword() throws InterruptedException {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String returnedErrorMessage = loginPage.getErrorMessage();
        Thread.sleep(1000);
        Assert.assertTrue("Ne izlazi dobra poruka.", expectedErrorMessage.equals(returnedErrorMessage));
    }

}
