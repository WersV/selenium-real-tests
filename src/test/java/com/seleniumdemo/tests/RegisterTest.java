package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        driver.get("http://seleniumdemo.com/");

        String dashboardLinkText = new HomePage(driver)
        .enterRegistrationPage()
        .enterRegEmail()
        .enterRegPassword()
        .clickRegisterBtn()
        .getDashboardLink().getText();

        Assert.assertEquals(dashboardLinkText, "Dashboard");
    }

    @Test
    public void failToRegisterWhenDataRedundant() {
        driver.get("http://seleniumdemo.com/");

        String errorText = new HomePage(driver)
        .enterRegistrationPage()
        .enterRegEmail("test@test.pl")
        .enterRegPassword()
        .clickRegisterBtn()
        .getRedundantEmailError().getText();

        Assert.assertEquals(errorText, "Error: An account is already registered with your email address. Please log in.");
    }
}
