package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private By SearchProducts =By.cssSelector("div#content div.product-layout");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public int searchProductsCount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
       List<WebElement> products= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SearchProducts));
        return products.size();
    }

    public PIPpage selectProductAfterSearch(String product){
        By productLocator= By.linkText(product);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator)).click();
        return  new PIPpage(driver);
    }
//    String costOfProduct = driver.findElement(By.xpath("((//div[@class='col-sm-4'])[2]//ul)[2]//h2")).getText();

}
