package com.seleniumdemo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class OrderDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "select2-billing_country-container")
    private WebElement countryComboBox;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement countryComboBoxInput;

    @FindBy(xpath = "//ul[@id='select2-billing_country-results']//li")
    private List<WebElement> countryComboBoxResults;

    private final WebDriver driver;

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillFirstNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void fillLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void chooseCountry(String countryName) {
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", countryComboBox);
        countryComboBox.click();
        countryComboBoxInput.sendKeys(countryName);
        countryComboBoxResults.stream().filter(el -> el.isDisplayed()).filter(el -> Objects.equals(el.getText(), countryName)).findFirst().ifPresent(el -> el.click());
    }
}
