package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.User;

public interface IUserService {

    public List<User> GetAllUsers();
    public User GetUserById(int id);
    public User SaveUser (User user);
    public void DeleteUser(int id);
    public void UpdateUser (User user);


    User findUserByUsername(String username);

}
