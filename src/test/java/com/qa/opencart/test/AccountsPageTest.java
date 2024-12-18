package com.qa.opencart.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {

    @BeforeTest
    public void dologinacc() {
        acc = lp.doLogin("sandeep.vadlapudi@valuelabs.com", "S@ndeep919");
    }

    @Test(priority = 1)
    public void performSearchTest() {
        acc.doSearchForProduct("samsung");
    }

//    @Test(priority = 2)
//    public void clickOnAccountsTest() {
//        acc.clickOnAccounts();
//    }
    @Test(priority = 2)
    public void addProductToWishlist() throws InterruptedException {
        acc.addProductToWishList("'Samsung Galaxy Tab 10.1'");
        acc.addProductToWishList("'Samsung SyncMaster 941BW'");
    }
    @Test(priority = 3)
    public void performSearchTest2() {
        acc.doSearchForProduct("macbook");
    }
    @Test(priority = 4)
    public void addProductToWishlist2() throws InterruptedException {
        acc.addProductToWishList("'MacBook'");
        acc.addProductToWishList("'MacBook Air'");
    }
    @Test(priority = 5)
    public void performSearchTest3() {
        acc.doSearchForProduct("iphone");
    }
    @Test(priority = 6)

    public void addProductToWishlist3() throws InterruptedException {
        acc.addProductToWishList("'iPhone'");
    }
    @Test(priority = 7)
    public void count_test() throws InterruptedException {
      wishlistpage=  acc.goToWishlist();
     int num=   wishlistpage.noOfProductsInWishList();
        System.out.println("No of products "+num);
      List<String> products=wishlistpage.productNamesInWishList();
        System.out.println("Product nm"+products);
    }




//    @Test(priority = 3)
//    public void performSearchTest2() {
//        acc.doSearchForProduct("samsung");
//    }
//
//    @Test(priority =4)
//    public void addSamsungTabProToWishListTest(){
//        acc.addSamsungTabProToWishList();
//
//    }
//    @Test
//    public void productTest(){
//        String product ="'Samsung Galaxy Tab 10.1'";
//        String productpath = "//a[normalize-space()="+product+"]/../../following-sibling::div/button[contains(@onclick,'wish')]";
//        System.out.println(productpath);
//    }



}
