package com.peterm.javabelt.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.peterm.javabelt.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Gets the Email
    Optional<User> findByEmail(String email);
}