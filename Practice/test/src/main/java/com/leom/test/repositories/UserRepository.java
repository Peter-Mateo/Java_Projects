package com.peterm.test.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.peterm.test.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Gets the Email
    Optional<User> findByEmail(String email);
}