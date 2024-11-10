package com.example.Network.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdminDto {
    private  String username;
    private String password;
    private String email;
    private String role;
}
