package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccPage {

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(id = "reg_password")
    private WebElement password;

    @FindBy(name = "register")
    private WebElement registerBtn;

    public MyAccPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    public void enterEmail() {

        email.sendKeys("test@test.com");
    }

    public void enterPassword() {
        password.sendKeys("SecretPassword1!");
    }

    public void clickRegisterBtn() {
        registerBtn.click();
    }

}
