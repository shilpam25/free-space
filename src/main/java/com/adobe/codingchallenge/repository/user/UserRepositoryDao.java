package com.adobe.codingchallenge.repository.user;

import com.adobe.codingchallenge.model.User;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserRes;

public interface UserRepositoryDao {
    void createUser(UserReq usr);
    UserRes findUser(UserReq usr);
}
