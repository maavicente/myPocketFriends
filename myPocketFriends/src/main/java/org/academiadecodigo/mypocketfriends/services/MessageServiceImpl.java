package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.MessageDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageDao messageDao;

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public Message get(Integer id) {
        return messageDao.findById(id);
    }
}
