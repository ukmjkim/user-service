package com.mjkim.project.userservice.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@ToString
public class UserServiceResponseDto {
    private Integer httpStatusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;
}
