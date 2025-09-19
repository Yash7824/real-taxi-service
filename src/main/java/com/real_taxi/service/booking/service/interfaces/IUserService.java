package com.real_taxi.service.booking.service.interfaces;

import com.real_taxi.service.booking.dto.userdto.UserDisplayRS;
import com.real_taxi.service.booking.dto.userdto.UserListRS;
import com.real_taxi.service.booking.dto.userdto.UserRS;
import com.real_taxi.service.booking.dto.userdto.UserRegisterRQ;

public interface IUserService {
    UserRS saveUser(UserRegisterRQ userRegisterRQ);
    UserListRS GetAllUsers();
    UserDisplayRS GetUserByEmail(String email);
    UserDisplayRS GetUserById(Long id);
    UserRS UpdateUser(UserRegisterRQ userRegisterRQ);
    UserRS DeleteUser(String email);
}
