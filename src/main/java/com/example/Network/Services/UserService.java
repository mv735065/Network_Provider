package com.example.Network.Services;

import com.example.Network.Repository.UserRepository;
import com.example.Network.RequestDtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
@Lazy
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDetails findUserByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?",
                new Object[]{username}, (rs, rowNum) ->
                        User.withUsername(rs.getString("username"))
                                .password(rs.getString("password"))
                                .roles("USER")
                                .build()
        );
    }

    public String addUser(UserDto userDto) {
        int result = userRepository.saveUser(userDto);
        if (result == 1) {
            return userDto.getRole()+" added successfully!";
        } else {
            return "Failed to add "+userDto.getRole();
        }
    }



//    public User getUser(int id) {
//        return userRepository.getUserById(id);
//    }

    // Additional business logic as needed
}
