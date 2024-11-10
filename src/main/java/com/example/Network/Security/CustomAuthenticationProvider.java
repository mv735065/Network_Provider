package com.example.Network.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }
}
