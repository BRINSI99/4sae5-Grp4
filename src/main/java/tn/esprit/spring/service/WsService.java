package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.repository.MessageRepository;
import tn.esprit.spring.repository.EmployeeRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class WsService implements IMessage {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    // Add msg--------------------------------------------------------------------------------
    public Message AddMessage(Message message, Employee employee) {
        message.setDateMessage(new Date());
        message.setUser(employee);
        message = messageRepository.save(message);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:/Users/nassi/Desktop/Nassim/src/test/java/tn/esprit/spring/bad_words.txt"));
            String line = reader.readLine();
            while (line != null) {
                if (message.getMessage().contains(line))
                {
                    System.out.println("You are using bad words");
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    // Delete msg
    @Override
    public void deletemessage(int id) {
        this.messageRepository.deleteById(id);
    }
}
