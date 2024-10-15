package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.utils.ExcelReader;
import org.openqa.selenium.WebElement;
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
        test = extentReports.createTest("LogInTest");
        driver.get("http://seleniumdemo.com/");
        WebElement statement = new HomePage(driver)
        .enterRegistrationPage()
        .enterLogEmail(email)
        .enterLogPassword(password)
        .clickLogInBtn()
        .getHelloStatement();

        int index = email.indexOf('@');
        String emailTextBeforeAt = email.substring(0,index); //this is shown username after log in

        Assert.assertTrue(statement.getText().contains("Hello "+emailTextBeforeAt));
    }

    @Test
    public void logInUser() {
        test = extentReports.createTest("LogInTest");
        driver.get("http://seleniumdemo.com/");
        WebElement statement = new HomePage(driver)
                .enterRegistrationPage()
                .enterLogEmail("test@test.com")
                .enterLogPassword("SecretPassword1!")
                .clickLogInBtn()
                .getHelloStatement();

        Assert.assertTrue(statement.getText().contains("Hello test"));
    }

    @Test
    public void logInInvalidUser() {
        test = extentReports.createTest("LogInTest");
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
