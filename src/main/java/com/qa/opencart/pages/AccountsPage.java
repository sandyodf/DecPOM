package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

    private WebDriver driver;
    private By search_btn =By.xpath("//input[@placeholder='Search']");

    private By click_search = By.xpath("//button[@type='button' and contains(@class,'btn-default')]");

    private By account_drp_down =By.xpath("//a[@title='My Account']");

    private By click_on_wishlist =By.xpath("//a[normalize-space()='MacBook']/../../following-sibling::div/button[contains(@onclick,'wish')]");


    private  By samsung_tab =By.xpath("//a[normalize-space()='Samsung Galaxy Tab 10.1']/../../following-sibling::div/button[contains(@onclick,'wish')]");
    private  By wish_list =By.linkText("Wish List");

    private  By wishlist_alert = By.xpath("//div[contains(@class,'alert')]");


    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }


    public SearchPage doSearchForProduct(String productName){
      WebElement ele= driver.findElement(search_btn);
      ele.clear();
      ele.sendKeys(productName);
        driver.findElement(click_search).click();
        return new SearchPage(driver);
    }
    public void clickOnAccounts(){
        driver.findElement(account_drp_down).click();
    }

    public void addMacbookProToWishList(){
        driver.findElement(click_on_wishlist).click();
    }
    public void addSamsungTabProToWishList(){
        driver.findElement(samsung_tab).click();
    }


    public boolean isaddedToWishList(){
      return   driver.findElement(wishlist_alert).isDisplayed();
    }

    public String getWishlistAlert(){
       return  driver.findElement(wishlist_alert).getText();
    }
    public WishlistPage goToWishlist() throws InterruptedException {
        driver.findElement(wish_list).click();
        return new WishlistPage(driver);
    }

    public void addProductToWishList(String Product){
        String productIs ="//a[normalize-space()="+Product+"]/../../following-sibling::div/button[contains(@onclick,'wish')]";
        driver.findElement(By.xpath(productIs)).click();
    }


}
