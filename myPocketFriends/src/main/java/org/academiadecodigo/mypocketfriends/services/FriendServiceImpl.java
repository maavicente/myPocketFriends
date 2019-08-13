package org.academiadecodigo.mypocketfriends.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {

    private FriendDao friendDao;

    @Autowired
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    @Override
    public Friend get(Integer id) {
        return friendDao.findById(id);
    }


}


