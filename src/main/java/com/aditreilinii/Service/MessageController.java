package com.aditreilinii.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {

        this.messageService = messageService;
    }
    @GetMapping(path = "/api/v1/messages")
    public List<Message> getMessages(){
        return messageService.getMessages();

    }
    @PostMapping(path = "/api/v1/messages")
    public void createMessage(@RequestBody Message message){
        messageService.createMessage(message);
    }
    @PutMapping(path = "/api/v1/messages/{id}")
    public void updateMessage(@PathVariable Long id, @RequestBody Message message){
        messageService.updateMessage(id, message);
    }
    @DeleteMapping(path = "/api/v1/messages/{id}")
    public void deleteMessage(@PathVariable Long id){
        messageService.deleteMessage(id);
    }
}
