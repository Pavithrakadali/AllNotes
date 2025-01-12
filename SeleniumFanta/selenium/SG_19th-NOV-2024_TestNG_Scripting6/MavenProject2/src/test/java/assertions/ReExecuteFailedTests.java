package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReExecuteFailedTests {
    @Test
    public void testScript1(){
        System.out.println("test script testScript1()");
        Assert.assertTrue(false);
    }

    @Test
    public void testScript2(){
        System.out.println("test script testScript2()");
    }

    @Test
    public void testScript3(){
        System.out.println("test script testScript3()");
        Assert.assertTrue(false);
    }

    @Test
    public void testScript4(){
        System.out.println("test script testScript4()");
    }
}
