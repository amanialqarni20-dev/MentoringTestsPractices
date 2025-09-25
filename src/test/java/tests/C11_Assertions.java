package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C11_Assertions {

    /*
    TestNG assertions are a crucial part of test automation, enabling you to verify that your tests are performing as expected and to identify any errors or discrepancies.
    They provide a mechanism for checking expected results against the actual results obtained during test execution.
     */

    @Test
    void hardAssertionTest() {
        /*
        Similar to JUnit Framework approach
        Test whether condition is true or false
        If condition fails, test is marked as failed
        No further assertions executed
        Provided by Assert class in TestNG
         */

        System.out.println("Assertion 1:");
        Assert.assertEquals(5, 5, "Did not match");
        System.out.println("Assertion 1 Passed!");

        System.out.println("Assertion 2:");
        Assert.assertTrue(1 < 5, "Did not match");
        System.out.println("Assertion 2 Passed!");

        System.out.println("Assertion 3:");
        String name = null;
        Assert.assertNull(name);
        System.out.println("Assertion 3 Passed!");
    }

    @Test
    void softAssertionTest() {

        /*
        Test multiple conditions
        Even if one or more assertions fail, continue execution
        Report all failures at the end
        Provided by SoftAssert class
        Not included by default - needs import
         */

        //1st Step: Create Soft Asser Object:
        SoftAssert softAssert = new SoftAssert();


        //2nd Step: Use softAssert method:
        System.out.println("Assertion 1:");
        softAssert.assertEquals(15, 5, "Did not match");

        System.out.println("Assertion 2:");
        softAssert.assertTrue(1 < 5, "Did not match");

        System.out.println("Assertion 3:");
        String name = null;
        softAssert.assertNotNull(name);

        //3rd Step: Use assertAll method:
        softAssert.assertAll();//If we have failure, execution will stop here
        System.out.println("----");
    }
}