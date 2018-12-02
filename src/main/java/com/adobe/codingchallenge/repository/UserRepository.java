package com.adobe.codingchallenge.repository;

import com.adobe.codingchallenge.model.User;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    //User findByUserIdAAndInactvDtIsNull(Integer userId);

    List<User> findUserByUserEmail(String email);

}
