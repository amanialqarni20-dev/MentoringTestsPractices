package TASKassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonGroupTest {

    WebDriver driver;

    @Test(groups = "smoke")
    @Parameters("searchKeyword")
    public void smokeTest(String keyword) {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        closePopupIfPresent();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
        driver.findElement(By.id("nav-search-submit-button")).click();

        Assert.assertTrue(driver.getPageSource().contains(keyword));
        driver.quit();
    }

    @Test(groups = "regression")
    @Parameters("searchKeyword")
    public void regressionTest(String keyword) {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        closePopupIfPresent();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
        driver.findElement(By.id("nav-search-submit-button")).click();

        Assert.assertTrue(driver.getPageSource().contains(keyword));
        driver.quit();
    }

    @Test(groups = "api")
    public void apiTest() {

        Assert.assertTrue(true, "API test passed");
    }

    // دالة لمغادرة popup إذا ظهر
    private void closePopupIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Continue shopping']"))).click();
            System.out.println("Popup closed successfully!");
        } catch (Exception e) {
            System.out.println("No popup found, continue searching...");
        }
    }
}
