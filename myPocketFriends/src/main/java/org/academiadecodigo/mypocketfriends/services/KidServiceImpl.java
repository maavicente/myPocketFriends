package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.command.KidDto;
import org.academiadecodigo.mypocketfriends.converters.KidToKidDto;
import org.academiadecodigo.mypocketfriends.persistence.kids.dao.FriendDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.dao.KidDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.dao.MessageDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class KidServiceImpl implements KidService {

    private KidDao kidDao;
    private MessageDao messageDao;
    private FriendDao friendDao;

    @Autowired
    public void setKidDao(KidDao kidDao) {
        this.kidDao = kidDao;
    }

    @Autowired
    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Autowired
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    @Override
    public KidDto getKid(Integer id) {
        KidToKidDto converter = new KidToKidDto();
        return converter.convert(kidDao.findById(id));
    }

    @Transactional
    @Override
    public Kid save(Kid kid) {
        return kidDao.saveOrUpdate(kid);
    }

    @Override
    public List<Kid> list() {
        return kidDao.findAll();
    }

    @Override
    public List<Message> listMessages(Integer id) {

        Kid kid = kidDao.findById(id);

        if (kid == null) {
            throw new IllegalArgumentException("Kid does not exist");
        }

        return new ArrayList<>(kidDao.findById(id).getMessages());

    }

    @Override
    public void addMessage(Integer id, Message message) {
        Kid kid = kidDao.findById(id);

        if (kid == null) {
            throw new IllegalArgumentException("Kid does not exist");
        }

        if (this.listMessages(id).contains(messageDao.findById(message.getId()))) {
            throw new IllegalArgumentException("Invalid id number");
        }

        kid.addMessage(message);
        kidDao.saveOrUpdate(kid);
    }
}

