package com.myprojects.servicereport.endpoint;

import com.myprojects.servicereport.dtos.UsersDto;
import com.myprojects.servicereport.exception.UserAlreadyExistsException;
import com.myprojects.servicereport.exception.UserNotFoundException;
import com.myprojects.servicereport.facade.UsersFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("v1/sr")
public class UsersController {

    private final UsersFacade usersFacade;

    @GetMapping("/users/{id}")
    public UsersDto getUser(@PathVariable("id") Long userId) throws UserNotFoundException {
        return usersFacade.getUser(userId);
    }

    @PostMapping(value = "/users", consumes = APPLICATION_JSON_VALUE)
    public UsersDto createUser(@RequestBody @Valid UsersDto usersDto) throws UserNotFoundException,
            UserAlreadyExistsException {
        return usersFacade.saveUser(usersDto);
    }

    @PutMapping("/users/{id}")
    public UsersDto updateUser(@PathVariable("id") Long userId, @RequestBody UsersDto userDto)
            throws UserNotFoundException {
        return usersFacade.updateUser(userId, userDto);
    }
}
