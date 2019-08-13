package org.academiadecodigo.mypocketfriends.managers;

import org.academiadecodigo.mypocketfriends.model.Friend;

public class FriendsManager {

    private Friend friend;

    public FriendsManager(Friend friend) {
        this.friend = friend;
    }

    public void addFriend() {
        Friend friend = new Friend();
    }
}
