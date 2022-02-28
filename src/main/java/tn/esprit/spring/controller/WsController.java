package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Employee;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.repository.MessageRepository;
import tn.esprit.spring.service.IMessage;
import tn.esprit.spring.service.WsService;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WsController implements Serializable {

    @Autowired
    private WsService service;
    @Autowired
    IMessage messageService;


    // localhost:8080/send-message/1
    @PostMapping("/send-message/{employeeid}")
    public Message sendMessage(@RequestBody Message message,@PathVariable("employeeid") Employee employee) {
        return service.AddMessage(message, employee);
    }

    // localhost:8080/remove-message/1

    @DeleteMapping("/remove-message/{message-id}")
    @ResponseBody
    public  void deletemessage(@PathVariable("message-id") int Id) {
        messageService.deletemessage(Id);
    }

}
