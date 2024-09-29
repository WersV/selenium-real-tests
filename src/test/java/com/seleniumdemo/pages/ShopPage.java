package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class ShopPage {

    @FindBy(xpath = "//h2[text()='Java Selenium WebDriver']")
    private WebElement javaSeleniumWebDriverProduct;

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void chooseProduct(String productName) {
        if(Objects.equals(productName, "Java Selenium WebDriver")) {
            javaSeleniumWebDriverProduct.click();
        }
    }
}
