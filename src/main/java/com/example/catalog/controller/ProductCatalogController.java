package com.example.catalog.controller;

import com.example.catalog.entity.ProductCatalog;
import com.example.catalog.entity.ProductCatalog;
import com.example.catalog.repository.ProductCatalogRepository;
import com.example.catalog.repository.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Map;



@Api(
value = "ProductCatalog", 
produces = "application/json")
@RestController
@RequestMapping("/catalog")
public class ProductCatalogController{
	
	private Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);

    @Autowired 
    private ProductCatalogRepository catalogRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "add product to catalog", notes = "Adds products to catalog")
    @ApiResponses(value=
            {@ApiResponse(code = 400,message = "Fields are with validation errors"),
            @ApiResponse(code = 500, message = "Error occurred while processing request")}
            )
    public  ResponseEntity addProduct(@ApiParam(value = "Product added to catalog") 
    @RequestBody ProductCatalog product) {
    		logger.debug("Entered add() >>"+product);    	
        catalogRepository.save(product);
        logger.info("Product added to catalog : id :"+product.getId());
        logger.debug("Exited add() >>"+product);
        return new ResponseEntity(product.toString(), HttpStatus.CREATED); 
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "list products in catalog", notes = "lists  all product in the catalog with state, regoin code and availablity status")
    public  List<ProductCatalog> getAllProducts() {
    	  logger.debug("Entered getAllProducts >>");
          return (List)catalogRepository.findAll();
    }
}