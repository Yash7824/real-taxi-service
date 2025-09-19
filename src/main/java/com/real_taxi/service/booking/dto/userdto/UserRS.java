package com.real_taxi.service.booking.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRS {
    private String status;
    private Integer statusCode;
    private String statusMessage;
}