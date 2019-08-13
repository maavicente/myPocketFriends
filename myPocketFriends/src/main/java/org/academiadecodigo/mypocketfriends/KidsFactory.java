package org.academiadecodigo.mypocketfriends;

import org.academiadecodigo.mypocketfriends.model.Friend;
import org.academiadecodigo.mypocketfriends.model.Kid;
import org.springframework.stereotype.Component;

@Component
public class KidsFactory {

    private Kid newKid;
    private Friend friend;
    private FriendType friendType;

    public Kid createKid(String name, FriendType friendType) {

        newKid = new Kid();
        newKid.setName(name);

        newKid.setFriendsList(newKid.getFriendList());

        return newKid;
    }
}
