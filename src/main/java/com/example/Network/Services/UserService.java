package com.example.Network.Services;

import com.example.Network.Entities.User;
import com.example.Network.Repository.UserRepository;
import com.example.Network.RequestDtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
