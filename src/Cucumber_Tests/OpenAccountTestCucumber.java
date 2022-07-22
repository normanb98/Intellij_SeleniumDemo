package Cucumber_Tests;

import Intellij_Selenium.OpenAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OpenAccountTestCucumber {

    protected WebDriver driver;

    @Given("user is on bank manager page")
    public void user_is_on_bank_manager_page() {
        driver = TestRunner.getDriver();
    }

    @When("select Open Account")
    public void select_open_account() throws InterruptedException {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.clickOnButton("Open Account");
        Thread.sleep(2000);
    }

    @Then("select Customer")
    public void select_customer() {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectCustomer("Test Cucumber");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(openAccountPage.processBy));
    }

    @Then("select Currency")
    public void select_currency() {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectCurrency("Dollar");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(openAccountPage.processBy));
    }

    @Then("click Process")
    public void click_process() {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.processBy();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.switchTo().alert());
    }

    @Then("verify open account Chrome pop-up")
    public void verify_chrome_pop_up() {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.verifyPopUp("Account created successfully");
    }
}
