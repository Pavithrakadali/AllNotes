package users;

import org.testng.annotations.*;

public class CreateUser {
    @Test
    public void createUser(){
        System.out.println("User Created Successful");
    }

    @Test
    public void modifyUser(){
        System.out.println("User Modified Successful");
    }

    @Test
    public void deleteUser(){
        System.out.println("User Deleted Successful");
    }

    @BeforeSuite
    public void user_beforeSuite(){
        System.out.println("User's @BeforeSuite example");
    }

    @AfterSuite
    public void user_afterSuite(){
        System.out.println("User's @AfterSuite example");
    }

    @BeforeTest
    public void user_beforeTest(){
        System.out.println("User's @BeforeTest example");
    }

    @AfterTest
    public void user_afterTest(){
        System.out.println("User's @AfterTest example");
    }


    @BeforeClass
    public void user_beforeClass(){
        System.out.println("User's @BeforeClass example");
    }

    @AfterClass
    public void user_afterClass(){
        System.out.println("User's @AfterClass example");
    }

    @BeforeMethod
    public void user_beforeMethod(){
        System.out.println("User's @BeforeMethod example");
    }

    @AfterMethod
    public void user_afterMethod(){
        System.out.println("User's @AfterMethod example");
    }
}
