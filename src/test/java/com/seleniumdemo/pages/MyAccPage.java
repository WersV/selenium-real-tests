package com.seleniumdemo.pages;

import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailEl;

    @FindBy(id = "reg_password")
    private WebElement password;

    @FindBy(xpath = "//button[@name='register']")
    private WebElement registerBtn;

    @FindBy(xpath = "//a[text()='Dashboard']")
    private WebElement dashboardLink;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li[text()=' An account is already registered with your email address. Please log in.\t\t']")
    private WebElement redundantEmailError;

    @FindBy(id = "username")
    private WebElement logEmailEl;

    @FindBy(id = "password")
    private WebElement logPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement logInBtn;

    @FindBy(xpath = "//li[text()=': Incorrect username or password.']")
    private WebElement logInErrorMsgEl;

    WebDriver driver = null;

    public MyAccPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebElement getRegEmailEl() {
        return regEmailEl;
    }

    public MyAccPage enterRegEmail() {
        int emailSeed = SeleniumHelper.generateSeedForEmail();
        regEmailEl.sendKeys(emailSeed+"@test.com");
        return this;
    }

    public MyAccPage enterRegEmail(String email) {
        regEmailEl.sendKeys(email);
        return this;
    }

    public MyAccPage enterRegPassword() {
        password.sendKeys("SecretPassword1!");
        return this;
    }

    public MyAccPage clickRegisterBtn() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", registerBtn);
        return this;
    }

    public WebElement getDashboardLink() {
        return dashboardLink;
    }

    public WebElement getRedundantEmailError() {
        return redundantEmailError;
    }

    //logging in
    public MyAccPage enterLogEmail(String email) {
        logEmailEl.sendKeys(email);
        return this;
    }
    public MyAccPage enterLogPassword(String password) {
        logPassword.sendKeys(password);
        return this;
    }

    public MyAccPage clickLogInBtn() {
        logInBtn.click();
        return this;
    }

    public WebElement getLogInErrorMsgEl() {
        return logInErrorMsgEl;
    }
}
