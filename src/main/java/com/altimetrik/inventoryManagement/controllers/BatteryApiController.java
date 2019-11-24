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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.altimetrik.inventoryManagement.controllerInterface.BatteryApi;
import com.altimetrik.inventoryManagement.model.Battery;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@RestController
public class BatteryApiController implements BatteryApi {

    private static final Logger log = LoggerFactory.getLogger(BatteryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private HttpHeaders headers=new HttpHeaders();
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    public BatteryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        
    }

    public ResponseEntity<Battery> addbattery(@ApiParam(value = "battery object that needs to be added to the inventory system" ,required=true )  @Valid @RequestBody Battery body) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Battery> entity = new HttpEntity<Battery>(body,headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
            	return new ResponseEntity<Battery>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", Battery.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Battery>(restTemplate.exchange(
			        "http://inventorymanagement.mocklab.io/battery", HttpMethod.POST, entity, Battery.class).getBody(), HttpStatus.CREATED);
        }

        return new ResponseEntity<Battery>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Battery> deletebattery(@ApiParam(value = "") @Valid @RequestParam(value = "batteryId", required = false) String batteryId) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Battery> entity = new HttpEntity<Battery>(headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Battery>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", Battery.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Battery>(restTemplate.exchange(
			        "http://inventorymanagement.mocklab.io/battery?batteryId="+batteryId, HttpMethod.DELETE, entity, Battery.class).getBody(), HttpStatus.OK);
        }

        return new ResponseEntity<Battery>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Battery> getBattery(@ApiParam(value = "") @Valid @RequestParam(value = "batteryId", required = false) String batteryId) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Battery> entity = new HttpEntity<Battery>(headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Battery>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", Battery.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Battery>(restTemplate.exchange(
			        "http://inventorymanagement.mocklab.io/battery?batteryId="+batteryId, HttpMethod.GET, entity, Battery.class).getBody(), HttpStatus.OK);
        }

        return new ResponseEntity<Battery>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Battery> updatebattery(@ApiParam(value = "battery object that needs to be updated to the inventory system" ,required=true )  @Valid @RequestBody Battery body) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Battery> entity = new HttpEntity<Battery>(body,headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Battery>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", Battery.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Battery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Battery>(restTemplate.exchange(
			        "http://inventorymanagement.mocklab.io/battery", HttpMethod.PUT, entity, Battery.class).getBody(), HttpStatus.CREATED);
        }

        return new ResponseEntity<Battery>(HttpStatus.NOT_IMPLEMENTED);
    }

}
