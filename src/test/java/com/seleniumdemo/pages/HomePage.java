package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    @FindBy(xpath = "//span[@class='nav__title' and text()='My account']")
    private List<WebElement> myAccLink;

    @FindBy(xpath = "//span[@class='nav__title' and text()='Shop']")
    private List<WebElement> ShopBtn;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterRegistrationPage() {
        myAccLink.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
    }

    public void clickShopBtn() {
        ShopBtn.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
    }
}
