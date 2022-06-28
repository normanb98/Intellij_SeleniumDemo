package Intellij_Selenium;

import org.openqa.selenium.WebDriver;

public class CreateNewCustomerTest {

    protected WebDriver driver;

    public CreateNewCustomerTest(WebDriver driver) {
        this.driver = driver;
    }

    public void runTest() throws InterruptedException {

        driver.navigate().to("https://www.way2automation.com/angularjs-protractor/banking/#/login");

        /*new WebDriverWait(driver, TimeSpan.FromSeconds(5)).Until(
        d => d.FindElement(By.TagName("div")));*/

        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButton("Bank Manager Login");

        Thread.sleep(1000);

        BankManagerMainPage bankManagerMainPage = new BankManagerMainPage(driver);
        bankManagerMainPage.clickOnButton("Add Customer");

        Thread.sleep(1000);

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addCustomer("Demo", "Test", "xxxx");

        Thread.sleep(1000);

        try {
            driver.switchTo().alert().accept();
            System.out.println(this.getClass().getSimpleName() + " PASSED");

        } catch (Exception e) {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }

    }
}