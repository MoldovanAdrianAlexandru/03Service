package com.aditreilinii.Service;

import java.util.List;

public interface IMessageService {
    List<Message> getMessages();
    void createMessage(Message message);
    void updateMessage(Long id, Message message);
    void deleteMessage(Long id);

}
