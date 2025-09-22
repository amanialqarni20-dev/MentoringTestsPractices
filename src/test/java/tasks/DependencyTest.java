package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependencyTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        System.out.println("WebDriver is set up");
    }

    @Test
    void openYahoo() {
        driver.get("https://yahoo.com");
        System.out.println("Navigating to Yahoo");
    }

    @Test(dependsOnMethods = "openYahoo")
    void openBing() {
        driver.get("https://bing.com");
        System.out.println("Navigating to Bing");
    }

    @Test(dependsOnMethods = "openBing")
    void openDuckDuckGo() {
        driver.get("https://duckduckgo.com");
        System.out.println("Navigating to DuckDuckGo");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("WebDriver is closed");
    }
}
