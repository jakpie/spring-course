package com.sda.springcourse.repository;

import com.sda.springcourse.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaUserRepository extends CrudRepository<User, Integer> {
    List<User> findByLastName(String lastName);
}
