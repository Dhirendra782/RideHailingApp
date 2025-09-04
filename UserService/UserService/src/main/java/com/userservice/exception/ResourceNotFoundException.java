package com.userservice.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String feildName;
    private String felidValue;


    public ResourceNotFoundException(String resourceName, String feildName, String felidValue) {
        super(String.format("%s not found with %s : %s",resourceName,feildName,felidValue));
        this.resourceName = resourceName;
        this.feildName = feildName;
        this.felidValue = felidValue;
    }


}
