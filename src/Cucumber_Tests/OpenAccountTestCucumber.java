package Cucumber_Tests;

import Intellij_Selenium.OpenAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OpenAccountTestCucumber {

    protected WebDriver driver;

    @Given("user is on bank manager page")
    public void user_is_on_bank_manager_page() {
        driver = TestRunner.getDriver();
        //throw new io.cucumber.java.PendingException();
    }

    @When("select Open Account")
    public void select_open_account() throws InterruptedException {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.clickOnButton("Open Account");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("select Customer")
    public void select_customer() throws InterruptedException {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectCustomer("Test Cucumber");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("select Currency")
    public void select_currency() throws InterruptedException {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectCurrency("Dollar");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("click Process")
    public void click_process() throws InterruptedException {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.processBy();
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("verify open account Chrome pop-up")
    public void verify_chrome_pop_up() {
        try {
            Assert.assertTrue(driver.switchTo().alert().getText().contains("Account created successfully"));
            driver.switchTo().alert().accept();
            System.out.println(this.getClass().getSimpleName() + " PASSED");

        } catch (Exception e) {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }
        //throw new io.cucumber.java.PendingException();
    }

}
