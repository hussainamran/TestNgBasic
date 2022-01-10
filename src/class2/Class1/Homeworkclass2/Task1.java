package class2.Class1.Homeworkclass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Task1 {
    /*
    TC 2: HRMS Application Negative Login:
    Open chrome browser
    Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
    Enter valid username
    Leave password field empty
    Verify error message with text “Password cannot be empty” is displayed.
     */
    WebDriver driver;

    //pre condition @before method -- launch browser and navigate url
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test()
    public void verifyErrorMessage() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword"));
        driver.findElement(By.id("btnLogin")).click();

        SoftAssert softAssert=new SoftAssert();

        WebElement massage=driver.findElement(By.xpath("//*[text()='Password cannot be empty']"));
        softAssert.assertTrue(massage.isDisplayed());
        String actualMassage=massage.getText();
        String expectedMassage="Password cannot be empt";
        softAssert.assertEquals(actualMassage,expectedMassage);
        softAssert.assertAll();
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
