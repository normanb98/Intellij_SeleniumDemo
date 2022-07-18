package main.java.Intellij_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerMainPage {
    protected WebDriver driver;

    private By yourNameBy = By.xpath("//*[@id='userSelect']");
    private By loginBy = By.xpath("/html/body/div[3]/div/div[2]/div/form/button");
    private By homeBy = By.xpath("/html/body/div[3]/div/div[1]/button[1]");

    public CustomerMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginCustomer(String user) {

        WebElement dropdownYourName = driver.findElement(yourNameBy);
        Select selectElementYourName = new Select(dropdownYourName);

        selectElementYourName.selectByVisibleText(user);

        driver.findElement(loginBy).click();
    }
}