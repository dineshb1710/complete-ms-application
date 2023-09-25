package com.dinesh.appz.user.mapper;

import com.dinesh.appz.user.dto.UserDto;
import com.dinesh.appz.user.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User dtoToEntity(UserDto userDto);

    UserDto entityToDto(User user);
}
