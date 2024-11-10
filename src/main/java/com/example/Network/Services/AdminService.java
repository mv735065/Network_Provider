package com.example.Network.Services;

import com.example.Network.Repository.AdminRepository;
import com.example.Network.RequestDtos.AdminDto;
import com.example.Network.RequestDtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Lazy
@Service
public class AdminService {
@Autowired
    AdminRepository adminRepository;


@Autowired
private JdbcTemplate jdbcTemplate;

    public UserDetails findAdminByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT * FROM admins WHERE username = ?",
                new Object[]{username}, (rs, rowNum) ->
                        User.withUsername(rs.getString("username"))
                                .password(rs.getString("password"))
                                .roles("ADMIN")
                                .build()
        );
    }

    public String  addAdmin(AdminDto adminDto) {
        int result = adminRepository.saveAdmin(adminDto);
        if (result == 1) {
            return adminDto.getRole()+" added successfully!";
        } else {
            return "Failed to add "+adminDto.getRole();
        }

    }





}
