package Cucumber_Tests;

import Intellij_Selenium.LoggedInCustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DepositWithdrawTestCucumber {

    protected WebDriver driver;

    @Given("user is on logged in customer page")
    public void user_is_on_logged_in_customer_page() {
        driver = TestRunner.getDriver();
    }

    @Then("deposit money")
    public void deposit_money() throws InterruptedException {
        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        loggedInCustomerPage.deposit("1000");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .elementToBeClickable(loggedInCustomerPage.withdrawBy));
    }

    @Then("withdraw money")
    public void withdraw_money() throws InterruptedException {
        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        loggedInCustomerPage.withdraw("500");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .elementToBeClickable(loggedInCustomerPage.withdrawBy));
    }

    @Then("verify money")
    public void verify_money() {
        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        loggedInCustomerPage.verifyAmount("500");
    }
}
