package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.util.DataBaseConnector;

import java.util.ArrayList;
import java.util.List;

public class SeleniumDataBaseTest {


	//Test to verify Employee ID '1' has employee name 'Jack'

	//	@Test
	//	public void test() {
	//		String sqlQuery = "select EmpName from employee WHERE EmpId="+1+"";
	//		System.out.println(sqlQuery);
	//	}
	@Test(priority = 1)
	public void testVerifySpecificRecord() {
		String sqlQuery = "select EmpName from employee WHERE EmpId="+1+"";
		String expectedEmpName = "Jack";
		//Getting employee name by Id
		String actualEmpNameById = DataBaseConnector.executeSQLQuery("QA", sqlQuery);
		System.out.println("Employee name retrieved from database :" + actualEmpNameById);
		Assert.assertEquals(expectedEmpName, actualEmpNameById);
	}

	//Test to verify Employee table has a record with employee name 'Jack'
	@Test(priority = 2)
	public void testVerifyListOfRecords() {
		boolean flag = false;
		List<String> listOfDBValues = new ArrayList<String>();
		String expEmployeeName = "Jack";
		String sqlQuery = "select EmpName from employee";
		//Getting list of employee names from employee table
		listOfDBValues = DataBaseConnector.executeSQLQuery_List("QA", sqlQuery);
		for (String strName : listOfDBValues) {
			if (strName.equalsIgnoreCase(expEmployeeName)) {
				flag = true;
				break;
			}
		}
		System.out.println("Verifying");
		Assert.assertTrue(flag, "Retrieved values are not matching with Expected values");
		System.out.println("Verified");
	}

}
