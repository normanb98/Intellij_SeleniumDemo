package Intellij_Selenium;

import org.openqa.selenium.WebDriver;

public class DepositWithdrawTest {

    protected WebDriver driver;

    public DepositWithdrawTest(WebDriver driver) {
        this.driver = driver;
    }

    public void runTest() throws InterruptedException {

        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        loggedInCustomerPage.deposit("1000");

        Thread.sleep(1000);

        loggedInCustomerPage.withdraw("500");

        Thread.sleep(1000);

        if ((loggedInCustomerPage.getBalance()).equals("500")) {
            System.out.println(this.getClass().getSimpleName() + " PASSED");
        }
        else {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }

    }
}