package org.perscholas.springapp.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springapp.dao.IUserRepo;
import org.perscholas.springapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UserService {

    private IUserRepo userRepo;

    @Autowired
    public void UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findByEmail(String email){
        if (userRepo.findByEmail(email).isPresent()) {
            return userRepo.findByEmail(email).get();
        }
        return null;
    }

    public User findById(long id) {
        return userRepo.findById(id);
    }

    // save to database
    //this method will be tested
    public User addUser(User user){
        log.warn("addUser method");
        return userRepo.save(user);
    }

    // delete from database
    //this method will be tested
    public void deleteUserById(long id){
        User foundUser = findById(id);
        userRepo.delete(foundUser);
    }



}
