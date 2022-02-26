package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.repository.MessageRepository;
import tn.esprit.spring.repository.EmployeeRepository;

import java.util.Date;
import java.util.List;

@Service
public class WsService implements IMessage {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public Message AddMessage(Message message) {
        message.setDateMessage(new Date());
        message = messageRepository.save(message);
        return message;
    }

    @Override
    public void deletemessage(int id) {
        this.messageRepository.deleteById(id);
    }

    @Override
    public void AddAffectMsgEmployee(List<Message> msg, int employeeId) {
        messageRepository.saveAll(msg);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        for (Message message : msg) {
            message.setUser(employee);
        }
        messageRepository.saveAll(msg);
    }
}
