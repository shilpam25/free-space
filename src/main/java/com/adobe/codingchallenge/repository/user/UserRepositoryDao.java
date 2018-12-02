package com.adobe.codingchallenge.repository.user;

import com.adobe.codingchallenge.model.User;
import com.adobe.codingchallenge.model.UserReq;

public interface UserRepositoryDao {
    void createUser(UserReq usr);
    Boolean findUser(UserReq usr);
}
