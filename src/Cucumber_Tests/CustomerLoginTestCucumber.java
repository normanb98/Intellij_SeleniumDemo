package Cucumber_Tests;

import Intellij_Selenium.CustomersPage;
import Intellij_Selenium.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Intellij_Selenium.CustomerMainPage;



public class CustomerLoginTestCucumber {

    protected WebDriver driver;


    @Given("user is on home page")
    public void user_is_on_home_page() throws InterruptedException {
        driver = TestRunner.getDriver();
        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        Thread.sleep(2000);
    }

    @When("select Customer Login")
    public void select_customer_login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("Customer Login");
        Thread.sleep(1000);
    }

    @Then("select Harry Potter")
    public void select_harry_potter() throws InterruptedException {
        CustomerMainPage customerMainPage = new CustomerMainPage(driver);
        customerMainPage.loginCustomer("Harry Potter");
        Thread.sleep(1000);
    }

    @Then("verify the name")
    public void verify_the_name() {
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.verifyName("Harry Potter");
    }
}
