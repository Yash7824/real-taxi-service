package com.real_taxi.service.booking.constant;

public class UserQ {
    public static final String GetAllUsersQ = "SELECT * FROM USERS";
    public static final String GetUserByIdQ = "SELECT * FROM USERS WHERE USER_ID = :user_id";
    public static final String GetUserByEmailQ = "SELECT * FROM USERS WHERE USER_EMAIL = :user_email";
    public static final String InsertUserQ = "INSERT INTO USERS(ID, EMAIL, NAME, PASSWORD, ROLE, WALLET) VALUES(:id, :email, :name, :password, :role, :wallet)";
    public static final String DoesEmailExistsQ = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM USERS WHERE USER_EMAIL = :user_email";
}
