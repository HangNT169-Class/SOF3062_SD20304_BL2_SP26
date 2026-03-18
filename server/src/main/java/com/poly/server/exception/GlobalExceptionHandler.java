package com.poly.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // custom cac loai loi o day => hien thi ra message than thien vs nguoi dung
    // Loi 1 => @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerValidateErrors(MethodArgumentNotValidException e) {
        // custom loai loi hien thi @Valid cho than thien vs nguoi dung
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(s -> errorMap.put(s.getField(), s.getDefaultMessage()));
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    // Loi 2: 400 nhung do minh tu tao(APIException)
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handlerApiException(ApiException e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "FAIL");
        errorMap.put("code", e.getCode());
        errorMap.put("message", e.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    // Loi 3: 500 cac loi con lai
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerAll(Exception e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "FAIL");
        errorMap.put("code", "Lỗi logic");
        errorMap.put("message", e.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
