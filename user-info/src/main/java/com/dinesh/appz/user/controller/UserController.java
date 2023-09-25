package com.dinesh.appz.user.controller;

import com.dinesh.appz.user.dto.UserDto;
import com.dinesh.appz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        log.info("MSG='Add User', userDto={}", userDto);
        return userService.addUser(userDto);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable int id) {
        log.info("MSG='Find user', Id={}", id);
        return userService.find(id);
    }
}
