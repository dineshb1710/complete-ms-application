package com.dinesh.appz.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userId;
    private String username;
    private String password;
    private String address;
    private String city;
}
