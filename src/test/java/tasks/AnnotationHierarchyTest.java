package tasks;
/*
        AnnotationHierarchyTest
        Task 1: Basic TestNG Setup and Annotations
        Objective: Create a TestNG class demonstrating annotation hierarchy
        Requirements:
        Create a TestNG class called
        Implement all TestNG annotations (@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod,
        @Test, @AfterMethod, @AfterClass, @AfterTest, @AfterSuite)
        Add print statements in each method to observe execution order
        Create 2 test methods
        Run the test and analyze console output
     */
import org.testng.annotations.*;

public class AnnotationHierarchyTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
    }

    @Test
    public void testOne() {
        System.out.println("Test ONE");
    }

    @Test
    public void testTwo() {
        System.out.println("Test TWO");
    }
}
