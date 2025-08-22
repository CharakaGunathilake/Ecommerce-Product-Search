package edu.famous.E_Commerce_Product_Search.product_service.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private Timestamp timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
