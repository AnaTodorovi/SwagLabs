package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    //--------ATRIBUTI--------
    public WebDriver driver;
    public By finishButton = By.xpath("  //*[@id='finish']");

    public double priceForBackpack = 29.99;
    public double priceForBoltShirt = 15.99;

    public By tax = By.xpath("//*[@class='summary_tax_label']");
    public By total = By.xpath("//*[@class='summary_total_label']");
    //-------METODE---------
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver=driver;
    }

    public void clickFinishButton (){
        driver.findElement(finishButton).click();
    }

    public String getTaxPrice(){
        return  driver.findElement(tax).getText();
    }
    public String getTotalPrice(){
        return  driver.findElement(total).getText();
    }

}
