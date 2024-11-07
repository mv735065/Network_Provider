package com.example.Network.Entities;


//import jakarta.persistence.*;
import com.example.Network.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private Integer userId;
    private  String username;
    private String password;
    private String email;
    private String role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    private String mobileNumber;
//    private Integer boxId;
//    private String email;
//    private String area;
//    @Enumerated(value = EnumType.STRING)
//    private Package packageDetails;
//
//    @ManyToOne
//    @JoinColumn
//    private Admin admin;

}
