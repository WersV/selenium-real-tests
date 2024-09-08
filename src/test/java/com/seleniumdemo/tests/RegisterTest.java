package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        driver.get("http://seleniumdemo.com/");
        HomePage registerPage = new HomePage(driver);
        registerPage.enterRegistrationPage();
    }
}
