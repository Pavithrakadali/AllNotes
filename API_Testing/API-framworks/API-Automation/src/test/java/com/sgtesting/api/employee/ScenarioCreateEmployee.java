package com.sgtesting.api.employee;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ScenarioCreateEmployee {
	public static String employee_id=null;
	@Test(priority = 1)
	public void createEmployeeTest()
	{
		try
		{
			System.out.println("This test has created the New Employee Record in the Database");
			RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees";
			RequestSpecification httpRequest=RestAssured.given();
			
			// Request body
			String path=".//datafiles//createemployee.json";
			File file=new File(path);
			//headers
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(file);
			//Response
			
			Response response=httpRequest.post();
			// print response
			String content=response.asPrettyString();
			System.out.println(content);
			// display employee id
			JsonPath jpath=response.jsonPath();
			employee_id=jpath.getString("id");
			System.out.println("Employee Id :"+employee_id);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void displayEmployeeTest()
	{
		try
		{
			System.out.println("This test has displayed the Newly created Employee Record from the Database");
			RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees/"+employee_id;
			RequestSpecification httpRequest=RestAssured.given();
			
			//headers

			//Response
			
			Response response=httpRequest.get();
			// print response
			String content=response.asPrettyString();
			System.out.println(content);
			// display employee id
			JsonPath jpath=response.jsonPath();
			employee_id=jpath.getString("id");
			System.out.println("Employee Id :"+employee_id);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void deleteEmployeeTest()
	{
		try
		{
			System.out.println("This test has deleted the Newly created Employee Record from the Database");
			RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees/"+employee_id;
			RequestSpecification httpRequest=RestAssured.given();
			
			//headers
			httpRequest.header("Content-Type", "application/json");

			//Response
			
			Response response=httpRequest.delete();
			// print response
			String content=response.asPrettyString();
			System.out.println(content);
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
