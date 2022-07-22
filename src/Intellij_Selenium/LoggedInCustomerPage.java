package Intellij_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoggedInCustomerPage {
    protected WebDriver driver;

    private By accountNumberBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/strong[1]");
    private By balanceBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/strong[2]");
    private By currencyBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/strong[3]");
    public By depositBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[2]");
    public By withdrawBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[3]");
    private By transactionsBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[1]");
    private By accountBy = By.xpath("//*[@id='accountSelect']");
    private By homeBy = By.xpath("/html/body/div[3]/div/div[1]/button[1]");
    private By logoutBy = By.xpath("/html/body/div[3]/div/div[1]/button[2]");

    public LoggedInCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountNumber() {
        return driver.findElement(accountNumberBy).getText();
    }

    public String getBalance() {
        return driver.findElement(balanceBy).getText();
    }

    public String getCurrency() {
        return driver.findElement(currencyBy).getText();
    }

    public void selectAccount(String accountNumber) {

        WebElement dropdownAccount = driver.findElement(accountBy);
        Select selectElementAccount = new Select(dropdownAccount);

        selectElementAccount.selectByVisibleText(accountNumber);

    }

    public void deposit(String depositAmount) throws InterruptedException {

        driver.findElement(depositBy).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(depositAmount);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/button")).click();

    }

    public void withdraw(String withdrawAmount) throws InterruptedException {

        driver.findElement(withdrawBy).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(withdrawAmount);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/button")).click();

    }

    public void clickOnButton(String clickOn) {
        if (clickOn.equals("Transactions")) {
            driver.findElement(transactionsBy).click();
        }
        else if (clickOn.equals("Home")) {
            driver.findElement(homeBy).click();
        }
        else if (clickOn.equals("Logout")) {
            driver.findElement(logoutBy).click();
        }
    }

    public void verifyAmount(String amount) {
        LoggedInCustomerPage loggedInCustomerPage = new LoggedInCustomerPage(driver);
        Assert.assertEquals(loggedInCustomerPage.getBalance(), amount);

        if ((loggedInCustomerPage.getBalance()).equals(amount)) {
            System.out.println(this.getClass().getSimpleName() + " PASSED");
        }
        else {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }
    }
}