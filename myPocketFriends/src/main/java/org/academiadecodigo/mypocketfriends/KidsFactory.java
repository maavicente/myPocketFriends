package org.academiadecodigo.mypocketfriends;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.FriendType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class KidsFactory {

    private Kid newKid;
    private Friend friend;
    private FriendType friendType;
    private ArrayList<Friend> list;

    public Kid createKid(String name, FriendType friendType) {

        newKid = new Kid();
        newKid.setFirstName(name);

        for (int i = 0; i < FriendType.values().length; i++) {
            list.add(new Friend(FriendType.values()[i]));
        }

        newKid.setAbstractFriendAbs(list);

        return newKid;
    }
}
