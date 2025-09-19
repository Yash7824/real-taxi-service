package com.real_taxi.service.booking.service;

import com.real_taxi.service.booking.dto.userdto.UserDisplayRS;
import com.real_taxi.service.booking.dto.userdto.UserListRS;
import com.real_taxi.service.booking.dto.userdto.UserRS;
import com.real_taxi.service.booking.dto.userdto.UserRegisterRQ;
import com.real_taxi.service.booking.enums.Role;
import com.real_taxi.service.booking.mapper.UserMapper;
import com.real_taxi.service.booking.model.User;
import com.real_taxi.service.booking.repository.UserRepository;
import com.real_taxi.service.booking.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserRS saveUser(UserRegisterRQ userRegisterRQ) {
        var userRS = new UserRS("Success", 0, "User registered successfully");
        try{
            if(userRepository.existsByUserEmail(userRegisterRQ.getEmail())){
                userRS.setStatus("Failed");
                userRS.setStatusCode(1);
                userRS.setStatusMessage("Email already exists");
                return userRS;
            }

            if (!Role.isValid(userRegisterRQ.getRole().toUpperCase())) {
                userRS.setStatus("Failed");
                userRS.setStatusCode(1);
                userRS.setStatusMessage(String.format("Invalid role provided:  %s", userRegisterRQ.getRole()));
                return userRS;
            }

            User user = UserMapper.mapToUser(userRegisterRQ);
            user.setWalletBalance(100.0);
            userRepository.save(user);

        }catch(Exception ex){
            userRS.setStatus("Failed");
            userRS.setStatusCode(2);
            userRS.setStatusMessage("Exception Occurred: " + ex.getMessage());
        }
        return userRS;
    }

    @Override
    public UserListRS GetAllUsers() {
        var userListRS = new UserListRS();
        try{
            var usersListMaps = userRepository.getAllUsers();
            if(usersListMaps.isEmpty()){
                userListRS.setStatus("Failed");
                userListRS.setStatusCode(1);
                userListRS.setStatusMessage("No users found");
                return userListRS;
            }

            List<User> users = new ArrayList<>();
            for(Map<String, Object> userMap: usersListMaps){
                User user = new User();
                user.setUserId((Long) userMap.get("user_id"));
                user.setUserName((String) userMap.get("user_name"));
                user.setUserEmail((String) userMap.get("user_email"));
                user.setUserPassword((String) userMap.get("user_password"));
                user.setUserRole((String) userMap.get("user_role"));
                user.setCreatedOn((Date) userMap.get("created_on"));
                user.setWalletBalance((Double) userMap.get("wallet_balance"));
                users.add(user);
            }

            userListRS.setStatus("Success");
            userListRS.setStatusCode(0);
            userListRS.setStatusMessage("Users fetched successfully");
            userListRS.setUsers(users);

        } catch (Exception ex) {
            userListRS.setStatus("Failed");
            userListRS.setStatusCode(2);
            userListRS.setStatusMessage("Exception occurred: " + ex.getMessage());
        }
        return userListRS;
    }

    @Override
    public UserDisplayRS GetUserByEmail(String email) {
        var userDisplayRS = new UserDisplayRS();
        try{
            var userMap = userRepository.getUserByEmail(email);

            if(userMap.isEmpty()){
                userDisplayRS.setStatus("Failed");
                userDisplayRS.setStatusCode(1);
                userDisplayRS.setStatusMessage("No user found with the provided email");
                return userDisplayRS;
            }

            var user = new User(
                    (Long) userMap.get("user_id"),
                    (String) userMap.get("user_name"),
                    (String) userMap.get("user_email"),
                    (String) userMap.get("user_password"),
                    (Double) userMap.get("wallet_balance"),
                    (String) userMap.get("user_role"),
                    (Date) userMap.get("created_on")
            );

            userDisplayRS.setStatus("Success");
            userDisplayRS.setStatusCode(0);
            userDisplayRS.setStatusMessage("User Found");
            userDisplayRS.setUser(user);

        }catch (Exception ex) {
            userDisplayRS.setStatus("Failed");
            userDisplayRS.setStatusCode(2);
            userDisplayRS.setStatusMessage("Exception occurred: " + ex.getMessage());
        }
        return userDisplayRS;
    }

    @Override
    public UserDisplayRS GetUserById(Long id) {
        var userDisplayRS = new UserDisplayRS();
        try{
            var userMap = userRepository.getUserById(id);

            if(userMap.isEmpty()){
                userDisplayRS.setStatus("Failed");
                userDisplayRS.setStatusCode(1);
                userDisplayRS.setStatusMessage("No user found with the provided id");
                return userDisplayRS;
            }

            var user = new User(
                    (Long) userMap.get("user_id"),
                    (String) userMap.get("user_name"),
                    (String) userMap.get("user_email"),
                    (String) userMap.get("user_password"),
                    (Double) userMap.get("wallet_balance"),
                    (String) userMap.get("user_role"),
                    (Date) userMap.get("created_on")
            );

            userDisplayRS.setStatus("Success");
            userDisplayRS.setStatusCode(0);
            userDisplayRS.setStatusMessage("User Found");
            userDisplayRS.setUser(user);
        } catch (Exception ex) {
            userDisplayRS.setStatus("Failed");
            userDisplayRS.setStatusCode(2);
            userDisplayRS.setStatusMessage("Exception occurred: " + ex.getMessage());
        }
        return userDisplayRS;
    }

    @Override
    public UserRS UpdateUser(UserRegisterRQ userRegisterRQ) {
        return null;
    }

    @Override
    public UserRS DeleteUser(String email) {
        return null;
    }


}
