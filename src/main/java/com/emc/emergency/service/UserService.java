package com.emc.emergency.service;

import com.emc.emergency.data.model.User;
import com.emc.emergency.data.model.User_Type;
import com.emc.emergency.data.repository.*;
import com.emc.emergency.data.repository.userRepository;
import com.emc.emergency.data.repository.user_typeRepository;
import com.emc.emergency.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hocan on 22-May-17.
 */
@Service
public class UserService {
    @Autowired
    userRepository userRepository;
    @Autowired
    user_typeRepository user_typeRepository;
//    @Autowired
//     personal_infoRepository personal_infoRepository;
//    @Autowired
//    chatRepository chatRepository;
//    @Autowired
//    accidentRepository accidentRepository;

    public List<User> findAll() {
        List<User> users = Util.makeUserCollection(userRepository.findAll());
        return users;
    }

    public Boolean Login(String username,String password ) {
        List<User> userList= userRepository.findByUsernameAndPassword(username,password);
        if(userList.isEmpty()) return false;
        if(userList.get(0).getIs_lock()==null) return true;
        if(!userList.get(0).getIs_lock()) return false;
        return true;
    }
    public User getUserByUsername(String username ) {
        User user= userRepository.findByUsername(username);
        if(null==user) return null;
        return user;
    }
    public Boolean Login2(String username,String password ) {
        List<User> userList= userRepository.findByUsernameAndPassword(username,password);
        Boolean flag=false;

        for (User user : userList) {
            if (user.getUser_type().getName_user_type().equals("admin")) {
                flag = true;
            }
        }
        return flag;
    }

    public Boolean Register(String username,String password ) {
        User userList= userRepository.findByUsername(username);
        if(userList==null)
        {   User_Type user_type = user_typeRepository.findOne(3l);
            User user = new User(null,username,user_type,password,null,0.0,0.0);
            userRepository.save(user);
            return true;

        }
        return false;
    }


}
