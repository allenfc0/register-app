package org.perscholas.springapp.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springapp.dao.IUserRepo;
import org.perscholas.springapp.models.Order;
import org.perscholas.springapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    // find the user email from the database
    public User findByEmail(String email){
        return userRepo.findByEmail(email);
        //userRepo.findByEmail(email);
    }

    // find the user id from the database
    public User findUserById(long id) {
        System.out.println("Im in the find method!");
        return userRepo.findUserById(id);
    }

    // save to database
    //this method will be tested
    public void save(User user) {
        userRepo.save(user);
    }

    // delete from database
    //this method will be tested
    public User deleteUserById(long id){
        //User foundUser = findById(id);
        return userRepo.deleteUserById(id);
    }

    //get all orders that this user has made
    public List<Order> getAllOrdersFromUserId(long id) {
         User foundUser = findUserById(id);
         return foundUser.getOrderList();

    }

}
