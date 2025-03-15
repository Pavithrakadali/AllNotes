package com.sgtesting.api.pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UsersPojo {
	
	@Test(priority = 1)
	public void generateJsonObject1()
	{
		try
		{
			Users obj=new Users("santosh","welcome1");
			
			ObjectMapper mapper=new ObjectMapper();
			
			String userJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println(userJson);
			System.out.println("++++++++++++++++++++++++++++++++");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void generateJsonObject2()
	{
		try
		{
			Users obj=new Users();
			obj.setUsername("Vinith");
			obj.setPassword("Welcome12345");
			
			ObjectMapper mapper=new ObjectMapper();
			
			String userJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println(userJson);
			System.out.println("++++++++++++++++++++++++++++++++");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void generateJsonObject3()
	{
		try
		{
			Users obj[]= {
					new Users("Santosh","Welcome1"),
					new Users("Vinith","Welcome2"),
					new Users("DemoUser1","Welcome3")
			};
			
			
			ObjectMapper mapper=new ObjectMapper();
			
			String userJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println(userJson);
			System.out.println("++++++++++++++++++++++++++++++++");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
