package org.academiadecodigo.mypocketfriends.persistence.kids.model.friends;

import javax.persistence.Entity;

@Entity
public class Friend extends AbstractFriend {

    public Friend(FriendType friendType) {
        super(friendType);
    }



}
