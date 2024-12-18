package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PIPpage {
    private WebDriver driver;
    private By productInfo = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
    private By priceInfo = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
    private By product = By.cssSelector("div.col-sm-4 h1");
    Map<String, String> linkProduct;

    public PIPpage(WebDriver driver) {
        this.driver = driver;
    }

    public String productName() {
        return driver.findElement(product).getText();
    }

    public Map<String, String> getProductMetaInfo() {
        List<WebElement> links = driver.findElements(productInfo);
        linkProduct = new HashMap<>();
        for (WebElement e : links
        ) {
            String[] meta = e.getText().split(":");
            String key_p = meta[0].trim();
            String value_p = meta[1].trim();
            linkProduct.put(key_p, value_p);

        }
        System.out.println("price");
        List<WebElement> prices = driver.findElements(priceInfo);
        String price = prices.get(0).getText();
        System.out.println("price inside");
        linkProduct.put("Price", price);

        String tx_price_raw = prices.get(1).getText();
        System.out.println(tx_price_raw);
        linkProduct.put("tx_Price", price);
        System.out.println(linkProduct);
        return linkProduct;
    }

}
