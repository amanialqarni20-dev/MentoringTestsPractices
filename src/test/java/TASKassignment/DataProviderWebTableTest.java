package TASKassignment;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtilities;
import utilities.TestBase;

public class DataProviderWebTableTest extends TestBase {

    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add records to the table using DataProvider
    Do it with all 3 ways
    */

    @DataProvider
    public Object[][] getDataStatic() {
        return new Object[][]{
                {"John Doe", "23", "Canada"},
                {"Mary Lee", "34", "US"},
                {"Tom Hanks", "82", "Australia"}
        };
    }

    @DataProvider
    public Object[][] getDataFaker() {
        Faker faker = new Faker();
        return new Object[][]{
                {faker.name().fullName(), faker.number().numberBetween(18, 60), "USA"},
                {faker.name().fullName(), faker.number().numberBetween(18, 60), "UK"},
                {faker.name().fullName(), faker.number().numberBetween(18, 60), "Canada"}
        };
    }

    @DataProvider
    public Object[][] getDataExcel() {
        ExcelUtilities eu = new ExcelUtilities("testData/Users.xlsx", "Employees");
        return eu.getExcelDataAsArray();
    }

    @Test(dataProvider = "getDataStatic")
    public void dataProviderStaticTest(String name, String age, String country) {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age);
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();
    }

    @Test(dataProvider = "getDataFaker")
    public void dataProviderFakerTest(String name, int age, String country) {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age + "");
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();
    }

    @Test(dataProvider = "getDataExcel")
    public void dataProviderExcelTest(String name, double age, String country) {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys((int) age + "");
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();
    }
}
