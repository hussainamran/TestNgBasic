package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;

    //pre condition @before method -- launch browser and navigate url
    @BeforeMethod(alwaysRun = true)
    public static void openBrowserAndLaunchApplication() {
        configReader.readProperties("C:\\Users\\Amran\\eclipse-workspace\\TestNgBasicsBatch11\\src\\config\\config.properties");
        switch (configReader.getPropertyValue("browser")){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox" :
                System.setProperty("webdriver.chrome.driver", "Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(configReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
