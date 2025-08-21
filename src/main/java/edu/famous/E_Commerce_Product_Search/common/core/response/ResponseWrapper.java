package edu.famous.E_Commerce_Product_Search.common.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {
    private LocalDateTime timeStamp;
    private int code;
    private String message;
    private T data;

    public ResponseWrapper(int code, String message, T data) {
        this.timeStamp = LocalDateTime.now();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseWrapper<T> success(T data) {
        return new ResponseWrapper<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseWrapper<T> error(ResponseCode responseCode) {
        return new ResponseWrapper<>(responseCode.getCode(), responseCode.getMessage(), null);
    }

    public static <T> ResponseWrapper<T> error(ResponseCode responseCode, String customMessage) {
        return new ResponseWrapper<>(responseCode.getCode(), customMessage, null);
    }

    public static <T> ResponseWrapper<T> of(ResponseCode responseCode, T data) {
        return new ResponseWrapper<>(responseCode.getCode(), responseCode.getMessage(), data);
    }
}
