package main.java.Intellij_Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewCustomerTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = InitWebDriver.getDriver();
    }

    @Test (description = "Creating a customer and checking if the creation was successful")
    public void runTest() throws InterruptedException {

        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");

        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("Bank Manager Login");

        Thread.sleep(1000);

        BankManagerMainPage bankManagerMainPage = new BankManagerMainPage(driver);
        bankManagerMainPage.clickOnButton("Add Customer");

        Thread.sleep(1000);

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addCustomer("Demo", "Test", "xxxx");

        Thread.sleep(1000);

        try {
            Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer added successfully"));
            driver.switchTo().alert().accept();
            System.out.println(this.getClass().getSimpleName() + " PASSED");

        } catch (Exception e) {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }

    }

}