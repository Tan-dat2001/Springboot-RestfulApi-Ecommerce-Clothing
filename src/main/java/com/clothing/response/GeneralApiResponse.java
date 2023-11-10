package com.clothing.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralApiResponse<T>{

    private String statusCode;
    private HttpStatus status;
    private T data;

}
