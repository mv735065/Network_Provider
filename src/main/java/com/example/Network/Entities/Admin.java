package com.example.Network.Entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private Integer adminId;
    private  String adminName;
    private String password;
    private String email;
    private String role;
}
