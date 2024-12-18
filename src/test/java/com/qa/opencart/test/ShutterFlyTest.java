package com.qa.opencart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ShutterFlyTest {

    public static void main(String[] args) throws InterruptedException {

        By email_btn = By.cssSelector("#email");
        By password_btn = By.cssSelector("#password");
        By sign_btn = By.cssSelector("#signInButton");
        By projectHeader = By.xpath("(//li[contains(@class,'container')])[1]");
        By sing_out = By.linkText("Sign Out");
        By accounts_values = By.xpath("//ul[contains(@class,'logged-in-dropdown-list')]/li");

        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.shutterfly.com/");

        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(email_btn).sendKeys("xeummoigrevaqui-3760@yopmail.com");
        driver.findElement(password_btn).sendKeys("S@ndeep919");
        driver.findElement(sign_btn).click();
        Thread.sleep(4000);
        String s = driver.getTitle();
        System.out.println("Title is " + s);
        driver.findElement(projectHeader).click();
        String urlAfterLogin = driver.getTitle();
        System.out.println("url After Login" + urlAfterLogin);
        Thread.sleep(5000);

        List<WebElement> values = driver.findElements(accounts_values);
        int count = 1;
        for (WebElement e :
                values
        ) {
            System.out.println(count + "." + e.getText());
            count++;
//            if (e.getText().equals("Order Status")){
//                e.click();
//                break;
        }
        driver.close();
    }

//        Actions ac = new Actions(driver);
//        ac.moveToElement(driver.findElement(sing_out));
//        ac.click(driver.findElement(sing_out));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
//      WebElement we =wait.until(ExpectedConditions.visibilityOf(driver.findElement(sing_out)));
//      we.click();
//        String urlAfterLogout = driver.getCurrentUrl();
//        System.out.println("url After Logout" + urlAfterLogout);


}

