package com.seleniumdemo.pages;

import org.openqa.selenium.JavascriptExecutor;
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

    private final WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductDetailsPage addToCartBtnClick() {
        addToCartBtn.click();
        return this;
    }

    public WebElement divEl() {
        return productAddedTextDiv;
    }

    public ProductDetailsPage viewCartBtnClick() {
        viewCartBtn.click();
        return this;
    }

    public OrderDetailsPage proceedToCheckoutBtnClick() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", proceedToCheckoutBtn);
        return new OrderDetailsPage(driver);
    }

}
