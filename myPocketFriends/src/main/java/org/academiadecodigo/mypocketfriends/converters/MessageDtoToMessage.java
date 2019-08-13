package org.academiadecodigo.mypocketfriends.converters;

import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.academiadecodigo.mypocketfriends.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessageDtoToMessage implements Converter<MessageDto, Message> {

    private MessageService messageService;


    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }


    @Override
    public Message convert(MessageDto messageDto) {

        Message message = (messageDto.getId() != null ? messageService.get(messageDto.getId()) : new Message());

        message.setAccountNumber(messageDto.getAccountNumber());
        message.setName(messageDto.getName());
        message.setEmail(messageDto.getEmail());
        message.setPhone(messageDto.getPhone());
        message.setDescription(messageDto.getDescription());

        return message;
    }
}
