package org.academiadecodigo.mypocketfriends.services;

import com.google.protobuf.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageDao messageDao;

    @Autowired
    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public Message get(Integer id) {
        return messageDao.findById(id);
    }
}
