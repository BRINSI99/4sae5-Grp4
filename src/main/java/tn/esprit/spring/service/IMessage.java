package tn.esprit.spring.service;

import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.entity.Message;

public interface IMessage {

    Message AddMessage(Message message, Employee employee);
    void deletemessage(int id);

}
