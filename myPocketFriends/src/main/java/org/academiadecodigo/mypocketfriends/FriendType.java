package org.academiadecodigo.mypocketfriends;

import java.util.Arrays;
import java.util.List;

public enum FriendType {

    CRISTIANO_RONALDO("/CR7.jpg"),
    TMNT_RAPHAEL("/TMNTRaphael.jpg"),
    DOLPHIN("Dolphin.jpg"),
    CATARINA_PERES("CatarinaPeres.jpg"),
    BUMBLEBEE("bumblebee.jpg");

    private String path;

    FriendType(String path) {
        this.path = path;
    }

    public static List<FriendType> getFriendTypeList() {
        return Arrays.asList(FriendType.values());
    }
}
