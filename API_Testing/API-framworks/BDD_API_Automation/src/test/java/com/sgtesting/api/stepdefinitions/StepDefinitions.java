package com.sgtesting.api.stepdefinitions;

import java.io.File;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitions {
	public static RequestSpecification httpRequest=null;
	public static File obj=null;
	public static Response response=null;
	public static String employee_id=null;
	/**
	 * I provide baseURL for Create Employee
	 */
	@Given("^I provide baseURL for Create Employee$")
	public void I_provide_baseURL_for_Create_Employee()
	{
		try
		{
			RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees";
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * I provide baseURL for Create Employee
	 */
	@Given("^I provide baseURL (.*) for Create Employee$")
	public void I_provide_URL_for_Create_Employee(String url)
	{
		try
		{
			RestAssured.baseURI=url;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * I create Request Specification object
	 */
	@And("^I create Request Specification object$")
	public void I_create_Request_Specification_object()
	{
		try
		{
			httpRequest=RestAssured.given();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide request body for the Create Employee EndPoint
	 */
	@And("^I provide request body for the Create Employee EndPoint$")
	public void I_provide_request_body_for_the_Create_Employee_EndPoint()
	{
		try
		{
			String filePath=".\\datafiles\\createemployee.json";
			obj=new File(filePath);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide Header and Body for the Request
	 */
	@And("^I provide Header and Body for the Request$")
	public void I_provide_Header_and_Body_for_the_Request()
	{
		try
		{
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(obj);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I execute the POST Method
	 */
	@When("^I execute the POST Method$")
	public void I_execute_the_POST_Method()
	{
		try
		{
			response=httpRequest.post();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I print the Response object
	 */
	@Then("^I print the Response object$")
	public void I_print_the_Response_object()
	{
		try
		{
			String content=response.prettyPrint();
			System.out.println(content);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get the 201 status code
	 */
	@And("^I get the 201 status code$")
	public void I_get_the_201_status_code()
	{
		try
		{
			int statusCode=response.getStatusCode();
			Assert.assertEquals(201, statusCode);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I validate Response object
	 */
	@And("^I validate Response object$")
	public void I_validate_Response_object()
	{
		try
		{
			JsonPath jpath=response.jsonPath();
			employee_id=jpath.getString("id");
			System.out.println("Employee Id :"+employee_id);
			String firstname=jpath.getString("employeeFirstName");
			Assert.assertEquals("Demo", firstname);
			String job=jpath.getString("jobName");
			Assert.assertEquals("Sales VP", job);
			String email=jpath.getString("emailId");
			Assert.assertEquals("demo@gss.com", email);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide baseURL for display Employee
	 */
	@Given("^I provide baseURL for display Employee$")
	public void I_provide_baseURL_for_display_Employee()
	{
		try
		{
			RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees/"+employee_id;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide baseURL for display Employee
	 */
	@Given("^I provide baseURL (.*) for display Employee$")
	public void I_provide_URL_for_display_Employee(String url)
	{
		try
		{
			RestAssured.baseURI=url+"/"+employee_id;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * I provide Header for the Request
	 */
	@And("^I provide Header for the Request$")
	public void I_provide_Header_for_the_Request()
	{
		try
		{
			httpRequest.header("Content-Type", "application/json");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I execute the GET Method
	 */
	@When("^I execute the GET Method$")
	public void I_execute_the_GET_Method()
	{
		try
		{
			response=httpRequest.get();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get the 200 status code
	 */
	@And("^I get the 200 status code$")
	public void I_get_the_200_status_code()
	{
		try
		{
			int statusCode=response.getStatusCode();
			Assert.assertEquals(200, statusCode);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I validate Response object of GET API
	 */
	@And("^I validate Response object of GET API$")
	public void I_validate_Response_object_of_GET_API()
	{
		try
		{
			JsonPath jpath=response.jsonPath();
			employee_id=jpath.getString("id");
			System.out.println("Employee Id :"+employee_id);
			String firstname=jpath.getString("employeeFirstName");
			Assert.assertEquals("Demo", firstname);
			String job=jpath.getString("jobName");
			Assert.assertEquals("Sales VP", job);
			String email=jpath.getString("emailId");
			Assert.assertEquals("demo@gss.com", email);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide baseURL for delete Employee
	 */
	@Given("^I provide baseURL for delete Employee$")
	public void I_provide_baseURL_for_delete_Employee()
	{
		try
		{
			RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees/"+employee_id;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide baseURL for delete Employee
	 */
	@Given("^I provide baseURL (.*) for delete Employee$")
	public void I_provide_URL_for_delete_Employee(String url)
	{
		try
		{
			RestAssured.baseURI=url+"/"+employee_id;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * I execute the DELETE Method
	 */
	@When("^I execute the DELETE Method$")
	public void I_execute_the_DELETE_Method()
	{
		try
		{
			response=httpRequest.delete();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I validate Response object of DELETE API
	 */
	@And("^I validate Response object of DELETE API$")
	public void I_validate_Response_object_of_DELETE_API()
	{
		try
		{
			String content=response.asString();
			Assert.assertTrue(content.contains(employee_id+" has deleted"));
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I load all environment variables
	 */
	@Given("^I load all environment variables$")
	public void I_load_all_environment_variables()
	{
		try
		{
			System.out.println("I load all environment variables !!!!!");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I setup the Database connection
	 */
	@And("^I setup the Database connection$")
	public void I_setup_the_Database_connection()
	{
		try
		{
			System.out.println("I setup the Database connection !!!!!");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
