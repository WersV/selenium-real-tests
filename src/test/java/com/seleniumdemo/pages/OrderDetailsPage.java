package com.seleniumdemo.pages;

import com.seleniumdemo.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class OrderDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_country")
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

    @FindBy(xpath = "//button[text()='Place order']")
    private WebElement orderBtn;

    private final WebDriver driver;

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillAddressDetails(Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        Select countrySelect = new Select(countryComboBox);
        countrySelect.selectByVisibleText(customer.getCountry());
        addressInput.sendKeys(customer.getAddress());
        zipCodeInput.sendKeys(customer.getZipCode());
        cityInput.sendKeys(customer.getCity());
        phoneInput.sendKeys(customer.getPhoneNum());
        emailInput.sendKeys(customer.getEmail());
        orderBtn.click();
    }
}
