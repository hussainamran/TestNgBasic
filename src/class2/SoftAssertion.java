package class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertion {
    WebDriver driver;

    //pre condition @before method --lunch browser and navigate url

    @BeforeMethod(alwaysRun = true)
    public void openBrowserAndLunchApplication() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void verifyAndValidateSoftAssertions(){
        SoftAssert soft=new SoftAssert();

        String actualTitle= driver.getTitle();
        String expectedTitle= "Human Manaaagement System";
        soft.assertEquals(actualTitle,expectedTitle);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement welcomeText=driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        soft.assertTrue(welcomeText.isDisplayed());
        System.out.println("I am still executing even after failing the test above");

        soft.assertAll();//should be the last line test case
    }
    //post condition @after method -- close browser
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
