package TASKassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HardAssertLoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Verify positive login with hard assertions")
    public void positiveLoginTest() {

        driver.get("https://claruswaysda.github.io/signIn.html");

        driver.findElement(By.id("username")).sendKeys("admin");

        driver.findElement(By.id("password")).sendKeys("123");

        driver.findElement(By.id("submitButton")).click();

        String expectedUrl = "https://claruswaysda.github.io/signIn.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, " URL is not as expected!");

        WebElement employeeTable = driver.findElement(By.xpath("//h2[text()='Employee Table']"));
        Assert.assertTrue(employeeTable.isDisplayed(), " Employee Table is NOT displayed!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
