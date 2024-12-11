package com.example.schoolmanagement.Api;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);}

}
