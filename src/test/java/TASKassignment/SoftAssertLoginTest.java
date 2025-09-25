package TASKassignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertLoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Verify negative login with soft assertions")
    public void negativeLoginTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://claruswaysda.github.io/signIn.html");

        driver.findElement(By.id("username")).sendKeys("wronguser");

        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("submitButton")).click();

        Thread.sleep(1000); // انتظار بسيط حتى يظهر الـ alert
        Alert alert = driver.switchTo().alert();

        // Soft assertions
        softAssert.assertNotNull(alert, " Alert is not displayed!");
        softAssert.assertEquals(alert.getText(),
                "Incorrect username or password",
                " Alert text is incorrect!");

        alert.accept();
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
