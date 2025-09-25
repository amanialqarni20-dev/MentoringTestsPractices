package tests;

import org.testng.annotations.Test;

public class C06_Description {

    /*
    A single string attached to @Test annotation
    Describes information about the test
    Appears in test reports
     */

    @Test(description = "This test is the test 01!")
    void test01() {
        System.out.println("Test 01");
    }

    @Test(description = "You can add more attributes side by side:", priority = 1, timeOut = 2000, enabled = true)
    void test02() {
        System.out.println("Test 02");
    }

    @Test
    void test03() {
        System.out.println("Test 03");
    }

    @Test
    void test04() {
        System.out.println("Test 04");
    }

    @Test
    void test05() {
        System.out.println("Test 05");
    }

}