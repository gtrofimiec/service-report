package com.myprojects.servicereport.repository;

import com.myprojects.servicereport.domain.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Long> {

    @Override
    Optional<Users> findById(Long userId);

    @Override
    Users save(Users user);
}
