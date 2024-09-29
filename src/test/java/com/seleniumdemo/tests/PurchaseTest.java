package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.ProductDetailsPage;
import com.seleniumdemo.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseProductTest() {
        driver.get("http://seleniumdemo.com/");
        HomePage home = new HomePage(driver);
        ShopPage shop = new ShopPage(driver);
        ProductDetailsPage product = new ProductDetailsPage(driver);

        home.clickShopBtn();
        shop.chooseProduct("Java Selenium WebDriver");
        product.addToCartBtnClick();
        String productAddSuccessText =  product.divEl().getText();
        Assert.assertTrue(productAddSuccessText.contains("“Java Selenium WebDriver” has been added to your cart."));
        product.viewCartBtnClick();
        product.proceedToCheckoutBtnClick();
    }

}
