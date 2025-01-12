package conditions;

import org.testng.annotations.Test;

public class InvocationCountDemo {
    @Test(invocationCount = 5)
    public void createUser(){
        System.out.println("User created successful");
    }
}
