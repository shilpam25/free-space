package com.adobe.codingchallenge.repository.user;

import com.adobe.codingchallenge.model.User;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserDetails;

public interface UserRepositoryDao {
    UserDetails createUser(UserReq usr);
    UserDetails findUser(UserReq usr);
    UserDetails getUserDetails(long userId);

}
