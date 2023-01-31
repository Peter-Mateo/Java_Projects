package com.leom.test.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leom.test.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Gets the Email
    Optional<User> findByEmail(String email);
}