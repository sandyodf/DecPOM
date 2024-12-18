package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WishlistPage {
    private WebDriver driver;
    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }
    By count = By.xpath("//td[text()='Product Name']/ancestor::thead/following-sibling::tbody/tr");

    By product_names =By.xpath("//td[text()='Product Name']/ancestor::thead/following-sibling::tbody/tr/td[2]");


    public int noOfProductsInWishList(){
       return driver.findElements(count).size();
    }

    public List<String> productNamesInWishList(){
        List<String> values = new ArrayList<>();
       List<WebElement> ok= driver.findElements(product_names);

        for (WebElement value: ok
             ) {
            values.add(value.getText());

        }
        return values;
    }


}
