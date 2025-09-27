package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;

import static org.testng.Assert.assertEquals;

public class C13_Parameters extends TestBase {
    /*
    Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
    Enter username, password and comment by using parameters.
    Assert them.
     */

    @Test
    @Parameters({"username", "password", "comment"})
    void parametersTest(@Optional("JohnDoe") String username, @Optional("John.123") String password, @Optional("Hello this is just a comment!") String comment) {

//        Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//        Enter username, password and comment by using parameters.
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        WebElement comments = driver.findElement(By.name("comments"));
        comments.clear();
        comments.sendKeys(comment);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        Assert them.
        assertEquals(driver.getCurrentUrl(), "https://testpages.eviltester.com/styled/the_form_processor.php");

    }
}
