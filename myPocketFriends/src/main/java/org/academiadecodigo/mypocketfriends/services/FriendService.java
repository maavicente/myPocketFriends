package org.academiadecodigo.mypocketfriends.services;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;

public interface FriendService {


    Friend get(Integer id);

    void saveMessage();


}
