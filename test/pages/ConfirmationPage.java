package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {

    public void WaitForAlert(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']"))));
    }
    public String getAlertText(WebDriver driver)
    {
        return  driver.findElement(By.xpath(("//div[@role='alert']"))).getText();
    }
}
