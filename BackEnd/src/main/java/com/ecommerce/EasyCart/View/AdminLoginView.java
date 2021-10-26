/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.View;
import java.util.Date;

import com.ecommerce.EasyCart.Entity.Admin;
import com.ecommerce.EasyCart.Json.Json;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator.Token;
import com.ecommerce.EasyCart.View.AdminLoginView.TokenView;

/**
 *
 * @author anjana
 */
public class AdminLoginView extends AdminView {
    
    public static class TokenView {

        private final String value;
        @Json.DateTimeFormat
        private final Date expiry;

        public TokenView(Token token) {
            this.value = token.value;
            this.expiry = new Date(token.expiry);
        }

        public TokenView(String value, long expiry) {
            this.value = value;
            this.expiry = new Date(expiry);
        }

        public String getValue() {
            return value;
        }

        public Date getExpiry() {
            return expiry;
        }
    }

    private final TokenView accessToken;
    private final TokenView refreshToken;

    public AdminLoginView(Admin admin, Token accessToken, Token refreshToken) {
        super(admin);
        this.accessToken = new TokenView(accessToken);
        this.refreshToken = new TokenView(refreshToken);
    }

    public AdminLoginView(Admin admin, TokenView accessToken, TokenView refreshToken) {
        super(admin);
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public TokenView getAccessToken() {
        return accessToken;
    }

    public TokenView getRefreshToken() {
        return refreshToken;
    }

}
