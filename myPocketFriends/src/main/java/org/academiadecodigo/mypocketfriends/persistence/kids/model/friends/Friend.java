package org.academiadecodigo.mypocketfriends.persistence.kids.model.friends;

import org.academiadecodigo.mypocketfriends.FriendType;

import javax.persistence.Entity;

@Entity
public class Friend extends AbstractFriend {

    public Friend(FriendType friendType) {
        super(friendType);
    }



}
