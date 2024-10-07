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

        String productAddSuccessText = new HomePage(driver)
        .clickShopBtn()
        .openProduct("Java Selenium WebDriver")
        .addToCartBtnClick()
        .divEl().getText();

        Assert.assertTrue(productAddSuccessText.contains("“Java Selenium WebDriver” has been added to your cart."));

        Customer customer = new Customer();

        new ProductDetailsPage(driver)
        .viewCartBtnClick()
        .proceedToCheckoutBtnClick()
        .fillAddressDetails(customer);

        OrderPlacedPage orderPlaced = new OrderPlacedPage(driver);
        WebElement orderReceivedMsg = orderPlaced.getOrderReceivedMsg();
        Assert.assertEquals(orderReceivedMsg.getText(), "Thank you. Your order has been received.");

        WebElement orderProductName = orderPlaced.getProductName();
        Assert.assertEquals(orderProductName.getText(), "Java Selenium WebDriver");
    }
}