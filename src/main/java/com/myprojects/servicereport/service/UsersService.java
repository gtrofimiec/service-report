package com.myprojects.servicereport.service;

import com.myprojects.servicereport.domain.Users;
import com.myprojects.servicereport.exception.UserAlreadyExistsException;
import com.myprojects.servicereport.exception.UserNotFoundException;
import com.myprojects.servicereport.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    public Users getUser(final Long id) throws UserNotFoundException {
        return usersRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public Users saveUser(final @NotNull Users user) throws UserAlreadyExistsException {
        Long id = user.getUserId();
        if(id != null && usersRepository.existsById(id)) {
            throw new UserAlreadyExistsException();
        }
        return usersRepository.save(user);
    }

    public Users updateUser(final @NotNull Users user) throws UserNotFoundException {
        Long id = user.getUserId();
        if (id == null || !usersRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        return usersRepository.save(user);
    }
}
