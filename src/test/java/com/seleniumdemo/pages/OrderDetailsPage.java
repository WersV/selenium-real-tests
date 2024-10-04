package com.seleniumdemo.pages;

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

    @FindBy(id = "billing_address_1")
    private WebElement addressInput;

    @FindBy(id = "billing_postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "billing_city")
    private WebElement cityInput;

    @FindBy(id = "billing_phone")
    private WebElement phoneInput;

    @FindBy(id = "billing_email")
    private WebElement emailInput;

    @FindBy(id = "place_order")
    private WebElement orderBtn;

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
        countryComboBox.click();
        countryComboBoxInput.sendKeys(countryName);
        countryComboBoxResults.stream().filter(el -> el.isDisplayed()).filter(el -> Objects.equals(el.getText(), countryName)).findFirst().ifPresent(el -> el.click());
    }

    public void fillAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void fillZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void fillCity(String city) {
        cityInput.sendKeys(city);
    }

    public void fillPhoneNum(String phoneNum) {
        phoneInput.sendKeys(phoneNum);
    }

    public void fillEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void placeOrder() {
        orderBtn.click();
    }
}
