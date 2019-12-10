
package com.altimetrik.inventoryManagement.controllerInterface;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.altimetrik.inventoryManagement.model.Battery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@Api(value = "battery", description = "the battery API")
@RequestMapping("/inventoryManagement")
public interface BatteryApi {

    @ApiOperation(value = "Add new battery", nickname = "addbattery", notes = "this is to add new battery to the system", response = Battery.class, authorizations = {
        @Authorization(value = "inventoryManagement_auth", scopes = {
            @AuthorizationScope(scope = "write:inventorys", description = "modify inventorys in your account"),
            @AuthorizationScope(scope = "read:inventorys", description = "read your inventorys")
            })
    }, tags={ "battery", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Battery.class),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/battery",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Battery> addbattery(@ApiParam(value = "battery object that needs to be added to the inventory system" ,required=true )  @Valid @RequestBody Battery body);


    @ApiOperation(value = "Delete an existing battery", nickname = "deletebattery", notes = "this is to delete battery in the system", response = Battery.class, authorizations = {
        @Authorization(value = "inventoryManagement_auth", scopes = {
            @AuthorizationScope(scope = "write:inventorys", description = "modify inventorys in your account"),
            @AuthorizationScope(scope = "read:inventorys", description = "read your inventorys")
            })
    }, tags={ "battery", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Battery.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "battery not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/battery",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.DELETE)
    ResponseEntity<Battery> deletebattery(@ApiParam(value = "") @Valid @RequestParam(value = "batteryId", required = false) String batteryId);


    @ApiOperation(value = "get battery details", nickname = "getBattery", notes = "this is to get the battery details", response = Battery.class, authorizations = {
        @Authorization(value = "inventoryManagement_auth", scopes = {
            @AuthorizationScope(scope = "write:inventorys", description = "modify inventorys in your account"),
            @AuthorizationScope(scope = "read:inventorys", description = "read your inventorys")
            })
    }, tags={ "battery", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Battery.class),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/battery",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<Battery> getBattery(@ApiParam(value = "") @Valid @RequestParam(value = "batteryId", required = false) String batteryId,@RequestHeader("Content-Type") String contentType);


    @ApiOperation(value = "Update an existing battery", nickname = "updatebattery", notes = "this is to update battery in the system", response = Battery.class, authorizations = {
        @Authorization(value = "inventoryManagement_auth", scopes = {
            @AuthorizationScope(scope = "write:inventorys", description = "modify inventorys in your account"),
            @AuthorizationScope(scope = "read:inventorys", description = "read your inventorys")
            })
    }, tags={ "battery", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Battery.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "battery not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/battery",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Battery> updatebattery(@ApiParam(value = "battery object that needs to be updated to the inventory system" ,required=true )  @Valid @RequestBody Battery body);

}
