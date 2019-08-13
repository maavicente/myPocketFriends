package org.academiadecodigo.mypocketfriends.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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
    public Kid getKid(Integer id) {
        return kidDao.findById(id);
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

        return new ArrayList<>(kidDao.findById(id).getMessage());

    }

    @Override
    public void addMessage(Integer id, Message message) {
        Kid kid = kidDao.findById(id);

        if (kid == null) {
            throw new IllegalArgumentException("Kid does not exist");
        }

        if (friendDao.findById(message.getId()) == null ||
                getMessageIds(customer).contains(recipient.getAccountNumber())) {
            throw new IllegalArgumentException("Invalid id number");
        }

        kid.addMessage(message);
        kidDao.saveOrUpdate(kid);
    }
}

