package com.real_taxi.service.booking.mapper;

import com.real_taxi.service.booking.dto.userdto.UserRegisterRQ;
import com.real_taxi.service.booking.model.User;

public class UserMapper {
    public static User mapToUser(UserRegisterRQ userRegisterRQ) {

        return new User(
                userRegisterRQ.getName(),
                userRegisterRQ.getEmail(),
                userRegisterRQ.getPassword(),
                userRegisterRQ.getRole().toUpperCase()
        );

    }

    public static UserRegisterRQ mapToUserRegisterDTO(User user) {
        return new UserRegisterRQ(
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserRole()
        );
    }
}
