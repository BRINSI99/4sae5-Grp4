package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserServiceImpl;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/registration")
    public String createNewUser(@RequestBody User user) {
        String msg = "";
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            msg = "There is already a user registered with the user name provided";
        } else {
            userService.SaveUser(user);
            msg = "OK";
        }
        return msg;
    }
    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers() {

        List<User> users = userService.GetAllUsers();
        return users;

    }
}
