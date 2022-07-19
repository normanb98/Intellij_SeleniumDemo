package Cucumber_Tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@CucumberOptions(features = "src/Cucumber_Tests", glue = "Cucumber_Tests")
public class TestRunner extends AbstractTestNGCucumberTests {

    static protected WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void createWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void deleteWebDriver(){
        driver.quit();
    }

}
