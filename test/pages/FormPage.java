package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage {

    public  void FillForm(WebDriver driver)
    {
        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.cssSelector("input[id^='first']")).sendKeys("First");

        driver.findElement(By.cssSelector("input[id*='last']")).sendKeys("Last");

        driver.findElement(By.cssSelector("input[id$='title']")).sendKeys("Title");
        driver.findElement(By.cssSelector("input#radio-button-2")).click();
        driver.findElement(By.cssSelector("input[value='checkbox-1']")).click();

        driver.findElement(By.cssSelector("option[value$='1']")).click();
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("01/01/2020");

        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']")).click();
    }
}
