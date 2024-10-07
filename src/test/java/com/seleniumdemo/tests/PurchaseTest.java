package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.*;
import org.openqa.selenium.WebElement;
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
        OrderPlacedPage orderPlaced = new OrderPlacedPage(driver);

        home.clickShopBtn();
        shop.openProduct("Java Selenium WebDriver");
        product.addToCartBtnClick();
        String productAddSuccessText =  product.divEl().getText();
        Assert.assertTrue(productAddSuccessText.contains("“Java Selenium WebDriver” has been added to your cart."));
        product.viewCartBtnClick();
        product.proceedToCheckoutBtnClick();

        Customer customer = new Customer();
        order.fillAddressDetails(customer);

        WebElement orderReceivedMsg = orderPlaced.getOrderReceivedMsg();
        Assert.assertEquals(orderReceivedMsg.getText(), "Thank you. Your order has been received.");

        WebElement orderProductName = orderPlaced.getProductName();
        Assert.assertEquals(orderProductName.getText(), "Java Selenium WebDriver");
    }
}