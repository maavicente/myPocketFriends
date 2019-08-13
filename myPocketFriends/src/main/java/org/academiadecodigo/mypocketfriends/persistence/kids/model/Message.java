package org.academiadecodigo.mypocketfriends.persistence.kids.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message extends AbstractModel {

    private String name;
    private String message;

    @ManyToOne
    private Kid kid;


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
