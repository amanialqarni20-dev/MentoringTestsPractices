package tests;

import org.testng.annotations.Test;

public class C02_Priority {
    /*
        Helps to prioritize test annotations execution order
        Default priority starts with 0
        Tests are executed in ascending order (0, 1, 2, 3...)
        If test annotation doesn't have priority attribute, priority is considered zero
        TestNG executes @Test annotations in alphabetical order by default
     */

    @Test(priority = 3)
    void test01(){
        System.out.println("Test 01");
    }

    @Test(priority = 1)
    void test02(){
        System.out.println("Test 02");
    }

    @Test(priority = 2)
    void test03(){
        System.out.println("Test 03");
    }

    @Test(priority = -1)
    void test04(){
        System.out.println("Test 04");
    }

    @Test(priority = 4)
    void test05(){
        System.out.println("Test 05");
    }

    @Test
    void setUp(){
        System.out.println("SetUp Method");
    }

    /*
    Order:
    Test 04
    SetUp Method
    Test 02
    Test 03
    Test 01
    Test 05
     */

}