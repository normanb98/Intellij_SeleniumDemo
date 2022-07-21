package Cucumber_Tests;

import Intellij_Selenium.CustomersPage;
import Intellij_Selenium.LoggedInCustomerPage;
import Intellij_Selenium.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Intellij_Selenium.CustomerMainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CustomerLoginTestCucumber {

    protected WebDriver driver;


    @Given("user is on home page")
    public void user_is_on_home_page() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver = TestRunner.getDriver();
        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions
                        .elementToBeClickable(loginPage.customerLoginBy));
    }

    @When("select Customer Login")
    public void select_customer_login() throws InterruptedException {
        CustomerMainPage customerMainPage = new CustomerMainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("Customer Login");
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(customerMainPage.yourNameBy));
    }

    @Then("select Harry Potter")
    public void select_harry_potter() throws InterruptedException {
        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        CustomerMainPage customerMainPage = new CustomerMainPage(driver);
        customerMainPage.loginCustomer("Harry Potter");
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(loggedInCustomerPage.depositBy));
    }

    @Then("verify the name")
    public void verify_the_name() {
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.verifyName("Harry Potter");
    }
}
