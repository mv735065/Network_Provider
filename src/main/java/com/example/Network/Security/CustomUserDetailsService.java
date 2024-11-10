package com.example.Network.Security;

import com.example.Network.Services.AdminService;
import com.example.Network.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final JdbcTemplate jdbcTemplate;
    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(JdbcTemplate jdbcTemplate, UserService userService) {
        this.jdbcTemplate = jdbcTemplate;
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Query for admin directly, bypassing AdminService
        UserDetails admin = jdbcTemplate.queryForObject(
                "SELECT * FROM admins WHERE username = ?",
                new Object[]{username},
                (rs, rowNum) -> User.withUsername(rs.getString("username"))
                        .password(rs.getString("password"))
                        .roles("ADMIN")
                        .build()
        );

        if (admin != null) {
            return admin;
        }

        // If not an admin, try loading user details
        UserDetails user = userService.findUserByUsername(username);
        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
