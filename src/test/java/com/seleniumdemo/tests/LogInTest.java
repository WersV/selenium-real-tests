package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.MyAccPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test
    public void logInUser() {
        driver.get("http://seleniumdemo.com/");
        HomePage registerPage = new HomePage(driver);
        registerPage.enterRegistrationPage();

        MyAccPage myAccPage = new MyAccPage(driver);
        myAccPage.enterLogEmail("test@test.pl")
        .enterLogPassword("SecretPassword1!")
        .clickLogInBtn();
    }

    @Test
    public void logInInvalidUser() {
        driver.get("http://seleniumdemo.com/");
        HomePage registerPage = new HomePage(driver);
        registerPage.enterRegistrationPage();

        MyAccPage myAccPage = new MyAccPage(driver);
        myAccPage.enterLogEmail("342342test@test.pl");
        myAccPage.enterLogPassword("SecretPassword1!");
        myAccPage.clickLogInBtn();
        String errorMsg = myAccPage.getLogInErrorMsgEl().getText();
        Assert.assertTrue(errorMsg.contains("Incorrect username or password."));
    }
}
