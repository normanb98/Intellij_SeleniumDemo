package Cucumber_Tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Intellij_Selenium.AddCustomerPage;
import Intellij_Selenium.BankManagerMainPage;
import Intellij_Selenium.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateNewCustomerTestCucumber {

    protected WebDriver driver;

    @Given("user is on home Page")
    public void user_is_on_home_page() throws InterruptedException {
        driver = TestRunner.getDriver();
        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        Thread.sleep(2000);
    }

    @When("select Bank manager login")
    public void select_bank_manager_login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("Bank Manager Login");
        Thread.sleep(1000);
    }

    @When("select Add customer")
    public void select_add_customer() throws InterruptedException {
        BankManagerMainPage bankManagerMainPage = new BankManagerMainPage(driver);
        bankManagerMainPage.clickOnButton("Add Customer");
        Thread.sleep(1000);
    }

    @Then("add First name")
    public void add_first_name() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addFirstName("Test");
        Thread.sleep(1000);
    }

    @Then("add last name")
    public void add_last_name() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addLastName("Cucumber");
        Thread.sleep(1000);
    }

    @Then("add Post code")
    public void add_post_code() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addPostCode("1234");
        Thread.sleep(1000);
    }

    @Then("click Add customer")
    public void click_add_customer() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addCustomerBy();
        Thread.sleep(1000);
    }

    @Then("verify new customer Chrome pop-up")
    public void verify_chrome_pop_up() {
        try {
            Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer added successfully"));
            driver.switchTo().alert().accept();
            System.out.println(this.getClass().getSimpleName() + " PASSED");

        } catch (Exception e) {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }
    }

}
