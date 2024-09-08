package com.seleniumdemo.tests;

import com.seleniumdemo.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
