package org.academiadecodigo.mypocketfriends.persistence.kids.model;

import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.AbstractFriend;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kids")
public class Kid extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String serialNumber;
    private String tutorName;
    private String username;
    private String password;
    private String address;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "kids",
            fetch = FetchType.EAGER
    )
    private List<AbstractFriend> abstractFriendAbs = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "kids"
    )
    private List<Message> messages = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<AbstractFriend> getFriendAbs() {
        return abstractFriendAbs;
    }


    public List<Message> getMessages() {
        return messages;
    }


    public void addFriend(AbstractFriend abstractFriend) {
        this.abstractFriendAbs.add(abstractFriend);
        abstractFriend.setKid(this);
    }


    public void removeFriend(AbstractFriend abstractFriend) {
        this.abstractFriendAbs.remove(abstractFriend);
        abstractFriend.setKid(null);
    }


    public void addMessage(Message history) {
        messages.add(history);
        history.setKid(this);
    }


    public void removeMessage(Message history) {
        messages.remove(history);
        history.setKid(null);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        // printing messages with lazy loading
        // and no session will cause issues
        return "Kid{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", friendAbs=" + abstractFriendAbs +
                "} " + super.toString();
    }
}



