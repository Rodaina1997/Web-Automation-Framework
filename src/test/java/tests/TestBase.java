package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {

     WebDriver driver;
    WebDriverWait wait;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            //WebDriver.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            //WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://practice.automationtesting.in/");
    }

    @AfterClass
    public void TearDown(){
        driver.quit();

    }

}
