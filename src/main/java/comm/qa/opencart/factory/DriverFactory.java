package comm.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver driver;

    public WebDriver initiateBrowser(String browserName) {
        switch (browserName.toLowerCase().trim()) {

            case "chrome":
                driver = new ChromeDriver();
                System.out.println("chrome is launched");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;

            default:
                System.out.println("invalid browser name ");

        }

        driver.manage().deleteAllCookies();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        System.out.println("maximized screen");
        return driver;
    }
}
