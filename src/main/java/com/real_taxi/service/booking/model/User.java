package com.real_taxi.service.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name="user_name")
    private String userName;

    @Column(unique = true, name="user_email")
    private String userEmail;

    @Column(name="user_password")
    private String userPassword;

    @Column(name="wallet_balance")
    private Double walletBalance = 0.0;

    @Column(name="user_role")
    private String userRole;

    @Column(name="created_on")
    private Date createdOn = new Date();

    public User(String name, String email, String password, String role){
        this.userName = name;
        this.userEmail = email;
        this.userPassword = password;
        this.userRole = role;
    }
}

