package org.academiadecodigo.mypocketfriends.model;

public class Friend {

    private int friendId;
    private String image;
    private String characteristics;

    public Friend() {

    }

    public Friend(int friendId, String image, String characteristics) {
        this.friendId = friendId;
        this.image = image;
        this.characteristics = characteristics;
    }

    public int getFriendId() {
        return friendId;
    }

    public String getImage() {
        return image;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
}
