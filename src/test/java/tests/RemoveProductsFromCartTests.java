package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.ProductsPage;
import pages.YourCartPage;

public class RemoveProductsFromCartTests extends BaseTests{
    ProductsPage productsPage = new ProductsPage(driver);
    YourCartPage yourCartPage = new YourCartPage(driver);


    @Test
    public void removeProductsFromCart() throws InterruptedException {
        Assert.assertTrue("Izabrani proizvod ne postoji.", productsPage.displayedInventoryItemBackpackAddToCartButton()==true);
        Assert.assertTrue("Izabrani proizvod ne postoji.", productsPage.displayedInventoryItemBoltShirtAddToCartButton()==true);

        productsPage.clickInventoryItemBoltShirtAddToCartButton();
        productsPage.clickInventoryItemBackpackAddToCartButton();
        Thread.sleep(500);
        productsPage.clickShoppingCartLink();

        Thread.sleep(500);

        boolean expectedDisplayedCartItemBoltShirt = false;
        boolean expectedDisplayedCartItemBackpack = false;

        boolean itemBoltShirt = yourCartPage.displayedCartItemBoltShirt();
        boolean itemBackpack = yourCartPage.displayedCartItemBackpack();


        yourCartPage.clickRemoveButtonForItemBoltShirt();
        Thread.sleep(500);
        yourCartPage.clickRemoveButtonForItemBackpack();
        Thread.sleep(500);


        Assert.assertTrue("Proizvod Bolt Shirt je vidljiv", itemBoltShirt != expectedDisplayedCartItemBoltShirt);
        Assert.assertTrue("Proizvod Backpack je vidljiv",itemBackpack != expectedDisplayedCartItemBackpack);


    }
}
