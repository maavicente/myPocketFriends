package org.academiadecodigo.mypocketfriends.model;

import org.academiadecodigo.mypocketfriends.model.Friend;

import java.util.ArrayList;
import java.util.HashMap;

public class Kid {

    private String name;
    private ArrayList<Friend> friendArrayList;
    private HashMap message;
    private HashMap psycoNotes;

    public Kid() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setFriendArrayList(ArrayList<Friend> friendArrayList) {
        this.friendArrayList = friendArrayList;
    }
}
