package main.java.Intellij_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class InitWebDriver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite (alwaysRun = true)
    public void afterSuite() {
        driver.quit();
    }
}
