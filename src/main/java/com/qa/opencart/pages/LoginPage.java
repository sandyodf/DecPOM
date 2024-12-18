package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
 private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private By userName_btn =By.name("email");
    private By password_btn =By.name("password");
    private By forgotPassword_link =By.linkText("Forgotten Password");
    private  By login_btn = By.xpath("//input[@type='submit']");
    private By rightLinks =By.xpath("//div[@class='list-group']/a");

    private  By image_link =By.xpath("//img[@title='naveenopencart']");


    public String getPageTitle(){
      String Title =  driver.getTitle();
      return Title;
    }

    public String getUrl(){
        String  url =driver.getCurrentUrl();
        return url;
    }

    public boolean isForgetPasswordLinkDisplayed(){
       return  driver.findElement(forgotPassword_link).isDisplayed();
    }

    public List<String> linksOnRight(){
      List<WebElement>  links= driver.findElements(rightLinks);
      List<String> listofLinks = new ArrayList<>();
        for (WebElement link:links
             ) {
            String value =link.getText();
            listofLinks.add(value);
        }
        return  listofLinks;
    }

    public boolean isImageDispalyed(){
       return driver.findElement(image_link).isDisplayed();
    }

    public  AccountsPage doLogin(String username,String password){
       WebElement user= driver.findElement(userName_btn);
                user.clear();
                user.sendKeys(username);
        WebElement passwo= driver.findElement(password_btn);
        passwo.clear();
        passwo.sendKeys(password);
        driver.findElement(login_btn).click();
        return new AccountsPage(driver);
    }



}
