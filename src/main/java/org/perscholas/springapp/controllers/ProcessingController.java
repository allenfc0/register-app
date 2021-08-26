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
public class ProcessingController {

    private UserService userService;


    @Autowired
    public ProcessingController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping({"/process-new-user"})
    public String processRegistration(@ModelAttribute("current_user") @Valid User user, BindingResult bindingResult, Model model, String success, String fail) {
        log.warn("post mapping");
        /*if (success != null) {
            model.addAttribute("message", "You have been registered successfully!");
        }

        if (fail != null) {
            model.addAttribute("message", "You have been registered unsuccessfully!");
        }*/
        if(bindingResult.hasErrors()){
            log.warn(bindingResult.getAllErrors().toString());
            log.warn("returned index from post");
            return "index";
        }
        userService.save(user);
        return "redirect:/index?success";
    }


}
