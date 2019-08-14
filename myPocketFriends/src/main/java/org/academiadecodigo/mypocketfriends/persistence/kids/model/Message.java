package org.academiadecodigo.mypocketfriends.persistence.kids.model;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message extends AbstractModel {

    private String name;
    private String message;
    private Friend friend;
 //   private Psycho psycho;
    private boolean read;
    @ManyToOne
    private Kid kid;


    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

   /* public Psycho getPsycho() {
        return psycho;
    }*/

   /* public void setPsycho(Psycho psycho) {
        this.psycho = psycho;
    }*/

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public Kid getKid() {
        return kid;
    }


    public void setKid(Kid kid) {
        this.kid = kid;
    }


    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                "} " + super.toString();
    }
}
