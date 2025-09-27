package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] getData02(){
        return new Object[][]{
                {"John Doe","23","Canada"},
                {"Mary Lee","34","US"},
                {"Tom Hanks","82","Australia"},
        };
    }

    @DataProvider
    public Object[][] getData03(){
        ExcelUtilities eu = new ExcelUtilities("testData/Users.xlsx","Employees");
        return eu.getExcelDataAsArray();
        };

}