package com.sgtesting.api.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ReadRecordsFromDatabaseDemo {

	public static void main(String[] args) {
		readRecords();
		insertRecords();
	}
	
	private static void readRecords()
	{
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			System.out.println("The Connection has established successfully!!!!");
			Statement stmt=conn.createStatement();

			String query="select * from system.dept";
			ResultSet rs=stmt.executeQuery(query);
			ResultSetMetaData rsmeta = rs.getMetaData();
			String col1=rsmeta.getColumnName(1);
			String col2=rsmeta.getColumnName(2);
			String col3=rsmeta.getColumnName(3);

			System.out.printf("%-12s",col1);
			System.out.printf("%-12s",col2);
			System.out.printf("%-12s",col3);

			System.out.printf("\n");
			while(rs.next())	
			{
				String deptno=rs.getString("DEPTNO");
				String deptname=rs.getString("DNAME");
				String place=rs.getString("LOC");
				System.out.printf("%-12s",deptno);
				System.out.printf("%-12s",deptname);
				System.out.printf("%-12s",place);
				System.out.printf("\n");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private static void insertRecords()
	{
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			System.out.println("The Connection has established successfully!!!!");
			Statement stmt=conn.createStatement();
			String query="insert into dept values(56,'HEALTH','BANGALORE')";
			int v1=stmt.executeUpdate(query);
			if(v1!=0)
			{
				System.out.println("The Record has inserted successsfully");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
