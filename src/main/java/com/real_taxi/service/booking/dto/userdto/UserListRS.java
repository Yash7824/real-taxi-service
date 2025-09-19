package com.real_taxi.service.booking.dto.userdto;

import com.real_taxi.service.booking.model.User;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserListRS {
    private String status;
    private Integer statusCode;
    private String statusMessage;
    private List<User> users;
}
