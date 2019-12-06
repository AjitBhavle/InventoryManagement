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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.altimetrik.inventoryManagement.controllerInterface.InventoryApi;
import com.altimetrik.inventoryManagement.model.Inventory;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
@RestController
public class InventoryApiController implements InventoryApi {

    private static final Logger log = LoggerFactory.getLogger(InventoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private HttpHeaders headers;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    public InventoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        headers=new HttpHeaders();
    }

    public ResponseEntity<Inventory> updateInventory(@ApiParam(value = "inventory object that needs to be updated to the inventory system" ,required=true )  @Valid @RequestBody Inventory body) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Inventory> entity = new HttpEntity<Inventory>(body,headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Inventory>(objectMapper.readValue("<inventory>  <inventoryId>123</inventoryId>  <batteryId>aeiou</batteryId>  <batteryModel>aeiou</batteryModel>  <transactionByUser>aeiou</transactionByUser>  <transactionByVendor>aeiou</transactionByVendor>  <transactionDate>aeiou</transactionDate>  <transactionRequestId>aeiou</transactionRequestId>  <inventoryStatus>aeiou</inventoryStatus></inventory>", Inventory.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Inventory>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
				/*
				 * return new
				 * ResponseEntity<Inventory>(objectMapper.readValue(restTemplate.exchange(
				 * "http://inventorymanagement.mocklab.io/inventory", HttpMethod.PUT, entity,
				 * String.class).getBody(), Inventory.class), HttpStatus.NOT_IMPLEMENTED);
				 */ 
            	return new ResponseEntity<Inventory>(objectMapper.readValue("{  \"transactionByUser\" : \"transactionByUser\",  \"batteryId\" : \"batteryId\",  \"transactionRequestId\" : \"transactionRequestId\",  \"batteryModel\" : \"batteryModel\",  \"transactionByVendor\" : \"transactionByVendor\",  \"inventoryStatus\" : \"locked\",  \"inventoryId\" : 0,  \"transactionDate\" : \"transactionDate\"}", Inventory.class), HttpStatus.OK);	
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Inventory>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Inventory>(HttpStatus.NOT_IMPLEMENTED);
    }

}
