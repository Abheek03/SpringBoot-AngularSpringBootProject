package com.example.sample.project.requests;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchRequest {

    public String name;
    public String value;

    public PatchRequest(@NotBlank(message = "name cannot be blank")String name,String value){
        this.name =name;
        this.value = value;
    }
}
