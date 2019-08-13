package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.FriendDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.dao.KidDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendServiceImpl implements FriendService {

    private FriendDao friendDao;
    private KidDao kidDao;

    @Autowired
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    @Transactional
    @Override
    public void saveMessage() {
        Friend friend =  friendDao.findById()
    }
}


