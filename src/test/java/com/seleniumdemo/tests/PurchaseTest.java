package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.*;
import com.seleniumdemo.utils.ExcelReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @DataProvider
    public Object[][] testData() throws IOException {
        return ExcelReader.readExcel("testData.xlsx");
    }

    @Test(dataProvider = "testData")
    public void purchaseProductTestWithDataProvider(String email, String passw, String firstName, String lastName, String companyName, String country, String address, int zipCode, String city, int phone, String orderNotes) throws InterruptedException {
        driver.get("http://seleniumdemo.com/");

        String productAddSuccessText = new HomePage(driver)
                .clickShopBtn()
                .openProduct("Java Selenium WebDriver")
                .addToCartBtnClick()
                .divEl().getText();

        Assert.assertTrue(productAddSuccessText.contains("“Java Selenium WebDriver” has been added to your cart."));

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setCountry(country);
        customer.setAddress(address);
        customer.setZipCode(String.valueOf(zipCode));
        customer.setCity(city);
        customer.setPhoneNum(String.valueOf(phone));
        customer.setEmail(email);

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