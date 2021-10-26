package com.ecommerce.EasyCart.Security.Util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ecommerce.EasyCart.Security.AccessTokenUserDetails;

public final class SecurityUtil {

    private SecurityUtil() {
    }

    public static Integer getCurrentCustomerId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }

        Object principal = auth.getPrincipal();
        if (!(principal instanceof AccessTokenUserDetails)) {
            return null;
        }

        return ((AccessTokenUserDetails) principal).userId;
    }
    
}
