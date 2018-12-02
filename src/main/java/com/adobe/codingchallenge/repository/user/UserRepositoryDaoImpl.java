package com.adobe.codingchallenge.repository.user;

import com.adobe.codingchallenge.model.User;
import com.adobe.codingchallenge.model.UserReq;
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
        //user.setUserId(new BigInteger("1234"));
        user.setCretDt(new Date(System.currentTimeMillis()));
        user.setPassword(usr.getPwd());
        user.setUserEmail(usr.getUserId());
        userRepository.save(user);
    }

    @Override
    public Boolean findUser(UserReq usr){
        List<User> user = userRepository.findUserByUserEmail(usr.getUserId());
        if (user.size()>0)
        return true;
        return false;
    }
}
