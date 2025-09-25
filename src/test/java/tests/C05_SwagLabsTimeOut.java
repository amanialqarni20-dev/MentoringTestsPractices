package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_SwagLabsTimeOut {

    /*
    Go to https://www.saucedemo.com/v1/index.html
    Enter username and password
    Hit enter
    Assert 'Products'
    User must log in in 10 seconds
     */

    @Test(timeOut = 10000)
    void loginTest() {

        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);

    }

    protected WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}