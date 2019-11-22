package com.altimetrik.inventoryManagement.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ItemInventoryDetails
 */
@Validated
public class ItemInventoryDetails {
	@JsonProperty("vendorId")
	private Integer vendorId = null;

	@JsonProperty("batteryId")
	private Integer batteryId = null;

	@JsonProperty("batteryPrice")
	private Integer batteryPrice = null;

	@JsonProperty("batteryModel")
	private String batteryModel = null;

	@JsonProperty("avaliableCount")
	private Integer avaliableCount = null;

	@JsonProperty("souldCount")
	private Integer souldCount = null;

	public ItemInventoryDetails vendorId(Integer vendorId) {
		this.vendorId = vendorId;
		return this;
	}

	/**
	 * vendor id
	 * 
	 * @return vendorId
	 **/
	@ApiModelProperty(value = "vendor id")

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public ItemInventoryDetails batteryId(Integer batteryId) {
		this.batteryId = batteryId;
		return this;
	}

	/**
	 * batteryId
	 * 
	 * @return batteryId
	 **/
	@ApiModelProperty(value = "batteryId")

	public Integer getBatteryId() {
		return batteryId;
	}

	public void setBatteryId(Integer batteryId) {
		this.batteryId = batteryId;
	}

	public ItemInventoryDetails batteryPrice(Integer batteryPrice) {
		this.batteryPrice = batteryPrice;
		return this;
	}

	/**
	 * battery model number
	 * 
	 * @return batteryModel
	 **/
	@ApiModelProperty(value = "battery Price")

	public Integer getBatteryPrice() {
		return batteryPrice;
	}

	public void setBatteryPrice(Integer batteryPrice) {
		this.batteryPrice = batteryPrice;
	}

	public ItemInventoryDetails batteryModel(String batteryModel) {
		this.batteryModel = batteryModel;
		return this;
	}

	/**
	 * battery model number
	 * 
	 * @return batteryModel
	 **/
	@ApiModelProperty(value = "battery model number")

	public String getBatteryModel() {
		return batteryModel;
	}

	public void setBatteryModel(String batteryModel) {
		this.batteryModel = batteryModel;
	}

	public ItemInventoryDetails avaliableCount(Integer avaliableCount) {
		this.avaliableCount = avaliableCount;
		return this;
	}

	/**
	 * avaliable battery count
	 * 
	 * @return avaliableCount
	 **/
	@ApiModelProperty(value = "avaliable battery count")

	public Integer getAvaliableCount() {
		return avaliableCount;
	}

	public void setAvaliableCount(Integer avaliableCount) {
		this.avaliableCount = avaliableCount;
	}

	public ItemInventoryDetails souldCount(Integer souldCount) {
		this.souldCount = souldCount;
		return this;
	}

	/**
	 * sould battery count
	 * 
	 * @return souldCount
	 **/
	@ApiModelProperty(value = "sould battery count")

	public Integer getSouldCount() {
		return souldCount;
	}

	public void setSouldCount(Integer souldCount) {
		this.souldCount = souldCount;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ItemInventoryDetails itemInventoryDetails = (ItemInventoryDetails) o;
		return Objects.equals(this.vendorId, itemInventoryDetails.vendorId)
				&& Objects.equals(this.batteryId, itemInventoryDetails.batteryId)
				&& Objects.equals(this.batteryModel, itemInventoryDetails.batteryModel)
				&& Objects.equals(this.avaliableCount, itemInventoryDetails.avaliableCount)
				&& Objects.equals(this.batteryPrice, itemInventoryDetails.batteryPrice)
				&& Objects.equals(this.souldCount, itemInventoryDetails.souldCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vendorId, batteryId, batteryModel, avaliableCount, souldCount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ItemInventoryDetails {\n");

		sb.append("    vendorId: ").append(toIndentedString(vendorId)).append("\n");
		sb.append("    batteryId: ").append(toIndentedString(batteryId)).append("\n");
		sb.append("    batteryPrice: ").append(toIndentedString(batteryPrice)).append("\n");
		sb.append("    batteryModel: ").append(toIndentedString(batteryModel)).append("\n");
		sb.append("    avaliableCount: ").append(toIndentedString(avaliableCount)).append("\n");
		sb.append("    souldCount: ").append(toIndentedString(souldCount)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
