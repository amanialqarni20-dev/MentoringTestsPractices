package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class C07_Groups {
    /*
    Groups different test cases of same functionality
    Enables selective test execution
    Covered later in XML files
     */

    @Test(groups = "A")
    void test01() {
        System.out.println("Test 01 - A");
    }

    @Test(groups = "C")
    void test02() {
        System.out.println("Test 02 - C");
    }

    @Test
    void test03() {
        System.out.println("Test 03");
    }

    @Test(groups = "B")
    void test04() {
        System.out.println("Test 04 - B");
    }

    @Test(groups = "A")
    void test05() {
        System.out.println("Test 05 - A");
    }

    @Test(groups = "B")
    void test06() {
        System.out.println("Test 06 - B");
    }

    @Test(groups = "C")
    void test07() {
        System.out.println("Test 07 - C");
    }

    @BeforeGroups(groups = "B")
    void beforeGroupsTest() {
        System.out.println("@BeforeGroups");
    }

    @AfterGroups(groups = "B")
    void afterGroupsTest() {
        System.out.println("@AfterGroups");
    }

    @BeforeGroups(groups = "C")
    void beforeGroupsCTest() {
        System.out.println("@BeforeGroups C");
    }

    @AfterGroups(groups = "C")
    void afterGroupsTCest() {
        System.out.println("@AfterGroups C");
    }


}