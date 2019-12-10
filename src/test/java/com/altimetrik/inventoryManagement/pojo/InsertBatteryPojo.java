
package com.altimetrik.inventoryManagement.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"batteryId",
	"inventoryId",
	"batteryTypeId",
	"betteryModel",
	"batteryWeight",
	"batteryManfucturingDate",
	"batteryExpirationDate",
	"batteryCreateDate",
	"batteryLastUpdateDate",
	"batteryLastChargeDate",
	"batteryChargeDate",
	"batteryCurrentLocation",
	"batteryStatus",
	"vendorId",
	"vehicleBrand",
	"batteryCapacity",
	"batteryBrand",
	"voltageOutput",
	"vehicleModelName",
	"batteryCost"
})
public class InsertBatteryPojo {

	@JsonProperty("batteryId")
	private Integer batteryId;
	@JsonProperty("inventoryId")
	private String inventoryId;
	@JsonProperty("batteryTypeId")
	private Integer batteryTypeId;
	@JsonProperty("betteryModel")
	private String betteryModel;
	@JsonProperty("batteryWeight")
	private Integer batteryWeight;
	@JsonProperty("batteryManfucturingDate")
	private String batteryManfucturingDate;
	@JsonProperty("batteryExpirationDate")
	private String batteryExpirationDate;
	@JsonProperty("batteryCreateDate")
	private String batteryCreateDate;
	@JsonProperty("batteryLastUpdateDate")
	private String batteryLastUpdateDate;
	@JsonProperty("batteryLastChargeDate")
	private String batteryLastChargeDate;
	@JsonProperty("batteryChargeDate")
	private String batteryChargeDate;
	@JsonProperty("batteryCurrentLocation")
	private String batteryCurrentLocation;
	@JsonProperty("batteryStatus")
	private String batteryStatus;
	@JsonProperty("vendorId")
	private String vendorId;
	@JsonProperty("vehicleBrand")
	private String vehicleBrand;
	@JsonProperty("batteryCapacity")
	private String batteryCapacity;
	@JsonProperty("batteryBrand")
	private String batteryBrand;
	@JsonProperty("voltageOutput")
	private String voltageOutput;
	@JsonProperty("vehicleModelName")
	private String vehicleModelName;
	@JsonProperty("batteryCost")
	private Integer batteryCost;
	@JsonIgnore
	private Map<String, Object> inserBatteryJSON = new HashMap<String, Object>();

	@JsonProperty("batteryId")
	public Integer getBatteryId() {
		return batteryId;
	}

	@JsonProperty("batteryId")
	public void setBatteryId(Integer batteryId) {
		this.batteryId = batteryId;
	}

	@JsonProperty("inventoryId")
	public String getInventoryId() {
		return inventoryId;
	}

	@JsonProperty("inventoryId")
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	@JsonProperty("batteryTypeId")
	public Integer getBatteryTypeId() {
		return batteryTypeId;
	}

	@JsonProperty("batteryTypeId")
	public void setBatteryTypeId(Integer batteryTypeId) {
		this.batteryTypeId = batteryTypeId;
	}

	@JsonProperty("betteryModel")
	public String getBetteryModel() {
		return betteryModel;
	}

	@JsonProperty("betteryModel")
	public void setBetteryModel(String betteryModel) {
		this.betteryModel = betteryModel;
	}

	@JsonProperty("batteryWeight")
	public Integer getBatteryWeight() {
		return batteryWeight;
	}

	@JsonProperty("batteryWeight")
	public void setBatteryWeight(Integer batteryWeight) {
		this.batteryWeight = batteryWeight;
	}

	@JsonProperty("batteryManfucturingDate")
	public String getBatteryManfucturingDate() {
		return batteryManfucturingDate;
	}

	@JsonProperty("batteryManfucturingDate")
	public void setBatteryManfucturingDate(String batteryManfucturingDate) {
		this.batteryManfucturingDate = batteryManfucturingDate;
	}

