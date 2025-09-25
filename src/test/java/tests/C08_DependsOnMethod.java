package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C08_DependsOnMethod {
    /*
    Used when second test method depends on the first test method
    If the first test method fails, the dependent method will not run
    A parameter can pass one method or multiple methods
    Creates a test execution chain
     */

    @Test(priority = 1, dependsOnMethods = "test03")
    void test01() {
        System.out.println("Test 01");
    }

    @Test(priority = 2)
    void test02() {
        System.out.println("Test 02");
    }

    @Test(priority = 3)
    void test03() {
        System.out.println("Test 03");
    }

    @Test(priority = 4, dependsOnMethods = {"test05", "test06"})
    void test04() {
        System.out.println("Test 04");
    }

    @Test(priority = 5)
    void test05() {
        System.out.println("Test 05");
        Assert.fail();
    }

    @Test(priority = 6)
    void test06() {
        System.out.println("Test 06");
    }


}