package conditions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTesting {
    @Test
    public void login(){
        System.out.println("Login to application was successful");
        Assert.assertTrue(false);
    }


    @Test(dependsOnMethods = "login")
    public void orderPlacement(){
        System.out.println("The order placed successful");
    }
}
