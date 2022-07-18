package main.java.Intellij_Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenAccountTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = InitWebDriver.getDriver();
    }

    @Test (description = "Open an account for the customer and checking if it was successful")
    public void runTest() throws InterruptedException {

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.clickOnButton("Open Account");

        Thread.sleep(1000);

        openAccountPage.openAccount("Demo Test", "Dollar");

        Thread.sleep(1000);

        try {
            Assert.assertTrue(driver.switchTo().alert().getText().contains("Account created successfully"));
            driver.switchTo().alert().accept();
            System.out.println(this.getClass().getSimpleName() + " PASSED");

        } catch (Exception e) {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }

    }

}