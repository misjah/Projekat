package FinalProject.Tests;

import FinalProject.Pages.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BasicTests {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected String adminDefault = "admin@admin.com";
    protected String adminDefaultPassword = "12345";
    protected SignUp signUp;
    protected Login loginPage;
    protected Nav navPage;
    protected MessagePopUp messagePopUp;

    protected Cities cities;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        driver = new EdgeDriver();
 //       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();




        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        loginPage = new Login(driver);
        navPage = new Nav(driver);
        signUp = new SignUp(driver);
        cities = new Cities(driver);
        messagePopUp = new MessagePopUp(driver);


    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void tearDown(ITestResult result) {
        String timestamp = new SimpleDateFormat(
                "hh_mm_ss_dd_MM_yyyy").format(new Date());

        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot screen = (TakesScreenshot) driver;
            File screenshot = screen.getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(screenshot, new File(
                        "src/main/java/FinalProject/Tests/" + result.getName() + timestamp +  ".png"));
            } catch (IOException e) {
                e.printStackTrace();
//        }


            }
        }
    }
}