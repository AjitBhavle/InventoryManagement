package com.altimetrik.inventoryManagement.mainTestCases;

import java.util.Map;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import com.altimetrik.inventoryManagement.baseClass.BaseTest;
import com.altimetrik.inventoryManagement.pojo.EmployeePojo;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.response.ResponseBodyExtractionOptions;

public class CreateEmployee extends BaseTest {

	EmployeePojo CreateEmployeePojo=new EmployeePojo();
	int EmployeeId;
	
	
	
	@Test(priority=0)
	public void postEmployee() {

		CreateEmployeePojo.setEmployeeProp("name", "Sarthak");
		CreateEmployeePojo.setEmployeeProp("salary", "123");
		CreateEmployeePojo.setEmployeeProp("age", "23");
		EmployeeId = given().contentType("application/json")
				.body(CreateEmployeePojo)
				.when().post("/create")
				.then().extract().jsonPath().getInt("id");
		//assertThat().body("name", equalTo("Sarthak")).statusCode(200).extract().path("id");
		System.out.println("JSON response: "+EmployeeId);

	}
	@Test(priority=1)
	public void postEmployeeWithDupRecord() {

		given().contentType("application/json")
		.body(CreateEmployeePojo)
		.when().post("/create")
		.then().body(containsString("Duplicate entry 'Sarthak' for key 'employee_name_unique'")).statusCode(200);
	}
	@Test(priority=2)
	public void getEmployeeDetailsByValidId() {

		given().pathParameter("id", EmployeeId).contentType("application/json")
		.when().get("/employee/{id}")//get("http://inventorymanagement.mocklab.io/battery?batteryId=1")
		.then().extract().jsonPath().getString("employee_name").equals("Sarthak");

	}
	
	@Test(priority=3)
	public void DeleteEmployee() {

		given().pathParameter("id", EmployeeId)
		.when().delete("/delete/{id}").then().body(containsString("successfully! deleted Records"))
		.statusCode(200);
	}

}
