/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.altimetrik.inventoryManagement.controllerInterface;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.altimetrik.inventoryManagement.model.ItemInventoryDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@Api(value = "bulkSearch", description = "the bulkSearch API")
public interface BulkSearchApi {

    @ApiOperation(value = "get bulk or indivigual items details", nickname = "getItemDetails", notes = "this is to get indivigual or bulk items details", response = ItemInventoryDetails.class, responseContainer = "List", authorizations = {
        @Authorization(value = "inventoryManagement_auth", scopes = {
            @AuthorizationScope(scope = "write:inventorys", description = "modify inventorys in your account"),
            @AuthorizationScope(scope = "read:inventorys", description = "read your inventorys")
            })
    }, tags={ "bulk", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ItemInventoryDetails.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "inventory not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/bulkSearch",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<List<ItemInventoryDetails>> getItemDetails(@ApiParam(value = "get bulk item details"  )  @Valid @RequestBody List<ItemInventoryDetails> body);

}
