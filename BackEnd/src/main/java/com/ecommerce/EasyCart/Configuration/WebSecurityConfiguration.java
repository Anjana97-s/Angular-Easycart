package com.ecommerce.EasyCart.Configuration;

import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;

import com.ecommerce.EasyCart.Security.AccessTokenProcessingFilter;
import com.ecommerce.EasyCart.Security.AccessTokenUserDetailsService;
import com.ecommerce.EasyCart.Security.Config.SecurityConfig;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public WebSecurityConfiguration() {
        super(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                
                .cors().and().csrf().disable()
                .requestMatcher(new NegatedRequestMatcher(new AntPathRequestMatcher("/error")))
                .addFilter(accessTokenProcessingFilter())
                .authenticationProvider(preAuthenticatedAuthenticationProvider())
                .exceptionHandling().and()
                .headers().and()
                .sessionManagement().sessionCreationPolicy(STATELESS).and()
                .securityContext().and()
                .anonymous().and()
                .authorizeRequests()
                
                .antMatchers(OPTIONS, "/**").anonymous()
                .antMatchers(POST, "/customer").anonymous()
                .antMatchers(POST, "/admin").anonymous()
                .antMatchers(OPTIONS, "/admin").anonymous()
                .antMatchers(OPTIONS, "/admin_login").anonymous()

                .antMatchers(POST, "/admin_login").anonymous()
                .antMatchers(OPTIONS, "/seller_login").anonymous()
                .antMatchers(POST, "/seller").anonymous()
                .antMatchers(OPTIONS, "/seller").anonymous()
                .antMatchers(POST, "/seller_login").anonymous()

                .antMatchers(POST, "/cust_login").anonymous()
                .antMatchers(PUT, "/customer").anonymous()
                .anyRequest().authenticated();
    }

    @Bean
    protected AccessTokenUserDetailsService accessTokenUserDetailsService() {
        return new AccessTokenUserDetailsService();
    }

    @Bean
    protected PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
        PreAuthenticatedAuthenticationProvider authProvider = new PreAuthenticatedAuthenticationProvider();
        authProvider.setPreAuthenticatedUserDetailsService(accessTokenUserDetailsService());
        return authProvider;
    }

    @Bean
    protected AccessTokenProcessingFilter accessTokenProcessingFilter() throws Exception {
        AccessTokenProcessingFilter filter = new AccessTokenProcessingFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @ConfigurationProperties("app.security")
    public SecurityConfig securityConfig() {
        return new SecurityConfig();
    }

    @Bean
    @ConfigurationProperties("app.security.configuration")
    public TokenGenerator tokenGenerator(SecurityConfig securityConfig) {
        return new TokenGenerator(securityConfig.getTokenGeneratorPassword(), securityConfig.getTokenGeneratorSalt());
    }
}
