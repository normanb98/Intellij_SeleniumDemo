package main.java.Intellij_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionsPage {
    protected WebDriver driver;

    private By backBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[1]");
    private By resetBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[2]");
    private By leftArrowBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[1]");
    private By rightArrowBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[3]");
    private By topBy = By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[2]");
    private By startDateBy = By.xpath("//*[@id='start']");
    private By endDateBy = By.xpath("//*[@id='end']");
    private By homeBy = By.xpath("/html/body/div[3]/div/div[1]/button[1]");
    private By logoutBy = By.xpath("/html/body/div[3]/div/div[1]/button[2]");

    public TransactionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDates(String startDate, String endDate) {

    }

    public void clickOnButton(String clickOn) {
        if (clickOn.equals("Home")) {
            driver.findElement(homeBy).click();
        }
        else if (clickOn.equals("Logout")) {
            driver.findElement(logoutBy).click();
        }
        else if (clickOn.equals("Back")) {
            driver.findElement(backBy).click();
        }
        else if (clickOn.equals("Reset")) {
            driver.findElement(resetBy).click();
        }
        else if (clickOn.equals("<")) {
            driver.findElement(leftArrowBy).click();
        }
        else if (clickOn.equals("Top")) {
            driver.findElement(topBy).click();
        }
        else if (clickOn.equals(">")) {
            driver.findElement(rightArrowBy).click();
        }
    }
}