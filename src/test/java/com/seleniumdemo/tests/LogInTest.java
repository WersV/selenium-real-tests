package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test
    public void logInUser() {
        driver.get("http://seleniumdemo.com/");
        new HomePage(driver)
        .enterRegistrationPage()
        .enterLogEmail("test@test.pl")
        .enterLogPassword("SecretPassword1!")
        .clickLogInBtn();
    }

    @Test
    public void logInInvalidUser() {
        driver.get("http://seleniumdemo.com/");
        String errorMsg = new HomePage(driver)
        .enterRegistrationPage()
        .enterLogEmail("342342test@test.pl")
        .enterLogPassword("SecretPassword1!")
        .clickLogInBtn()
        .getLogInErrorMsgEl().getText();
        Assert.assertTrue(errorMsg.contains("Incorrect username or password."));
    }
}
