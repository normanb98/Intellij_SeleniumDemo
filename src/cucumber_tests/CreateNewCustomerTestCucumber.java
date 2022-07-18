package cucumber_tests;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.Intellij_Selenium.AddCustomerPage;
import main.java.Intellij_Selenium.BankManagerMainPage;
import main.java.Intellij_Selenium.InitWebDriver;
import main.java.Intellij_Selenium.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CreateNewCustomerTestCucumber {

    protected WebDriver driver;

    @Before
    public void beforeTest() {
        driver = InitWebDriver.getDriver();
    }

    @Given("user is on home page")
    public void user_is_on_home_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        Thread.sleep(2000);
        //throw new io.cucumber.java.PendingException();
    }
    @When("select  Bank manager login")
    public void select_bank_manager_login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("Bank Manager Login");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }
    @When("select Add customer")
    public void select_add_customer() throws InterruptedException {
        BankManagerMainPage bankManagerMainPage = new BankManagerMainPage(driver);
        bankManagerMainPage.clickOnButton("Add Customer");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("add First name")
    public void add_first_name() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addFirstName("Test");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("add last name")
    public void add_last_name() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addLastName("Cucumber");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("add Post code")
    public void add_post_code() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addPostCode("1234");
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("click Add customer")
    public void click_add_customer() throws InterruptedException {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addCustomerBy();
        Thread.sleep(1000);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("verify Chrome pop-up")
    public void verify_chrome_pop_up() {
        try {
            Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer added successfully"));
            driver.switchTo().alert().accept();
            System.out.println(this.getClass().getSimpleName() + " PASSED");

        } catch (Exception e) {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }
        //throw new io.cucumber.java.PendingException();
    }
}
