package Cucumber_Tests;

import Intellij_Selenium.LoggedInCustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DepositWithdrawTestCucumber {

    protected WebDriver driver;

    @Given("user is on logged in customer page")
    public void user_is_on_logged_in_customer_page() {
        driver = TestRunner.getDriver();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("deposit money")
    public void deposit_money() throws InterruptedException {
        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        loggedInCustomerPage.deposit("1000");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("withdraw money")
    public void withdraw_money() throws InterruptedException {
        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        loggedInCustomerPage.withdraw("500");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("verify money")
    public void verify_money() {
        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        Assert.assertEquals(loggedInCustomerPage.getBalance(), "500");

        if ((loggedInCustomerPage.getBalance()).equals("500")) {
            System.out.println(this.getClass().getSimpleName() + " PASSED");
        }
        else {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }
        //throw new io.cucumber.java.PendingException();
    }

}
