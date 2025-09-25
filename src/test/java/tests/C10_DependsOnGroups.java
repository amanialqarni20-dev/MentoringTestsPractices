package tests;

import org.testng.annotations.Test;

public class C10_DependsOnGroups {

    @Test(groups = "1")
    void test01() {
        System.out.println("Test 01 - 1");
    }

    @Test(groups = "3")
    void test02() {
        System.out.println("Test 02 - 3");
    }

    @Test
    void test03() {
        System.out.println("Test 03");
    }

    @Test(groups = "2")
    void test04() {
        System.out.println("Test 04 - 2");
    }

    @Test(groups = "1")
    void test05() {
        System.out.println("Test 05 - 1");
    }

    @Test(groups = "3")
    void test06() {
        System.out.println("Test 06 - 3");
    }

    @Test(dependsOnGroups = "3")
    void dependsOnGroup3(){
        System.out.println("Depends On Group 3");
    }

    @Test(dependsOnGroups = "1")
    void dependsOnGroup1(){
        System.out.println("Depends On Group 1");
    }

}
