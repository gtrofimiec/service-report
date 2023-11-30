package com.myprojects.servicereport.mapper;

import com.myprojects.servicereport.domain.Users;
import com.myprojects.servicereport.dtos.UsersDto;
import org.springframework.stereotype.Service;

@Service
public class UsersMapper {
    public Users mapToUser(final UsersDto usersDto) {
        return Users.builder()
                .userId(usersDto.getUserId())
                .fullName(usersDto.getFullName())
                .serviceGoal(usersDto.getServiceGoal())
                .build();
    }

    public UsersDto mapToUserDto(final Users users) {
        return UsersDto.builder()
                .userId(users.getUserId())
                .fullName(users.getFullName())
                .serviceGoal(users.getServiceGoal())
                .build();
    }
}
