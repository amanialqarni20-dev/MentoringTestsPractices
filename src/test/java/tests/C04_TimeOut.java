package tests;

import org.testng.annotations.Test;

public class C04_TimeOut {
    /*
        Specifies a timeout value for the test (in milliseconds)
        If test takes more than specified timeout, the test is marked as failed
        Used to perform performance testing
        Ensures method returns within reasonable time
     */

    @Test(timeOut = 3000)
    void loginTest() throws InterruptedException {
        Thread.sleep(2900);
        System.out.println("Login Test");
    }

    @Test
    void test02() {
        System.out.println("Test 02");
    }

    @Test(timeOut = 200)//ThreadTimeoutException
    void test03() throws InterruptedException {
        Thread.sleep(200);
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