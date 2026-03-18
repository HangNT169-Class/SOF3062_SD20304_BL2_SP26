package com.poly.server.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException{

    private String code; // ma loi tu dinh nghia
    // VD: C01 => Truong ID khong duoc de trong

    public ApiException(String message, String code) {
        super(message);
        this.code = code;
    }

}
