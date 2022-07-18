package main.java.Intellij_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {
    protected WebDriver driver;

    private By customerNameBy = By.xpath("//*[@id='userSelect']");
    private By currencyBy = By.xpath("//*[@id='currency']");
    private By processBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/button");
    private By addCustomerBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[1]");
    private By openAccountBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[2]");
    private By customersBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[3]");
    private By homeBy = By.xpath("/html/body/div[3]/div/div[1]/button[1]");

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAccount(String customer, String currency) {

        WebElement dropdownCustomer = driver.findElement(customerNameBy);
        Select selectElementCustomer = new Select(dropdownCustomer);

        WebElement dropdownCurrency = driver.findElement(currencyBy);
        Select selectElementCurrency = new Select(dropdownCurrency);

        selectElementCustomer.selectByVisibleText(customer);
        selectElementCurrency.selectByVisibleText(currency);

        driver.findElement(processBy).click();

    }

    public void clickOnButton(String clickOn) {
        if (clickOn.equals("Home")) {
            driver.findElement(homeBy).click();
        }
        else if (clickOn.equals("Add Customer")) {
            driver.findElement(addCustomerBy).click();
        }
        else if (clickOn.equals("Open Account")) {
            driver.findElement(openAccountBy).click();
        }
        else if (clickOn.equals("Customers")) {
            driver.findElement(customersBy).click();
        }
    }
}