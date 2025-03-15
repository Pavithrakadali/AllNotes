package com.sgtesting.api.pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ScenarioCreateEmployee {

	public static String employee_id="";
	@Test(priority = 1)
	public void createEmployee()
	{
		try
		{
			System.out.println("This test has created the New Employee Record in the Database");
			RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees";
			RequestSpecification httpRequest=RestAssured.given();
			//create pojo object
			Employee obj=new Employee();
			obj.setEmployeeFirstName("Vinith");
			obj.setEmployeeLastName("Bhaskar");
			obj.setAge(25);
			obj.setAddress("1st Main, 1st Stage, Mangalore");
			obj.setCityName("Mangalore");
			obj.setContactNumber(7090123450L);
			obj.setDepartmentName("BANKING");
			obj.setEmailId("vinith@gss.com");
			obj.setJobName("Sales VP");
			obj.setSalary(17000);

			//by using mapper converting java object into json object
			ObjectMapper mapper=new ObjectMapper();

			String employeeJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println(employeeJson);

			//headers
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(employeeJson);
			//Response

			Response response=httpRequest.post();
			// print response
			String content=response.asPrettyString();
			System.out.println(content);
			// display employee id
			JsonPath jpath=response.jsonPath();
			employee_id=jpath.getString("id");
			System.out.println("Employee Id :"+employee_id);

		}catch(Exception e)
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
			httpRequest.header("Content-Type", "application/json");

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
