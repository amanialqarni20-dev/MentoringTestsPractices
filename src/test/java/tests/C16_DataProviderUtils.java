package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C16_DataProviderUtils extends TestBase {
    /*
    Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
    Enter username using data provider utilities
    Enter password using data provider utilities
    Enter comment using data provider utilities
    Enter dropdown using data provider utilities
     */

    @Test(dataProvider = "getRecords")
    void dataProviderUtilsTest(String username){
//        Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
//        Enter username using data provider utilities
driver.findElement(By.name("username")).sendKeys(username);
//        Enter password using data provider utilities

//        Enter comment using data provider utilities
        
//        Enter dropdown using data provider utilities


    }

}