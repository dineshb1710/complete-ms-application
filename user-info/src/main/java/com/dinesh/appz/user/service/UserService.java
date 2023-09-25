package com.dinesh.appz.user.service;

import com.dinesh.appz.user.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<UserDto> addUser(UserDto userDto);

    ResponseEntity<UserDto> find(int id);
}
