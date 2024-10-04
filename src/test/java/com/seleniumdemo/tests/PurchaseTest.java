package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.OrderDetailsPage;
import com.seleniumdemo.pages.ProductDetailsPage;
import com.seleniumdemo.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseProductTest() throws InterruptedException {
        driver.get("http://seleniumdemo.com/");
        HomePage home = new HomePage(driver);
        ShopPage shop = new ShopPage(driver);
        ProductDetailsPage product = new ProductDetailsPage(driver);
        OrderDetailsPage order = new OrderDetailsPage(driver);

        home.clickShopBtn();
        shop.openProduct("Java Selenium WebDriver");
        product.addToCartBtnClick();
        String productAddSuccessText =  product.divEl().getText();
        Assert.assertTrue(productAddSuccessText.contains("“Java Selenium WebDriver” has been added to your cart."));
        product.viewCartBtnClick();
        product.proceedToCheckoutBtnClick();

        order.fillFirstNameInput("TestName");
        order.fillLastNameInput("TestLastName");
        order.chooseCountry("Finland");
        order.fillAddress("ul. Puławska 41/23");
        order.fillZipCode("20-341");
        order.fillCity("Lublin");
        order.fillPhoneNum("123456789");
        order.fillEmail("asd@dsa.pl");
        order.placeOrder();
    }

}
