package com.controller;

import com.dto.MessageDTO;
import com.model.Message;
import com.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable int id) {
        return messageRepository.findById(id).orElse(null);
    }

    @PostMapping(consumes = "multipart/form-data")
    public Message createMessage(@ModelAttribute MessageDTO messageDTO) {
        Message message = new Message();
        message.setFirstName(messageDTO.getFirstName());
        message.setLastName(messageDTO.getLastName());
        message.setEmail(messageDTO.getEmail());
        message.setMessage(messageDTO.getMessage());
        return messageRepository.save(message);
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message) {
        if (messageRepository.existsById(id)) {
            message.setMessageID(id);
            return messageRepository.save(message);
        } else {
            return null; // Or handle as needed
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id) {
        messageRepository.deleteById(id);
    }
}
