package org.academiadecodigo.mypocketfriends.model;

import org.academiadecodigo.mypocketfriends.model.Friend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kid {

    private String name;
    private List<Friend> friendList;
    private HashMap message;
    private HashMap psycoNotes;

    public Kid() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFriendsList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }
}
