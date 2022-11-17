package Intellij_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class InitWebDriver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }
    
    @BeforeAll
 public static void classInit() {
 WebDriverManager.chromedriver().setup();
 }

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        page = new CheckoutPage(driver);
        page.navigate();
 
    }

    @AfterSuite (alwaysRun = true)
    public void afterSuite() {
        driver.quit();
    }
}
