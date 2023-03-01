package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.ProductsPage;
import pages.YourCartPage;

public class AddProductsInCartTests extends BaseTests{

    ProductsPage productsPage = new ProductsPage(driver);
    YourCartPage yourCartPage = new YourCartPage(driver);


    @Test
    public void addProductsInCart() throws InterruptedException {
        Assert.assertTrue("Izabrani proizvod ne postoji.", productsPage.displayedInventoryItemBackpackAddToCartButton()==true);
        Assert.assertTrue("Izabrani proizvod ne postoji.", productsPage.displayedInventoryItemBoltShirtAddToCartButton()==true);

        productsPage.clickInventoryItemBoltShirtAddToCartButton();
        productsPage.clickInventoryItemBackpackAddToCartButton();


        Assert.assertTrue("Button nije promenio izgled", productsPage.displayedInventoryItemBackpackRemoveButton()==true);
        Assert.assertTrue("Button nije promenio izgled", productsPage.displayedInventoryItemBoltShirtRemoveButton()==true);


        Thread.sleep(500);
        productsPage.clickShoppingCartLink();

        String returnTitleItemOne=driver.findElement(yourCartPage.cartItemBoltShirt).getText();
        String returnTitleItemTwo=driver.findElement(yourCartPage.cartItemBackpack).getText();

        String expectedTitleItemOne="Sauce Labs Bolt T-Shirt";
        String expectedTitleItemTwo="Sauce Labs Backpack";


        Assert.assertTrue("Pogresan proizvod je dodat", returnTitleItemOne.equals(expectedTitleItemOne));
        Assert.assertTrue("Pogresan proizvod je dodat", returnTitleItemTwo.equals(expectedTitleItemTwo));



        Assert.assertTrue("Izabrani proizvod sa prethodne strane nije u korpi", yourCartPage.displayedCartItemBoltShirt()==true);
        Assert.assertTrue("Izabrani proizvod sa prethodne strane nije u korpi", yourCartPage.displayedCartItemBackpack()==true);

    }
}
