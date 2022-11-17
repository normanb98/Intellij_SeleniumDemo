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

    @BeforeSuite
    public void beforeSuite() {
        from selenium import webdriver
        from webdriver_manager.chrome import ChromeDriverManager

        driver = webdriver.Chrome(ChromeDriverManager().install())
    }

    @AfterSuite (alwaysRun = true)
    public void afterSuite() {
        driver.quit();
    }
}
