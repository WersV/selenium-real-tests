package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.MyAccPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        driver.get("http://seleniumdemo.com/");
        HomePage registerPage = new HomePage(driver);
        registerPage.enterRegistrationPage();

        MyAccPage myAccPage = new MyAccPage(driver);
        myAccPage.enterRegEmail();
        myAccPage.enterRegPassword();

        myAccPage.clickRegisterBtn();

        Assert.assertEquals(myAccPage.getDashboardLink().getText(), "Dashboard");
    }

    @Test
    public void failToRegisterWhenDataRedundant() {
        driver.get("http://seleniumdemo.com/");
        HomePage registerPage = new HomePage(driver);
        registerPage.enterRegistrationPage();

        MyAccPage myAccPage = new MyAccPage(driver);
        myAccPage.enterRegEmail("test@test.pl");
        myAccPage.enterRegPassword();
        myAccPage.clickRegisterBtn();
        WebElement errorEl = myAccPage.getRedundantEmailError();
        Assert.assertEquals(errorEl.getText(), "Error: An account is already registered with your email address. Please log in.");
    }
}
