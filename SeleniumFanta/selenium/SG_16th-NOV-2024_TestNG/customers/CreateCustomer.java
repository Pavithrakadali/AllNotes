package customers;

import org.testng.annotations.*;

public class CreateCustomer {
    @Test
    public void createCustomer(){
        System.out.println("Customer Created Successful");
    }

    @Test
    public void modifyCustomer(){
        System.out.println("Customer Modified Successful");
    }

    @Test
    public void deleteCustomer(){
        System.out.println("Customer Deleted Successful");
    }

    @BeforeSuite
    public void Customer_beforeSuite(){
        System.out.println("Customer's @BeforeSuite example");
    }

    @AfterSuite
    public void Customer_afterSuite(){
        System.out.println("Customer's @AfterSuite example");
    }

    @BeforeTest
    public void Customer_beforeTest(){
        System.out.println("Customer's @BeforeTest example");
    }

    @AfterTest
    public void Customer_afterTest(){
        System.out.println("Customer's @AfterTest example");
    }

    @BeforeClass
    public void Customer_beforeClass(){
        System.out.println("Customer's @BeforeClass example");
    }

    @AfterClass
    public void Customer_afterClass(){
        System.out.println("Customer's @AfterClass example");
    }

    @BeforeMethod
    public void Customer_beforeMethod(){
        System.out.println("Customer's @BeforeMethod example");
    }

    @AfterMethod
    public void Customer_afterMethod(){
        System.out.println("Customer's @AfterMethod example");
    }
}
