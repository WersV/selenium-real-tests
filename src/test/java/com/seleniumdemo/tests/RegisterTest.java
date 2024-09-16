package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.MyAccPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        WebElement myAccH1 = driver.findElement(By.xpath("//h1[@class='entry-title' and text()='My account']"));
        Assert.assertEquals(myAccH1.getText(), "My account");
    }
}
