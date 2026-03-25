package com.epw.academy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateCourseRequest {
    
    @NotBlank(message = "Name is required")
    @Size(max = 30, message = "Tittle must be <= 30 chars")
    private String name;

    @Size(max = 2000, message = "Description must be <= 2000 chars")
    private String description;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
