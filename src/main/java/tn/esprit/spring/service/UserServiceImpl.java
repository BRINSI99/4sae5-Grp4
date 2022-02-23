package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> GetAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User GetUserById(int id) {
        User u = userRepository.findById(id).orElse(null);
        return u;
    }

    @Override
    public User SaveUser(User user) {
        userRepository.save(user);
        return user;    }

    @Override
    public void DeleteUser(int id) {
         User user=userRepository.findById(id).orElse(null);

        userRepository.deleteById(id);

    }

    @Override
    public void UpdateUser(User user) {
        userRepository.save(user);

    }
}
