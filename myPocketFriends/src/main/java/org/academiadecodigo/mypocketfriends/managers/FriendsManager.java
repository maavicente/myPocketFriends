package org.academiadecodigo.mypocketfriends.managers;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.FriendType;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;

public class FriendsManager {

    private Friend friend;

    public FriendsManager(Friend friend) {
        this.friend = friend;
    }

    public void addFriend() {
        Friend friend = new Friend(FriendType.BUMBLEBEE);
    }

}
