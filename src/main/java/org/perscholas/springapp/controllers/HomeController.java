package org.perscholas.springapp.controllers;


import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.perscholas.springapp.models.User;
import org.perscholas.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;

@Controller
@Slf4j
public class HomeController {

    private UserService userService;


    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    //signing in will happen with spring security
    @GetMapping({"/index", "/"})
    public String showIndex(Model model, String success, String fail) {
        log.warn("requested index.html");
        //model.addAttribute("user", new User());


        return "index";
    }



    //checks for login credentials but will be removed for spring security implementation
    /*@GetMapping({"/valid-credentials"})
    public String checkCredentials(String email, String password) {
        User foundUser = userService.findByEmail(email);
        if (foundUser != null) return "index";
        if (foundUser.getPassword().equals("pass")) return "register";

        return"index";
    }*/

    //mapping for admin
    @GetMapping({"/admin"})
    public String showAdmin(Model model) {
        log.warn("requested admin.html");
        return "admin";
    }

    //mapping for register
    @GetMapping({"/register"})
    public String showRegister(Model model) {
        log.warn("requested register.html");
        return "register";
    }

    //current model attribute
    @ModelAttribute("current_user")
    public User userInit(){
        log.warn("starting init lol");
        return new User();
    }

    //when first constructed make an admin
    @PostConstruct
    public void init(){
        //added admin
        User user = new User("admin", "store", "admin@store.com", "pass");
        userService.addUser(user);

        log.warn("Constructed! lol");
    }

    //before destroyed
    @PreDestroy
    public void destroy(){
        log.warn("Destroyed! lol");
    }
}
