package Intellij_Selenium;

import org.openqa.selenium.WebDriver;

public class OpenAccountTest {

    protected WebDriver driver;

    public OpenAccountTest(WebDriver driver) {
        this.driver = driver;
    }

    public void runTest() throws InterruptedException {

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.clickOnButton("Open Account");

        Thread.sleep(1000);

        openAccountPage.openAccount("Demo Test", "Dollar");

        Thread.sleep(1000);

        try {
            driver.switchTo().alert().accept();
            System.out.println(this.getClass().getSimpleName() + " PASSED");

        } catch (Exception e) {
            System.out.println(this.getClass().getSimpleName() + " FAILED");
        }

    }
}