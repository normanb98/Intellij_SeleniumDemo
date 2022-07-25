package Cucumber_Tests;

import Intellij_Selenium.OpenAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Intellij_Selenium.AddCustomerPage;
import Intellij_Selenium.BankManagerMainPage;
import Intellij_Selenium.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateNewCustomerTestCucumber {

    protected WebDriver driver;

    @Given("user is on home Page")
    public void user_is_on_home_page() {
        LoginPage loginPage = new LoginPage(driver);
        driver = TestRunner.getDriver();
        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(loginPage.homeBy));
    }

    @When("select Bank manager login")
    public void select_bank_manager_login() {
        BankManagerMainPage bankManagerMainPage = new BankManagerMainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("Bank Manager Login");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(bankManagerMainPage.addCustomerBy));
    }

    @When("select Add customer")
    public void select_add_customer() throws InterruptedException {
        BankManagerMainPage bankManagerMainPage = new BankManagerMainPage(driver);
        bankManagerMainPage.clickOnButton("Add Customer");
        Thread.sleep(1000);
    }

    @Then("add First name")
    public void add_first_name() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addFirstName("Test");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(addCustomerPage.addCustomerBy));
    }

    @Then("add last name")
    public void add_last_name() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addLastName("Cucumber");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(addCustomerPage.addCustomerBy));
    }

    @Then("add Post code")
    public void add_post_code() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addPostCode("1234");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(addCustomerPage.addCustomerBy));
    }

    @Then("click Add customer")
    public void click_add_customer() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addCustomerBy();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.switchTo().alert());
    }

    @Then("verify new customer Chrome pop-up")
    public void verify_chrome_pop_up() {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.verifyPopUp("Customer added successfully");
    }
}
