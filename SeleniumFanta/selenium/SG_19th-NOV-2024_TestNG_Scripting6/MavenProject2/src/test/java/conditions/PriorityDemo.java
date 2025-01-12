package conditions;

import org.testng.annotations.Test;

public class PriorityDemo {
    @Test(priority = 3)
    public void testScript1(){
        System.out.println("test script testScript1()");
    }

    @Test(priority = 1)
    public void testScript2(){
        System.out.println("test script testScript2()");
    }

    @Test(priority = 2)
    public void testScript3(){
        System.out.println("test script testScript3()");
    }

    @Test
    public void testScript4(){
        System.out.println("test script testScript4()");
    }
}
