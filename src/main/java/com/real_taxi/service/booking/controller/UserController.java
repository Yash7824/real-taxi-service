package com.real_taxi.service.booking.controller;

import com.real_taxi.service.booking.dto.userdto.UserRS;
import com.real_taxi.service.booking.dto.userdto.UserRegisterRQ;
import com.real_taxi.service.booking.service.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRS> registerUser(@Valid @RequestBody UserRegisterRQ userRegisterRQ){
        var userRS = userService.saveUser(userRegisterRQ);
        if(userRS.getStatusCode() != 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userRS);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRS);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        var users = userService.GetAllUsers();
        if(users.getStatusCode() != 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(users);
        return ResponseEntity.ok(users);
    }
}
