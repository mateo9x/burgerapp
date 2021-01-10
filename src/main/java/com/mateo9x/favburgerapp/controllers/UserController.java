package com.mateo9x.favburgerapp.controllers;

import com.mateo9x.favburgerapp.model.User;
import com.mateo9x.favburgerapp.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/userData")
    public String userForm(Model model, User user){
        model.addAttribute("user", user);
        return "userData";
    }

    @PostMapping("/userData")
    public String saveUser(User user){

            userRepository.save(user);
            return "redirect:/orderStatus";

    }
}
