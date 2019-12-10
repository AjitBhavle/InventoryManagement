package com.altimetrik.inventoryManagement.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.altimetrik.inventoryManagement.controllerInterface.BatteryApi;
import com.altimetrik.inventoryManagement.model.Battery;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@RestController
public class BatteryApiController implements BatteryApi {

    private static final Logger log = LoggerFactory.getLogger(BatteryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private HttpHeaders headers;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    public BatteryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        headers=new HttpHeaders();
        
    }

    public ResponseEntity<Battery> addbattery(@ApiParam(value = "battery object that needs to be added to the inventory system" ,required=true )  @Valid @RequestBody Battery body) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Battery> entity = new HttpEntity<Battery>(body,headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
            	return new ResponseEntity<Battery>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", Battery.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
			/*
			 * return new ResponseEntity<Battery>(restTemplate.exchange(
			 * "http://inventorymanagement.mocklab.io/battery", HttpMethod.POST, entity,
			 * Battery.class).getBody(), HttpStatus.CREATED);
			 */
        	try {
				return new ResponseEntity<Battery>(objectMapper.readValue("{  \"batteryChargeDate\" : \"batteryChargeDate\",  \"batteryId\" : 0,  \"batteryCost\" : 5,  \"batteryManfucturingDate\" : \"batteryManfucturingDate\",  \"batteryCurrentLocation\" : \"batteryCurrentLocation\",  \"vendorId\" : \"vendorId\",  \"batteryLastUpdateDate\" : \"batteryLastUpdateDate\",  \"batteryWeight\" : 1,  \"vehicleModelName\" : \"vehicleModelName\",  \"betteryModel\" : \"betteryModel\",  \"batteryExpirationDate\" : \"batteryExpirationDate\",  \"batteryTypeId\" : 6,  \"vehicleBrand\" : \"vehicleBrand\",  \"batteryCreateDate\" : \"batteryCreateDate\",  \"batteryStatus\" : \"charged\",  \"inventoryId\" : \"inventoryId\",  \"batteryCapacity\" : \"batteryCapacity\",  \"batteryBrand\" : \"batteryBrand\",  \"batteryLastChargeDate\" : \"batteryLastChargeDate\",  \"voltageOutput\" : \"voltageOutput\"}", Battery.class), HttpStatus.OK);
			} catch (JsonMappingException e) {
				log.error("JsonMapping Exception", e);
				return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (JsonProcessingException e) {
				log.error("Json Parsing Exception", e);
				return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
        }

        return new ResponseEntity<Battery>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Battery> deletebattery(@ApiParam(value = "") @Valid @RequestParam(value = "batteryId", required = false) String batteryId) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Battery>(objectMapper.readValue(restTemplate.exchange(
                        "http://inventorymanagement.mocklab.io/battery?batteryId="+batteryId, HttpMethod.DELETE, entity, String.class).getBody(), Battery.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
        	try {
				return new ResponseEntity<Battery>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", Battery.class), HttpStatus.OK);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
        }

        return new ResponseEntity<Battery>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Battery> getBattery(@ApiParam(value = "") @Valid @RequestParam(value = "batteryId", required = false) String batteryId,@RequestHeader("Content-Type") String contentType) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Battery>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", Battery.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
        	try {
				/*
				 * return new
				 * ResponseEntity<Battery>(objectMapper.readValue(restTemplate.exchange(
				 * "http://inventorymanagement.mocklab.io/battery?batteryId="+batteryId,
				 * HttpMethod.GET, entity, String.class).getBody(), Battery.class),
				 * HttpStatus.NOT_IMPLEMENTED);
				 */
        		return new ResponseEntity<Battery>(objectMapper.readValue("{  \"batteryChargeDate\" : \"batteryChargeDate\",  \"batteryId\" : 0,  \"batteryCost\" : 5,  \"batteryManfucturingDate\" : \"batteryManfucturingDate\",  \"batteryCurrentLocation\" : \"batteryCurrentLocation\",  \"vendorId\" : \"vendorId\",  \"batteryLastUpdateDate\" : \"batteryLastUpdateDate\",  \"batteryWeight\" : 1,  \"vehicleModelName\" : \"vehicleModelName\",  \"betteryModel\" : \"betteryModel\",  \"batteryExpirationDate\" : \"batteryExpirationDate\",  \"batteryTypeId\" : 6,  \"vehicleBrand\" : \"vehicleBrand\",  \"batteryCreateDate\" : \"batteryCreateDate\",  \"batteryStatus\" : \"charged\",  \"inventoryId\" : \"inventoryId\",  \"batteryCapacity\" : \"batteryCapacity\",  \"batteryBrand\" : \"batteryBrand\",  \"batteryLastChargeDate\" : \"batteryLastChargeDate\",  \"voltageOutput\" : \"voltageOutput\"}", Battery.class), HttpStatus.OK);	
        	} catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Battery>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Battery> updatebattery(@ApiParam(value = "battery object that needs to be updated to the inventory system" ,required=true )  @Valid @RequestBody Battery body) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Battery> entity = new HttpEntity<Battery>(body,headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Battery>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", Battery.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
			/*
			 * return new ResponseEntity<Battery>(restTemplate.exchange(
			 * "http://inventorymanagement.mocklab.io/battery", HttpMethod.PUT, entity,
			 * Battery.class).getBody(), HttpStatus.CREATED);
			 */
        	try {
				return new ResponseEntity<Battery>(objectMapper.readValue("{  \"batteryChargeDate\" : \"batteryChargeDate\",  \"batteryId\" : 0,  \"batteryCost\" : 5,  \"batteryManfucturingDate\" : \"batteryManfucturingDate\",  \"batteryCurrentLocation\" : \"batteryCurrentLocation\",  \"vendorId\" : \"vendorId\",  \"batteryLastUpdateDate\" : \"batteryLastUpdateDate\",  \"batteryWeight\" : 1,  \"vehicleModelName\" : \"vehicleModelName\",  \"betteryModel\" : \"betteryModel\",  \"batteryExpirationDate\" : \"batteryExpirationDate\",  \"batteryTypeId\" : 6,  \"vehicleBrand\" : \"vehicleBrand\",  \"batteryCreateDate\" : \"batteryCreateDate\",  \"batteryStatus\" : \"charged\",  \"inventoryId\" : \"inventoryId\",  \"batteryCapacity\" : \"batteryCapacity\",  \"batteryBrand\" : \"batteryBrand\",  \"batteryLastChargeDate\" : \"batteryLastChargeDate\",  \"voltageOutput\" : \"voltageOutput\"}", Battery.class), HttpStatus.OK);
			} catch (JsonProcessingException e) {
				log.error("update battery details exception", e);
				return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
        }

        return new ResponseEntity<Battery>(HttpStatus.NOT_IMPLEMENTED);
    }

}
