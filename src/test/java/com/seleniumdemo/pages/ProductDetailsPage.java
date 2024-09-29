package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    @FindBy(xpath = "//button[@name='add-to-cart' and text()='Add to cart']")
    private WebElement addToCartBtn;


    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addToCartBtnClick() {
        addToCartBtn.click();
    }

}
