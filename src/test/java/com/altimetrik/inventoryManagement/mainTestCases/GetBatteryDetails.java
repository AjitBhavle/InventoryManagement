package com.altimetrik.inventoryManagement.mainTestCases;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.altimetrik.inventoryManagement.baseClass.BaseTest;

public class GetBatteryDetails extends BaseTest {

	@Test()
	public void getBatteryDetailsByValidId() {

		given().accept("json").contentType("application/json")
		.when().get("/battery")//get("http://inventorymanagement.mocklab.io/battery?batteryId=1")
		.then().assertThat().body("betteryModel", equalTo("betteryModel")).statusCode(200);

	}
	@Test()
	public void getBatteryDetailsByInvalidId() {

		given().accept("json").contentType("application/json")
		.when().get("/battery?batteryId=2")//get("http://inventorymanagement.mocklab.io/battery?batteryId=1")
		.then().assertThat().statusCode(404);
		
	}
	@Test()
	public void getBatteryDetailsBySpecialChar() {

		given().accept("json").contentType("application/json")
		.when().get("/battery?batteryId=$#")//get("http://inventorymanagement.mocklab.io/battery?batteryId=1")
		.then().assertThat().statusCode(404);

	}
	/*@Test
	public void verifyTopLevelURL() {
		given().when().get("/garage").then()
		.body("5", equalTo(5));
		.body("name", equalTo("Ajit"));
		.body("name",equals("Acme garage"))
		.body("info.slots",equalsTo(150))
		.body("info.status",equals("open"))
		.statusCode(200);
	}*/

}
