package com.ecommerce.EasyCart.Security.Util;

public class TokenExpiredException extends IllegalArgumentException {

    public TokenExpiredException(String s) {
        super(s);
    }

    public TokenExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
