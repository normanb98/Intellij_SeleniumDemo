package main.java.Intellij_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomersPage {
    protected WebDriver driver;

    private By searchCustomerBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/form/div/div/input");
    private By addCustomerBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[1]");
    private By openAccountBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[2]");
    private By sortByFirstNameBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/table/thead/tr/td[1]/a");
    private By sortByLastNameBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/table/thead/tr/td[2]/a");
    private By sortByPostCodeBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/table/thead/tr/td[3]/a");
    private By homeBy = By.xpath("/html/body/div[3]/div/div[1]/button[1]");

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchCustomer(String customer) {
        driver.findElement(searchCustomerBy).sendKeys(customer);
    }

    public void deleteCustomer(String accountNumber) {
        driver.findElement(By.xpath(String.format("/html/body/div[3]/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[contains(text(), {0})]/../td[5]/button", accountNumber))).click();
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
    }

    public void sort(String sortBy) {
        if (sortBy.equals("First Name")) {
            driver.findElement(sortByFirstNameBy).click();
        }
        else if (sortBy.equals("Last Name")) {
            driver.findElement(sortByLastNameBy).click();
        }
        else if (sortBy.equals("Post Code")) {
            driver.findElement(sortByPostCodeBy).click();
        }
    }
}