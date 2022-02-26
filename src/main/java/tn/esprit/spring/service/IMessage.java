package tn.esprit.spring.service;

import tn.esprit.spring.entity.Message;

import java.util.List;

public interface IMessage {

    void deletemessage(int id);

    void AddAffectMsgEmployee(List<Message> msg, int userId);
}
