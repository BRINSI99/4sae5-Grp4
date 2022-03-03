package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private JavaMailSender emailSender;

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

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(false);
        userRepository.save(user);
        System.out.println(user.getEmail());
        MimeMessage message = emailSender.createMimeMessage();



        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("Representative");
            helper.setTo(user.getEmail());
            helper.setSubject("Vérification de compte");
            helper.setText("Votre compte sera activé dans peu de temps");

            emailSender.send(message);


        } catch (MessagingException E) {
             // TODO Auto-generated catch block
            E.printStackTrace();

       }
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

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //@Override
    //public User findUserByUsername(String username) {
      //  return userRepository.findByUsername(username);
    //}

}
