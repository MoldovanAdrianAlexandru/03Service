package com.aditreilinii.Service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService{
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {

        this.messageRepository = messageRepository;
    }
    @Override
    public List<Message> getMessages() {

        return messageRepository.findAll();
    }

    @Override
    public void createMessage(Message message) {
        message.setTimestamp(Timestamp.getTimestamp());
        message.setStatus(MessageStatus.SENT);
        messageRepository.save(message);
    }
    @Override
    public void updateMessage(Long id, Message message){
        Message messageToUpdate = messageRepository.findById(id).orElseThrow(
                () ->  new IllegalStateException(String.format("Message with id %s does not exist", id)));

        messageToUpdate.setMessage(message.getMessage());
        messageToUpdate.setUserSender(message.getUserSender());
        messageToUpdate.setUserReciever(message.getUserReciever());

        messageRepository.save(messageToUpdate);
    }
    @Override
    public void deleteMessage(Long id){
        Message messageToUpdate = messageRepository.findById(id).orElseThrow(
                () ->  new IllegalStateException(String.format("Message with id %s does not exist", id)));
        messageToUpdate.setStatus(MessageStatus.DELETED);

        messageRepository.save(messageToUpdate);
    }


}
