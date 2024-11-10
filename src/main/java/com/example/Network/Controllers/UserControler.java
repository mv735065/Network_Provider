package com.example.Network.Controllers;

import com.example.Network.RequestDtos.UserDto;
import com.example.Network.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserControler {

    @Autowired
    private UserService userService;

    // Home Page
    @GetMapping("/")
    public String redirectToIndex() {
        return "index";  // Renders index.html from src/main/resources/templates
    }



    // Common Login Page for both admin and user

    // Admin home page

    // User home page
    @Secured({"ROLE_USER"})
    @GetMapping("/user_home")
    public String userHome() {
        return "user_home";  // Serve the user_home.html template
    }




    @GetMapping("/user/login")
    public String userLogin(){
        return "login";
    }




    // Endpoint to add a new user, no login required
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/";  // Redirect to home page after adding user
    }
}
