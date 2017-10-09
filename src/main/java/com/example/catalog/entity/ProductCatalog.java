package com.example.catalog.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
public class ProductCatalog implements Serializable {


    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUsoc() {
        return usoc;
    }

    public void setUsoc(String usoc) {
        this.usoc = usoc;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    @Size(min=5, max=100)
    private String productName;


    @Size(min=5, max=10)
    private String usoc;


    private String regionCode;


    @Size(min=2)
    private String stateCode;


    private boolean isAvailable = false;


    public ProductCatalog(){

    }

    public ProductCatalog(String ProductName, String usoc,
                          String regionCode, String stateCode, boolean isAvailable){
        this.productName=productName;
        this.usoc=usoc;
        this.regionCode=regionCode;
        this.stateCode=stateCode;
        this.isAvailable=isAvailable;

    }

    public String toString(){

        if (isAvailable)
        return productName +" available in  region"+ regionCode+ "of the state "+stateCode +"(usoc :"+usoc+")";
        else
            return productName +"  not available in  region"+ regionCode+ "of the state "+stateCode +"(usoc :"+usoc+")";
    }


}






