package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ActionHelper;
import utilities.TestBase;

import static org.testng.Assert.assertTrue;

public class C12_SoftAssertion extends TestBase {
    /*
        Open page https://practicetestautomation.com/practice-test-login/
        Type username incorrectUser into Username field
        Type password Password123 into Password field
        Push Submit button
        Verify error message is displayed
        Verify error message text is Your username is invalid!
     */

    @Test (groups = "SmokeTest")
    void hardAssertionTest() {
        ActionHelper actionHelper = new ActionHelper(driver);

//        Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

//        Type username incorrectUser into Username field
        driver.findElement(By.id("username")).sendKeys("incorrectUser");

//        Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");

//        Push Submit button
        actionHelper.click(driver.findElement(By.id("submit")));

//        Verify error message is displayed
        WebElement error = driver.findElement(By.id("error"));
        //assert error.isDisplayed();
        //assert actionHelper.isElementVisible(By.id("error"));//Java Assertion
        assertTrue(actionHelper.isElementVisible(By.id("error")));

//        Verify error message text is "Your username is invalid!"
        Assert.assertEquals(actionHelper.getText(error), "Your username is invalid!", "Messages did not match!");
    }

    @Test (groups = "SmokeTest")
    void softAssertionTest() {
        ActionHelper actionHelper = new ActionHelper(driver);
//        Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

//        Type username incorrectUser into Username field
        driver.findElement(By.id("username")).sendKeys("incorrectUser");

//        Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");

//        Push Submit button
        actionHelper.click(driver.findElement(By.id("submit")));

//        Verify error message is displayed

        WebElement error = driver.findElement(By.id("error"));
        //assert error.isDisplayed();
        //assert actionHelper.isElementVisible(By.id("error"));//Java Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actionHelper.isElementVisible(By.id("error")));

//        Verify error message text is "Your username is invalid!"
        softAssert.assertEquals(actionHelper.getText(error), "Your username is invalid!", "Messages did not match!");

        softAssert.assertAll();
    }

}