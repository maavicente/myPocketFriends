package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.FriendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {

    private FriendDao friendDao;

    @Autowired
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }




}


