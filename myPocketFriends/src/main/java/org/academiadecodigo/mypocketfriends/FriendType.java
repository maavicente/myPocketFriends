package org.academiadecodigo.mypocketfriends;

import java.util.Arrays;
import java.util.List;

public enum FriendType {

    CRISTIANO_RONALDO("/CR7.jpg", "Cristiano"),
    TMNT_RAPHAEL("/TMNTRaphael.jpg", "Raphael"),
    DOLPHIN("Dolphin.jpg", "Dolphin"),
    CATARINA_PERES("CatarinaPeres.jpg", "Catarina"),
    BUMBLEBEE("bumblebee.jpg", "BumbleBee");

    private String path;
    private String name;

    FriendType(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public static List<FriendType> getFriendTypeList() {
        return Arrays.asList(FriendType.values());
    }

    public String getName() {
        return name;
    }
}
