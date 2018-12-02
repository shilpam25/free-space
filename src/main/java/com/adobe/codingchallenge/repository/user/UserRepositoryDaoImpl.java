package com.adobe.codingchallenge.repository.user;

import com.adobe.codingchallenge.model.User;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@EnableJpaRepositories("com.adobe.codingchallenge.repository")
public class UserRepositoryDaoImpl implements UserRepositoryDao{
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(UserReq usr){
        User user = new User();
        user.setCretDt(new Date(System.currentTimeMillis()));
        user.setPassword(usr.getPwd());
        user.setUserEmail(usr.getUserEmail());
        userRepository.save(user);
    }

    @Override
    public UserRes findUser(UserReq usr){
        List<User> user = userRepository.findUserByUserEmail(usr.getUserEmail());
        if (user.size()>0){
            UserRes userRes = new UserRes();
            userRes.setUserId(user.get(0).getUserId().intValue());
            return userRes;
        }
        else{
           return null;
        }
    }
}
