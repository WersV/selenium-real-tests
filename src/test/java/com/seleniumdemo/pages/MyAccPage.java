package com.seleniumdemo.pages;

import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccPage {

    @FindBy(id = "reg_email")
    private WebElement email;

    @FindBy(id = "reg_password")
    private WebElement password;

    @FindBy(xpath = "//button[@name='register']")
    private WebElement registerBtn;

    @FindBy(xpath = "//a[text()='Dashboard']")
    private WebElement dashboardLink;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li[text()=' An account is already registered with your email address. Please log in.\t\t']")
    private WebElement redundantEmailError;

    WebDriver driver = null;

    public MyAccPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebElement getEmail() {
        return email;
    }

    public void enterEmail() {
        int emailSeed = SeleniumHelper.generateSeedForEmail();
        email.sendKeys(emailSeed+"@test.com");
    }

    public void enterPassword() {
        password.sendKeys("SecretPassword1!");
    }

    public void clickRegisterBtn() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", registerBtn);
    }

    public WebElement getDashboardLink() {
        return dashboardLink;
    }

    public WebElement getRedundantEmailError() {
        return redundantEmailError;
    }

}
