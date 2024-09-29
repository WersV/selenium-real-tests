package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.ProductDetailsPage;
import com.seleniumdemo.pages.ShopPage;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseProductTest() {
        driver.get("http://seleniumdemo.com/");
        HomePage home = new HomePage(driver);
        ShopPage shop = new ShopPage(driver);
        ProductDetailsPage product = new ProductDetailsPage(driver);

        home.clickShopBtn();
        shop.chooseProduct("Java Selenium WebDriver");
        product.addToCartBtnClick();


    }

}
