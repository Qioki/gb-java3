package Task_1;


public class TestClass1 {

    
    @BeforeSuite
    public void beforeMethod(){
        System.out.println("beforeMethod"); 
    }

    @Test(priotity = 1)
    public void testMethod1(){
        System.out.println("testmethod1");
    }
    @Test(priotity = 9)
    public void testMethod2(){
        System.out.println("testmethod2");
    }
    @Test(priotity = 6)
    public void testMethod3(){
        System.out.println("testmethod3");
    }
    @Test
    public void testMethod4(){
        System.out.println("testmethod4");
    }
    @Test(priotity = 5)
    public void testMethod5(){
        System.out.println("testmethod5");
    }

    @AfterSuite
    public void afterMethod(){
        System.out.println("afterMethod");
    }
}