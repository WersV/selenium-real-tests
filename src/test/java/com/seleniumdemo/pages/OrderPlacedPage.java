package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedPage {

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement orderReceivedMsg;

    @FindBy(xpath = "//td[@class='woocommerce-table__product-name product-name']//a")
    private WebElement productName;

    public OrderPlacedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getOrderReceivedMsg() {
        return orderReceivedMsg;
    }

    public WebElement getProductName() {
        return productName;
    }

}
