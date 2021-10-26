package com.ecommerce.EasyCart.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.ecommerce.EasyCart.Security.AccessTokenUserDetails;
import com.ecommerce.EasyCart.Security.Util.InvalidTokenException;
import com.ecommerce.EasyCart.Security.Util.TokenExpiredException;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator.Status;

public class AccessTokenUserDetailsService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    public static final String PURPOSE_ACCESS_TOKEN = "ACCESS_TOKEN";

    @Autowired
    private TokenGenerator tokenGenerator;

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        if (!PURPOSE_ACCESS_TOKEN.equals(token.getCredentials())) {
            throw new UsernameNotFoundException("Invalid credentials");
        }

        final Status status;
        try {
            status = tokenGenerator.verify(PURPOSE_ACCESS_TOKEN, token.getPrincipal().toString());
        } catch (InvalidTokenException e) {
            throw new UsernameNotFoundException("Invalid access token", e);
        } catch (TokenExpiredException e) {
            throw new UsernameNotFoundException("Access token expired", e);
        }

        return new AccessTokenUserDetails(Integer.parseInt(status.data));
    }
}
