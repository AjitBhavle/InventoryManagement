package com.altimetrik.inventoryManagement.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

import com.altimetrik.inventoryManagement.controllerInterface.BulkSearchApi;
import com.altimetrik.inventoryManagement.model.ItemInventoryDetails;
import com.altimetrik.inventoryManagement.model.Path;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@RestController
public class BulkSearchApiController implements BulkSearchApi {

    private static final Logger log = LoggerFactory.getLogger(BulkSearchApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private HttpHeaders headers;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    public BulkSearchApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        headers=new HttpHeaders();
    }

    public ResponseEntity<List<ItemInventoryDetails>> getItemDetails(@ApiParam(value = "get bulk item details"  )  @Valid @RequestBody List<ItemInventoryDetails> body) {
        String accept = request.getHeader("Accept");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<ItemInventoryDetails>> entity = new HttpEntity<List<ItemInventoryDetails>>(body,headers);
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<List<ItemInventoryDetails>>(objectMapper.readValue("<itemInventoryDetails>  <vendorId>123</vendorId>  <batteryId>123</batteryId>  <batteryModel>aeiou</batteryModel>  <avaliableCount>123</avaliableCount>  <souldCount>123</souldCount></itemInventoryDetails>", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<List<ItemInventoryDetails>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ItemInventoryDetails>>(objectMapper.readValue(restTemplate.exchange(
                        "http://inventorymanagement.mocklab.io/bulkSearch", HttpMethod.POST, entity, String.class).getBody(), List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ItemInventoryDetails>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ItemInventoryDetails>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
