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

public class AmazonSearchTest {

    WebDriver driver;

    @Test
    @Parameters("searchKeyword")
    public void amazonSearchTest(String keyword) {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        // محاولة إغلاق نافذة "Continue shopping" إذا ظهرت
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Continue shopping']"))).click();
            System.out.println("Popup closed successfully!");
        } catch (Exception e) {
            System.out.println("No popup found, continue searching...");
        }

        // الانتظار حتى يظهر textbox البحث
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        // البحث عن الكلمة
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
        driver.findElement(By.id("nav-search-submit-button")).click();

        // التحقق من النتائج
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(keyword),
                "Search results should contain: " + keyword);

        driver.quit();
    }
}
