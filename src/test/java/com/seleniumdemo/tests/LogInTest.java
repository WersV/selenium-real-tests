package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogInTest extends BaseTest {

    @DataProvider
    public Object[][] logInData() throws IOException {
        return ExcelReader.readExcel("logInData.xlsx");
    }

    @Test(dataProvider = "logInData")
    public void logInUser(String email, String password) {
        driver.get("http://seleniumdemo.com/");
        new HomePage(driver)
        .enterRegistrationPage()
        .enterLogEmail(email)
        .enterLogPassword(password)
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
