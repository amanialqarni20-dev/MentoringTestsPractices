package tests;
import org.testng.annotations.*;

public class test01 {

    @BeforeSuite
    void beforeSuit(){
        System.out.println("Before Suite");
    }
@BeforeClass
void beforClass() {
    System.err.println("BeforClass");
}

@AfterSuite
    void afterSuit(){
        System.out.println("After Suite");
    }

    @AfterTest
    void afterTest() {
        System.out.println("After Test");
    }
    @BeforeTest
    void BeforTest() {
        System.err.println("BeforTest");
    }

    @Test
    void test01(){
        System.out.println("Test 01");
    }
    @Test
    void test02(){
        System.out.println("Test 02");
    }
    @Test
    void test03(){
        System.out.println("Test 03");
    }

    @Test
    void test04() {
        System.out.println("Test 05");

    }
        @Test
        void test05(){
            System.out.println("Test 05");
        }
        }

//حتى لو حطيت تست 5 اخر شي راح يسوي تست بالرقم الفابتك



