package com.myprojects.servicereport.facade;

import com.myprojects.servicereport.domain.Users;
import com.myprojects.servicereport.dtos.UsersDto;
import com.myprojects.servicereport.exception.UserAlreadyExistsException;
import com.myprojects.servicereport.exception.UserNotFoundException;
import com.myprojects.servicereport.mapper.UsersMapper;
import com.myprojects.servicereport.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsersFacade {

    private final UsersService usersService;
    private final UsersMapper usersMapper;

    public UsersDto getUser(Long userId) throws UserNotFoundException {
        return usersMapper.mapToUserDto(usersService.getUser(userId));
    }

    public UsersDto saveUser(UsersDto userDto) throws UserNotFoundException,
            UserAlreadyExistsException {
        Users newUser = usersMapper.mapToUser(userDto);
        usersService.saveUser(newUser);
        return usersMapper.mapToUserDto(newUser);
    }

    public UsersDto updateUser(Long userId, UsersDto userDto) {
        Users updatedUser = usersMapper.mapToUser(userDto);
        updatedUser.setUserId(userId);
        usersService.updateUser(updatedUser);
        return usersMapper.mapToUserDto(updatedUser);
    }
}
