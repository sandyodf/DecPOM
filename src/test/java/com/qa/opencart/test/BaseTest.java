package com.qa.opencart.test;

import com.qa.opencart.pages.*;
import comm.qa.opencart.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;
    DriverFactory drivefactory;
    protected AccountsPage acc;
    protected SearchPage sp;
    protected WishlistPage wishlistpage;

    protected PIPpage pip;
   protected LoginPage lp;

    @BeforeTest
    public void setup() {
        drivefactory = new DriverFactory();
        driver = drivefactory.initiateBrowser("chrome");
        lp = new LoginPage(driver);

    }

//    @AfterTest
//    public void tearDown() {
//        System.out.println("closing browser");
//        driver.close();
//    }
}
