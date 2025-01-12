package conditions;

import org.testng.annotations.Test;

public class EnabledDemo {
    @Test(enabled = false)
    public void testScript1(){
        System.out.println("test script testScript1()");
    }

    @Test
    public void testScript2(){
        System.out.println("test script testScript2()");
    }

    @Test(enabled = false)
    public void testScript3(){
        System.out.println("test script testScript3()");
    }

    @Test
    public void testScript4(){
        System.out.println("test script testScript4()");
    }
}
