package com.adobe.codingchallenge.repository.user;

import com.adobe.codingchallenge.model.User;
import com.adobe.codingchallenge.model.UserReq;
import com.adobe.codingchallenge.model.UserDetails;
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
    public UserDetails createUser(UserReq usr){
        User user = new User();
        user.setCretDt(new Date(System.currentTimeMillis()));
        user.setPassword(usr.getPwd());
        user.setUserEmail(usr.getUserEmail());
        User UserDetailsult = userRepository.save(user);
        UserDetails UserDetails = new UserDetails();
        UserDetails.setUserId(UserDetailsult.getUserId());
        UserDetails.setUserEmail(UserDetailsult.getUserEmail());
        return UserDetails;
    }

    @Override
    public UserDetails findUser(UserReq usr){
        List<User> user = userRepository.findUserByUserEmail(usr.getUserEmail());
        if (user.size()>0){
            UserDetails UserDetails = new UserDetails();
            UserDetails.setUserId(user.get(0).getUserId());
            return UserDetails;
        }
        else{
           return null;
        }
    }

    @Override
    public UserDetails getUserDetails(long userId){
        UserDetails UserDetails = new UserDetails();
        User user = userRepository.findUserByUserId(userId);
        if(user !=null){
            UserDetails.setUserEmail(user.getUserEmail());
            UserDetails.setUserId(user.getUserId());
        return UserDetails;
        }
        return null;
    }
}
