package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutOverviewPage;
import pages.CheckoutYourInformationPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class SumOfPrices extends BaseTests{
    ProductsPage productsPage = new ProductsPage(driver);
    YourCartPage yourCartPage = new YourCartPage(driver);
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

    @Test
    public void sumOfPricesTests() throws InterruptedException {
        productsPage.clickInventoryItemBoltShirtAddToCartButton();
        productsPage.clickInventoryItemBackpackAddToCartButton();
        productsPage.clickShoppingCartLink();
        yourCartPage.clickCheckoutButton();
        checkoutYourInformationPage.yourInformation();
        checkoutYourInformationPage.clickCountinueButton();
        Thread.sleep(500);
        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(500);


        double getPriceForBackpack = checkoutOverviewPage.priceForBackpack;
        double getPriceForBoltShirt = checkoutOverviewPage.priceForBoltShirt;

        //drugi nacin :
        //posto imamo istu klasu za polja gde se cuvaju cene za Iteme, napraviti niz koji ce
        //prolaziti kroz polja i cuvati vrednosti tih polja i posle ih sabrati



        String getPriceForTax = checkoutOverviewPage.getTaxPrice();
        int indexOfDolarTax = getPriceForTax.indexOf("$");
        String valueForTax = getPriceForTax.substring(indexOfDolarTax+1);


        double numberForTax = Double.parseDouble(valueForTax);

        String getPriceForTotal = checkoutOverviewPage.getTotalPrice();
        int indexOfDolarTotal = getPriceForTotal.indexOf("$");
        String valueForTotal = getPriceForTotal.substring(indexOfDolarTotal+1);


        double numberForTotal = Double.parseDouble(valueForTotal);


        double sumPrice = getPriceForBackpack + getPriceForBoltShirt + numberForTax;

//        System.out.println(numberForTotal);
//        System.out.println(sumPrice);

       Assert.assertEquals(numberForTotal, sumPrice, 0.1);

    }
}
