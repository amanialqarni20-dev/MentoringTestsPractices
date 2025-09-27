package TASKassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class NegativeSignInTest extends TestBase {

    /*
    Go to https://claruswaysda.github.io/signIn.html
    Do negative test with all scenarios
    */

    @DataProvider
    public Object[][] negativeLoginData() {
        return new Object[][]{
                {"", "", "Please enter username and password"},       // Empty username & password
                {"validUser", "", "Please enter password"},           // Empty password
                {"", "validPass", "Please enter username"},           // Empty username
                {"wrongUser", "wrongPass", "Invalid credentials"}    // Invalid credentials
        };
    }

    @Test(dataProvider = "negativeLoginData")
    public void negativeSignInTest(String username, String password, String expectedError) {
        driver.get("https://claruswaysda.github.io/signIn.html");

        // Input username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.clear();
        usernameInput.sendKeys(username);

        // Input password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        // Click Sign In button (correct selector)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signInButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit'][value='Sign In']"))
        );
        signInButton.click();

        // Verify error message
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("error"))
        );

        Assert.assertEquals(errorMessage.getText(), expectedError, "Error message mismatch!");
    }
}