	@JsonProperty("batteryExpirationDate")
	public String getBatteryExpirationDate() {
		return batteryExpirationDate;
	}

	@JsonProperty("batteryExpirationDate")
	public void setBatteryExpirationDate(String batteryExpirationDate) {
		this.batteryExpirationDate = batteryExpirationDate;
	}

	@JsonProperty("batteryCreateDate")
	public String getBatteryCreateDate() {
		return batteryCreateDate;
	}

	@JsonProperty("batteryCreateDate")
	public void setBatteryCreateDate(String batteryCreateDate) {
		this.batteryCreateDate = batteryCreateDate;
	}

	@JsonProperty("batteryLastUpdateDate")
	public String getBatteryLastUpdateDate() {
		return batteryLastUpdateDate;
	}

	@JsonProperty("batteryLastUpdateDate")
	public void setBatteryLastUpdateDate(String batteryLastUpdateDate) {
		this.batteryLastUpdateDate = batteryLastUpdateDate;
	}

	@JsonProperty("batteryLastChargeDate")
	public String getBatteryLastChargeDate() {
		return batteryLastChargeDate;
	}

	@JsonProperty("batteryLastChargeDate")
	public void setBatteryLastChargeDate(String batteryLastChargeDate) {
		this.batteryLastChargeDate = batteryLastChargeDate;
	}

	@JsonProperty("batteryChargeDate")
	public String getBatteryChargeDate() {
		return batteryChargeDate;
	}

	@JsonProperty("batteryChargeDate")
	public void setBatteryChargeDate(String batteryChargeDate) {
		this.batteryChargeDate = batteryChargeDate;
	}

	@JsonProperty("batteryCurrentLocation")
	public String getBatteryCurrentLocation() {
		return batteryCurrentLocation;
	}

	@JsonProperty("batteryCurrentLocation")
	public void setBatteryCurrentLocation(String batteryCurrentLocation) {
		this.batteryCurrentLocation = batteryCurrentLocation;
	}

	@JsonProperty("batteryStatus")
	public String getBatteryStatus() {
		return batteryStatus;
	}

	@JsonProperty("batteryStatus")
	public void setBatteryStatus(String batteryStatus) {
		this.batteryStatus = batteryStatus;
	}

	@JsonProperty("vendorId")
	public String getVendorId() {
		return vendorId;
	}

	@JsonProperty("vendorId")
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	@JsonProperty("vehicleBrand")
	public String getVehicleBrand() {
		return vehicleBrand;
	}

	@JsonProperty("vehicleBrand")
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	@JsonProperty("batteryCapacity")
	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	@JsonProperty("batteryCapacity")
	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	@JsonProperty("batteryBrand")
	public String getBatteryBrand() {
		return batteryBrand;
	}

	@JsonProperty("batteryBrand")
	public void setBatteryBrand(String batteryBrand) {
		this.batteryBrand = batteryBrand;
	}

	@JsonProperty("voltageOutput")
	public String getVoltageOutput() {
		return voltageOutput;
	}

	@JsonProperty("voltageOutput")
	public void setVoltageOutput(String voltageOutput) {
		this.voltageOutput = voltageOutput;
	}

	@JsonProperty("vehicleModelName")
	public String getVehicleModelName() {
		return vehicleModelName;
	}

	@JsonProperty("vehicleModelName")
	public void setVehicleModelName(String vehicleModelName) {
		this.vehicleModelName = vehicleModelName;
	}

	@JsonProperty("batteryCost")
	public Integer getBatteryCost() {
		return batteryCost;
	}

	@JsonProperty("batteryCost")
	public void setBatteryCost(Integer batteryCost) {
		this.batteryCost = batteryCost;
	}

	@JsonAnyGetter
	public Map<String, Object> getInserBatteryJSON() {
		return this.inserBatteryJSON;
	}

	@JsonAnySetter
	public void setInserBatteryJSON(String name, Object value) {
		this.inserBatteryJSON.put(name, value);
	}

}