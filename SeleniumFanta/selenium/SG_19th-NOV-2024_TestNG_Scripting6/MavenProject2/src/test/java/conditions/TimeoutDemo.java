package conditions;

import org.testng.annotations.Test;

public class TimeoutDemo {
    @Test(timeOut = 4000)
    public void createUser(){
        try{
            Thread.sleep(5000);
            System.out.println("Create user is successful");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
