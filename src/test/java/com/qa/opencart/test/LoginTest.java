package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends  BaseTest {

    @Test(priority = 3)
    public void isforgotpasswordDisplayed_Test() {
        String actualTitle = lp.getPageTitle();
        Assert.assertEquals(actualTitle, "Account Login");
    }

    ;

    @Test(priority = 1)
    public void isLogoDisplayedTest() {
        boolean is = lp.isImageDispalyed();
        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void LinksTest() {
        List<String> list = lp.linksOnRight();

        boolean lis = list.contains("Login");
        Assert.assertTrue(lis);

    }

    @DataProvider
    @Test
    public Object[][] credentials() {
        return new Object[][]{
                {"","S@ndeep919"},
                {"sandeep.vadlapudi@valuelabs.com","S@ndeep919."},
                {"",""},
                {"sandeep.vadlapudi@valuelabs.com","S@ndeep919"},

        };
    }
//    @Test(priority = 5)
//    public void doLoginTestWithOutPassword() {
//        lp.doLogin("sandeep.vadlapudi@valuelabs.com", "S@ndeep919");
//    }
    @Test(priority = 5,dataProvider = "credentials")
    public void doLoginTestWithOutUsername(String username ,String password) throws InterruptedException {
        lp.doLogin(username, password);
        System.out.println(username);
        Thread.sleep(3000);
    }


}
