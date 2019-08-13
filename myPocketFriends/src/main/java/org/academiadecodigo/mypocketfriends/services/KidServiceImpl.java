package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.persistence.dao.RecipientDao;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;
import org.academiadecodigo.javabank.persistence.model.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An {@link KidService} implementation
 */
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
        return null;
    }

    @Override
    public List<Kid> list() {
        return null;
    }

    @Override
    public List<Message> listMessages(Integer id) {
        return null;
    }

    @Override
    public void addMessage(Integer id, Message message) {

    }
}

