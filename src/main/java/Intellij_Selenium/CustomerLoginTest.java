package Intellij_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomerLoginTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = InitWebDriver.getDriver();
    }

    @Test (description = "Login with the customer and checking if the right customer is logged in")
    public void runTest() throws InterruptedException {

        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");

        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("Customer Login");

        Thread.sleep(1000);

        CustomerMainPage customerMainPage = new CustomerMainPage(driver);
        customerMainPage.loginCustomer("Demo Test");

        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/strong/span")).getText(), "Demo Test");

        if ((driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/strong/span")).getText()).equals("Demo Test")) {
            System.out.println(this.getClass().getSimpleName() + " PASSED");
        }
        else {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }

    }

}