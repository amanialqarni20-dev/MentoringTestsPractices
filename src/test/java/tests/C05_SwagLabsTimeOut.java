package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_SwagLabsTimeOut extends TestBase {

    /*
    Go to https://www.saucedemo.com/
    Enter username and password
    Hit enter
    Assert 'Products'
    User must log in in 10 seconds
     */

    @Test(timeOut = 10000, groups = "SmokeTest") //  group
    void loginTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);
        assert driver.findElement(By.xpath("//*[.='Products']")).isDisplayed();
    }
}
