package com.dinesh.appz.user.service.impl;

import com.dinesh.appz.user.dto.UserDto;
import com.dinesh.appz.user.entity.User;
import com.dinesh.appz.user.mapper.UserMapper;
import com.dinesh.appz.user.repo.UserRepository;
import com.dinesh.appz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Override
    public ResponseEntity<UserDto> addUser(UserDto userDto) {
        log.info("MSG='Inside UserService (addUser)', userDto={}", userDto);
        User user = userMapper.dtoToEntity(userDto);
        return new ResponseEntity<>(userMapper.entityToDto(userRepository.save(user)), CREATED);
    }

    @Override
    public ResponseEntity<UserDto> find(int id) {
        log.info("MSG='Inside UserService (find)', id={}", id);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(userMapper.entityToDto(user.get()), OK);
        }
        return ResponseEntity.notFound().build();
    }
}
