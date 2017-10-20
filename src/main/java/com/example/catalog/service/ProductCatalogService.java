package com.example.catalog.service;

import com.example.catalog.entity.ProductCatalog;
import com.example.catalog.entity.ProductCatalog;
import com.example.catalog.repository.ProductCatalogRepository;
import com.example.catalog.repository.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/catalog")
public class ProductCatalogService {
	
	private Logger logger = LoggerFactory.getLogger(ProductCatalogService.class);

    @Autowired 
    private ProductCatalogRepository catalogRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public  String add(@RequestBody Map<String,String> map) {
    	logger.debug("Entered add() >>"+map);    	
        ProductCatalog pcl = new ProductCatalog();
        pcl.setProductName(map.get("productName"));
        pcl.setUsoc(map.get("usoc"));
        pcl.setRegionCode(map.get("regionCode"));
        pcl.setStateCode(map.get("stateCode"));        
        pcl.setAvailable(map.get("available"));
        catalogRepository.save(pcl);
        logger.info("New Product added");
        logger.debug("Exited add() >>"+map);
        return "Created"+ pcl.getId();
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public  List<ProductCatalog> getAllProducts() {
    	  logger.debug("Entered getAllProducts >>");
          return (List)catalogRepository.findAll();
    }
}