package com.example.Network.Controllers;

import com.example.Network.RequestDtos.AdminDto;
import com.example.Network.RequestDtos.UserDto;
import com.example.Network.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin_home")
    public String adminHome() {
        return "admin_home";  // Serve the admin_home.html template
    }

    @GetMapping("/admin/login")
    public String adminLogin(){
        return "login";
    }


    @PostMapping("/addAdmin")
    public String addUser(@RequestBody AdminDto adminDto) {
        adminService.addAdmin(adminDto);
        return "redirect:/admin_home";  // Redirect to home page after adding user
    }


}
