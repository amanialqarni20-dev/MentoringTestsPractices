package TASKassignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class CrossBrowserTest extends TestBase {
    /*
      Go to https://claruswaysda.github.io/ActionsForm.html
      Fill form and submit
      Do all actions and assert
      Do this test with Chrome, Edge and Firefox
    */

    @Test
    public void T01CrossBrowserTest() {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

        driver.findElement(By.id("name")).sendKeys("Amani");
        driver.findElement(By.id("age")).sendKeys("20");
        new Select(driver.findElement(By.id("options"))).selectByValue("it");
        driver.findElement(By.xpath("//input[@value='coding']")).click();
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Your passcode is:"));
    }
}
