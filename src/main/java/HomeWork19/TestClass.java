package HomeWork19;

public class TestClass {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite method");
    }

    @Test(priority = 2)
    public void testMethod1() {
        System.out.println("TestMethod1");
    }

    @Test(priority = 5)
    public void testMethod2() {
        System.out.println("TestMethod 2");
    }

    @Test(priority = 1)
    public void testMethod3() {
        System.out.println("TestMethod 3");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite method");
    }
}
