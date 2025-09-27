package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C14_CrossBrowserTesting extends TestBase {
    /*
    Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

    Enter username and password

    Click on login

    Assert that you are logged in
     */

    @Test
    @Parameters({ "username", "password"})
    void crossBrowserTesting( @Optional("Admin") String username , @Optional("admin123") String password ){

//        Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        Enter username and password
        driver.findElement(By.name("username")).sendKeys(username);
        WebElement passwordinput= driver.findElement(By.name("password"));
        passwordinput.sendKeys(password);
        Assert.assertEquals(passwordinput.getAttribute("type"), "password");
//        Click on login
        driver.findElement(By.xpath("//button [@type= 'submit']")).click();
//        Assert that you are logged in
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).isDisplayed());
    }

}