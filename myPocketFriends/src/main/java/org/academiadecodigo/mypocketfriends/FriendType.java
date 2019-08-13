package org.academiadecodigo.mypocketfriends;

import java.util.Arrays;
import java.util.List;

public enum FriendType {

    CRISTIANO_RONALDO(""),
    TMNT_RAPHAEL(""),
    DOLPHY(""),
    CATARINA_PEREZ(""),
    BUMBLEBEE("");

    private String path;

    FriendType(String path) {
        this.path = path;
    }

    public static List<FriendType> getFriendTypeList() {
        return Arrays.asList(FriendType.values());
    }
}
