package com.real_taxi.service.booking.enums;

import java.util.Arrays;

public enum Role {
    USER,
    DRIVER,
    ADMIN;

    public static boolean isValid(String role){
        if(role.isEmpty()) return false;
        return Arrays.stream(Role.values())
                .anyMatch(r -> r.name().equalsIgnoreCase(role));
    }
}
