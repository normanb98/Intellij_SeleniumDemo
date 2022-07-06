package Intellij_Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DepositWithdrawTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = InitWebDriver.getDriver();
    }

    @Test (description = "Making bank transfers and checking if the currency amount is right")
    public void runTest() throws InterruptedException {

        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        loggedInCustomerPage.deposit("1000");

        Thread.sleep(1000);

        loggedInCustomerPage.withdraw("500");

        Thread.sleep(1000);

        Assert.assertEquals(loggedInCustomerPage.getBalance(), "500");

        if ((loggedInCustomerPage.getBalance()).equals("500")) {
            System.out.println(this.getClass().getSimpleName() + " PASSED");
        }
        else {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }

    }

}