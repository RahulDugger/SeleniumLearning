import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ConfirmationPage;
import pages.FormPage;

import java.time.Duration;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class KeyboardAndMouseInput {
    WebDriver driver = null;
    public KeyboardAndMouseInput()
    {
        System.setProperty("web-driver.chrome.driver", "C:\\Tools\\For installation\\chromedriver");

        driver = new ChromeDriver();

    }

    @Test
    public void Keypress() {

        driver.get("https://formy-project.herokuapp.com/keypress");

        WebElement el = driver.findElement(By.id("name"));
        el.click();
        el.sendKeys("Test Name");

        WebElement btn = driver.findElement(By.id("button"));
        btn.click();

       // driver.quit();
    }

    @Test
    public void AutoComplete() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));

        autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.dismissButton")));

        //Thread.sleep(1000);
        okButton.click();

        //WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        //autocompleteResult.click();
    }
@Test
    public void Scroll()
    {
        driver.get("https://formy-project.herokuapp.com/scroll");

        WebElement name = driver.findElement(By.id("name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        name.sendKeys("TestName");

        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("01/01/2020");

    }
@Test
    public void SwichToActiveWindow() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement btnForNewTab = driver.findElement(By.id("new-tab-button"));
        btnForNewTab.click();

        String originalWindowHandle = driver.getWindowHandle();

        for(String windowHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(windowHandle);
        }
        Thread.sleep(2000);
        driver.switchTo().window(originalWindowHandle);
    }
@Test
    public void SwitchAndAcceptAleart()
    {
        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement alertBtn = driver.findElement(By.id("alert-button"));
        alertBtn.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
@Test
    public void ExecuteJavaScript() {
        driver.get("https://formy-project.herokuapp.com/modal");
        WebElement modalBtn = driver.findElement(By.id("modal-button"));
        modalBtn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        WebElement closeBtn = driver.findElement(By.id("close-button"));
        closeBtn.click();

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click()",closeBtn);

    }
@Test
    public void DragAndDrop()
    {
        driver.get("https://formy-project.herokuapp.com/dragdrop");

        WebElement image = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(image,box).build().perform();
    }

@Test
    public void RadioButton() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/radiobutton");
        WebElement radioBtn1 = driver.findElement(By.id("radio-button-1"));

        Thread.sleep(3000);

        WebElement radioBtn2=driver.findElement(By.cssSelector("input[value='option2']"));
        radioBtn2.click();

        Thread.sleep(3000);

        WebElement radioBtn3 = driver.findElement(By.cssSelector("input[value$='3']"));
        radioBtn3.click();

        Thread.sleep(3000);
    }
@Test
    public void DatePicker()
    {
        driver.get("https://formy-project.herokuapp.com/datepicker");

        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("08/08/2020");
        datePicker.sendKeys(Keys.RETURN);
    }
    @Test
    public void Dropdown()
    {
        driver.get("https://formy-project.herokuapp.com/dropdown");

        WebElement dropDown = driver.findElement(By.id("dropdownMenuButton"));
        dropDown.click();

        WebElement autocompleMenu = driver.findElement(By.cssSelector("a[id='autocomplete']"));
        autocompleMenu.click();

    }
@Test
    public void fileUpload()
    {
        driver.get("https://formy-project.herokuapp.com/fileupload");

        WebElement fileUpload = driver.findElement(By.id("file-upload-field"));
        fileUpload.sendKeys("C:\\Users\\Rahul\\OneDrive\\Documents\\new 1.txt");
    }
@Test
    public void Form()
    {
        FormPage formPage = new FormPage();
        ConfirmationPage confirmationPage = new ConfirmationPage();
        formPage.FillForm(driver);
        confirmationPage.WaitForAlert(driver);
        assertEquals("The form was successfully submitted!",confirmationPage.getAlertText(driver));
    }







}
