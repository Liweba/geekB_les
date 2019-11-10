public class TestClass {
    @BeforeSuite
    public void init() throws Exception{
        System.out.println("init");
    }

    @Test(priority = 6)
    public void test1() throws Exception{
        System.out.println("test1");
    }

    @Test(priority = 1)
    public void test2() throws Exception {
        System.out.println("test2");
    }

    @Test(priority = 7)
    public void test3() throws Exception{
        System.out.println("test3");
    }
    @Test
    public void test4() throws Exception {
        System.out.println("test4");
    }

    @AfterSuite
    public void stop() throws Exception{
        System.out.println("stop");
    }

}
