package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.repository.MessageRepository;
import tn.esprit.spring.service.IMessage;
import tn.esprit.spring.service.WsService;

import java.util.List;

@RestController
public class WsController {

    @Autowired
    private WsService service;
    @Autowired
    IMessage messageService;

    // localhost:8080/send-message
    @PostMapping("/send-message")
    public Message sendMessage(@RequestBody Message message) {

        return service.AddMessage(message);
    }

    // localhost:8080/add-message/1
    @PostMapping("/add-message/{employeeid}")
    @ResponseBody
    void AddAffectmsg(@RequestBody List<Message> msg, @PathVariable("employeeid") int employeeid) {
        messageService.AddAffectMsgEmployee(msg, employeeid);
    }

    // localhost:8080/remove-message/1

    @DeleteMapping("/remove-message/{message-id}")
    @ResponseBody
    public  void deletemessage(@PathVariable("message-id") int Id) {
        messageService.deletemessage(Id);
    }


}
