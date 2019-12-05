package com.altimetrik.inventoryManagement.mainTestCases;

import java.util.HashMap;
import java.util.Map;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.altimetrik.inventoryManagement.pojo.InsertBatteryPojo;

public class InsertBattery extends InsertBatteryPojo {

	@Test
	public void aCarGoesIntoTheGarage() {
		

		String test="";
		given().accept("json").contentType("application/json")
		.body(test)
		.when().post("/garage/slots").then()
		.statusCode(200);
	}
	
}
