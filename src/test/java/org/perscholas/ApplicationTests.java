package org.perscholas;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.perscholas.springapp.dao.IUserRepo;
import org.perscholas.springapp.models.User;
import org.perscholas.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTests {

    private IUserRepo userRepo;

    @Autowired
    public void UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Test
    public void testAddUser() {
        UserService userService = new UserService();
        User testUser = new User();
        testUser.setEmail("allenfarias29@gmail.com");
        //System.out.println(userService.findUserById(1));
        userService.save(testUser);

        User foundUser = userService.findUserById(1);
        //System.out.println(foundUser.getId());

        assertEquals(testUser, foundUser);
    }

    @Test
    public void deleteUserByIdTest() {
        UserService userService = new UserService();
        User testUser = new User(1L, "Allen", "Farias", "allenfarias29@gmail.com", "1234");
        userService.save(testUser);

        //returns deleted User and deletes testUser
        User deletedUser = userService.deleteUserById(1L);

        //testUser is null
        System.out.println(testUser);
        assertNotEquals(testUser, deletedUser);
    }

    @Test
    public void findByEmailTest() {
        UserService userService = new UserService();
        User testUser = new User(1L, "Allen", "Farias", "allenfarias29@gmail.com", "1234");
        userService.save(testUser);

        String foundEmail = userService.findByEmail("allenfarias29@gmail.com").getEmail();

        assertEquals(testUser.getEmail(), foundEmail);

    }

    @Test
    public void test() {
        System.out.println("hello this test is working");
    }
}
