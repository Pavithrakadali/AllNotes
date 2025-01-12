package conditions;

import org.testng.annotations.Test;

public class ExceptionTesting {

    @Test(expectedExceptions = ArithmeticException.class)
    public void division(){
        int res = 10/0;
        System.out.println("Division: " + res);
    }
}
