package org.academiadecodigo.mypocketfriends.converters;

import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.springframework.stereotype.Component;


@Component
public class MessageToMessageDto extends AbstractConverter<Message, MessageDto> {


    @Override
    public MessageDto convert(Message message) {

        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setAccountNumber(message.getAccountNumber());
        messageDto.setName(message.getName());
        messageDto.setEmail(message.getEmail());
        messageDto.setPhone(message.getPhone());
        messageDto.setDescription(message.getDescription());

        return messageDto;
    }
}
