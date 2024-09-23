package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.MyAccPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        driver.get("http://seleniumdemo.com/");
        HomePage registerPage = new HomePage(driver);
        registerPage.enterRegistrationPage();

        MyAccPage myAccPage = new MyAccPage(driver);
        myAccPage.enterEmail();
        myAccPage.enterPassword();

        myAccPage.clickRegisterBtn();

        Assert.assertEquals(myAccPage.getDashboardLink().getText(), "Dashboard");
    }

}
