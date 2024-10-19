package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest extends BaseTest {

    @DataProvider
    public Object[][] logInData() throws IOException {
        return ExcelReader.readExcel("logInData.xlsx");
    }

    @Test(dataProvider = "logInData")
    public void registerUserTestWithDataProvider(String email, String password) {
        test = extentReports.createTest("RegisterTest");
        driver.get("http://seleniumdemo.com/");

        String dashboardLinkText = new HomePage(driver)
        .enterRegistrationPage()
        .enterRegEmail(email)
        .enterRegPassword(password)
        .clickRegisterBtn()
        .getDashboardLink().getText();

        Assert.assertEquals(dashboardLinkText, "Dashboard");
    }

    @Test
    public void registerUserTest() {
        test = extentReports.createTest("RegisterTest");
        driver.get("http://seleniumdemo.com/");

        String dashboardLinkText = new HomePage(driver)
                .enterRegistrationPage()
                .enterRegEmail("test4121@test.com")
                .enterRegPassword("SecretPassword1!")
                .clickRegisterBtn()
                .getDashboardLink().getText();

        Assert.assertEquals(dashboardLinkText, "Dashboard");
    }

    @Test
    public void failToRegisterWhenDataRedundant() {
        test = extentReports.createTest("RegisterTest");
        driver.get("http://seleniumdemo.com/");

        String errorText = new HomePage(driver)
        .enterRegistrationPage()
        .enterRegEmail("test4121@test.pl")
        .enterRegPassword()
        .clickRegisterBtn()
        .getRedundantEmailError().getText();

        Assert.assertEquals(errorText, "Error: An account is already registered with your email address. Please log in.");
    }
}
