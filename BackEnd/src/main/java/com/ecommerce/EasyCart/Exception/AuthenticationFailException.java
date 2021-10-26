/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Exception;


public class AuthenticationFailException extends IllegalArgumentException{
    public AuthenticationFailException(String msg) {
        super(msg);
    }
}
