package com.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
    public void logInUserWithDataProvider(String email, String password) {
        driver.get("http://seleniumdemo.com/");
        new HomePage(driver)
        .enterRegistrationPage()
        .enterLogEmail(email)
        .enterLogPassword(password)
        .clickLogInBtn();
    }

    @Test
    public void logInUser() {
        ExtentTest test = extentReports.createTest("LogInTest");
        driver.get("http://seleniumdemo.com/");
        new HomePage(driver)
                .enterRegistrationPage()
                .enterLogEmail("tescv cx vx t@test.com")
                .enterLogPassword("SecretPassword1!")
                .clickLogInBtn();
        test.log(Status.PASS, "Log in done");
    }

    @Test
    public void logInInvalidUser() {
        ExtentTest test = extentReports.createTest("LogInTest");
        driver.get("http://seleniumdemo.com/");
        String errorMsg = new HomePage(driver)
        .enterRegistrationPage()
        .enterLogEmail("342342test@test.pl")
        .enterLogPassword("SecretPassword1!")
        .clickLogInBtn()
        .getLogInErrorMsgEl().getText();
        Assert.assertTrue(errorMsg.contains("Incorrect username or password."));
        test.log(Status.PASS, "Log in done");
    }
}
