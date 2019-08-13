package org.academiadecodigo.mypocketfriends;

import org.academiadecodigo.mypocketfriends.model.Friend;
import org.academiadecodigo.mypocketfriends.model.Kid;
import org.springframework.stereotype.Component;

@Component
public class KidsFactory {

    private Kid newKid;
    private Friend friend;

    public Kid createKid(String name) {

        newKid = new Kid();
        newKid.setName(name);
        newKid.setFriendArrayList();

        return newKid;
    }
}
