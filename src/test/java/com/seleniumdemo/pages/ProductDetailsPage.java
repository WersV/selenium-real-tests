package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    @FindBy(xpath = "//button[@name='add-to-cart' and text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement productAddedTextDiv;

    @FindBy(xpath = "//a[text()='View cart']")
    private WebElement viewCartBtn;

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutBtn;

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addToCartBtnClick() {
        addToCartBtn.click();
    }

    public WebElement divEl() {
        return productAddedTextDiv;
    }

    public void viewCartBtnClick() {
        viewCartBtn.click();
    }

    public void proceedToCheckoutBtnClick() {
        proceedToCheckoutBtn.click();
    }

}
