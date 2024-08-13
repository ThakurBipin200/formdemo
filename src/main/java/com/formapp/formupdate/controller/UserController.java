package com.formapp.formupdate.controller;

import com.formapp.formupdate.entity.User;
import com.formapp.formupdate.repository.UserRepository;
import com.formapp.formupdate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUserForm(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("selectedUser", new User()); // Initialize selectedUser for first load
        return "user-form";
    }

    @GetMapping("/users/{id}")
    public String getUserDetails(@PathVariable("id") Long id, Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        userService.getUserById(id).ifPresent(user -> model.addAttribute("selectedUser", user));
        return "user-form";
    }

    @PostMapping("/users/update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
