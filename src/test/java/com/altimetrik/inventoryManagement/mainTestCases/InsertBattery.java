package com.altimetrik.inventoryManagement.mainTestCases;

import java.util.Map;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.altimetrik.inventoryManagement.baseClass.BaseTest;
import com.altimetrik.inventoryManagement.pojo.InsertBatteryPojo;

public class InsertBattery extends BaseTest {

	@Test
	public void postInsertBattery() {
		
		InsertBatteryPojo InsertBatteryPojo=new InsertBatteryPojo();
		
		InsertBatteryPojo.setInserBatteryJSON("batteryId", 0);
		InsertBatteryPojo.setInserBatteryJSON("inventoryId", "");
		InsertBatteryPojo.setInserBatteryJSON("batteryTypeId", 1);
		InsertBatteryPojo.setInserBatteryJSON("betteryModel", "amaron");
		InsertBatteryPojo.setInserBatteryJSON("batteryWeight", 10);
		InsertBatteryPojo.setInserBatteryJSON("batteryManfucturingDate", "2016-08-01");
		InsertBatteryPojo.setInserBatteryJSON("batteryExpirationDate", "2020-08-01");
		InsertBatteryPojo.setInserBatteryJSON("batteryCreateDate", "2016-08-01");
		InsertBatteryPojo.setInserBatteryJSON("batteryLastUpdateDate", "2019-08-01");
		InsertBatteryPojo.setInserBatteryJSON("batteryLastChargeDate", "2019-08-01");
		InsertBatteryPojo.setInserBatteryJSON("batteryChargeDate", "2019-11-01");
		InsertBatteryPojo.setInserBatteryJSON("batteryCurrentLocation", "PUNE");
		InsertBatteryPojo.setInserBatteryJSON("batteryStatus", "charged");
		InsertBatteryPojo.setInserBatteryJSON("vendorId", "12321");
		InsertBatteryPojo.setInserBatteryJSON("vehicleBrand", "I10");
		InsertBatteryPojo.setInserBatteryJSON("batteryCapacity", "12");
		InsertBatteryPojo.setInserBatteryJSON("batteryBrand", "amaron");
		InsertBatteryPojo.setInserBatteryJSON("voltageOutput", "12");
		InsertBatteryPojo.setInserBatteryJSON("vehicleModelName", "12");
		InsertBatteryPojo.setInserBatteryJSON("batteryCost", 10);

		given().accept("json").contentType("application/json")
		.body(InsertBatteryPojo)
		.when().post("/battery")
		.then().body("betteryModel", equalTo("amaron")).statusCode(200);
	}
	
}
