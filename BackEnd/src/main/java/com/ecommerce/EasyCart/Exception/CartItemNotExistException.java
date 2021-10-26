/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Exception;

/**
 *
 * @author anjana
 */
public class CartItemNotExistException extends IllegalArgumentException {
    
    public CartItemNotExistException(String msg) {
        super(msg);
    }
}
