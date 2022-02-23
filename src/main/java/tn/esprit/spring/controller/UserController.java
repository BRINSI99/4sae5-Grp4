package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.IUserService;
import tn.esprit.spring.entity.User;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    IUserService userService;

    // http://localhost:8089/SpringMVC/User/create

    @PostMapping("/create")
    @ResponseBody
    public void createUser(@ModelAttribute User user) {
        userService.SaveUser(user);
    }

    // http://localhost:8089/SpringMVC/User/getAllUsers
    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers() {

        List<User> users = userService.GetAllUsers();
        return users;

    }
    // http://localhost:8089/SpringMVC/User/delete/1

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable("id") int userId) {

        userService.DeleteUser(userId);
        ;
    }
    // http://localhost:8089/SpringMVC/User/update/1

    @PutMapping("/update/{id}")
    public void updateUser( @ModelAttribute User user) {
        userService.UpdateUser(user);
    }
}
