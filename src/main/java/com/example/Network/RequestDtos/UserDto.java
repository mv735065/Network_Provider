package com.example.Network.RequestDtos;

import com.example.Network.Enums.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private  String username;
    private String password;
    private String email;
    private String role;
}
