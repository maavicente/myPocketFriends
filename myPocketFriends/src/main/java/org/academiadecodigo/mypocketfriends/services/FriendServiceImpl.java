package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.FriendDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.dao.KidDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.FriendAbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendServiceImpl {

    private FriendDao friendDao;

    @Autowired
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }


    public FriendAbs get(Integer id) {
        return friendDao.findById(id);
    }

}


