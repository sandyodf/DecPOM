package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchPageTest extends BaseTest {
    @BeforeTest
    public void dologinacc() {
        acc = lp.doLogin("sandeep.vadlapudi@valuelabs.com", "S@ndeep919");
    }

    @DataProvider
    public Object[][] searchProduct() {
        return new Object[][]{
                {"macbook"},
                {"imac"},
                {"samsung"},
                {"apple"}

        };
    }

    @DataProvider
    public Object[][] searchProductGetTitle() {
        return new Object[][]{
                {"macbook","MacBook Pro"},
                {"imac","iMac"},
                {"samsung","Samsung Galaxy Tab 10.1"}

        };
    }

    @Test(dataProvider="searchProduct")
    public void performSearchTest(String productValue) {
        sp = acc.doSearchForProduct(productValue);
        int productDisplayed = sp.searchProductsCount();
        Assert.assertTrue(productDisplayed > 0);
    }

    @Test(dataProvider = "searchProductGetTitle")
    public void selectProductTest(String prod,String title){
        sp = acc.doSearchForProduct(prod);
        if (sp.searchProductsCount()>0) {
         pip =  sp.selectProductAfterSearch(title);
          String actual =  pip.productName();
          Assert.assertEquals(actual,title);
        }

    }
    @Test
    public void printElementsTest(){
       sp= acc.doSearchForProduct("macbook");
        pip=  sp.selectProductAfterSearch("MacBook Pro");
       Map<String,String> metaInfo= pip.getProductMetaInfo();
        System.out.println("Brand is "+metaInfo.get("Brand"));
    }

}
