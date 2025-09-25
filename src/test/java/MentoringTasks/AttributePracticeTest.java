package MentoringTasks;

import org.testng.annotations.Test;

public class AttributePracticeTest {

    @Test(priority = 1, groups = {"smoke"})
    void test01() {
        System.out.println("Test 01 - smoke");
    }

    @Test(priority = 3, groups = {"regression"})
    void test02() {
        System.out.println("Test 02 - regression");
    }

    @Test(priority = 2, groups = {"api"})
    void test03() {
        System.out.println("Test 03 - api");
    }

    @Test(priority = 5, groups = {"smoke", "api"})
    void test04() {
        System.out.println("Test 04 - smoke, api");
    }

    @Test(priority = 4, groups = {"regression"})
    void test05() {
        System.out.println("Test 05 - regression");
    }

    @Test(enabled = false)
    void disabledTest() {
        System.out.println("Disabled test");
    }

    @Test(timeOut = 3000)
    void timeoutPass() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Timeout pass");
    }

    @Test(timeOut = 1000)
    void timeoutFail() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Timeout fail");
    }
}
