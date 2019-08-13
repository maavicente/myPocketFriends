package org.academiadecodigo.mypocketfriends.persistence.kids.model;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.FriendAbs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Kid extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(
            // propagate changes on customer entity to friends entities
            cascade = {CascadeType.ALL},

            // make sure to remove friendAbs if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on friends table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "customer",

            // fetch friendAbs from database together with user
            fetch = FetchType.EAGER
    )
    private List<FriendAbs> friendAbs = new ArrayList<>();

    @OneToMany(
            // propagate changes on customer entity to friends entities
            cascade = {CascadeType.ALL},

            // make sure to remove histories if unlinked from customer
            orphanRemoval = true,

            // use recipient foreign key on recipient table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "customer"
    )
    private List<History> histories = new ArrayList<>();

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


    public List<FriendAbs> getFriendAbs() {
        return friendAbs;
    }


    public List<History> getHistories() {
        return histories;
    }


    public void addAccount(FriendAbs friendAbs) {
        this.friendAbs.add(friendAbs);
        friendAbs.setKid(this);
    }


    public void removeAccount(FriendAbs friendAbs) {
        this.friendAbs.remove(friendAbs);
        friendAbs.setKid(null);
    }


    public void addRecipient(History history) {
        histories.add(history);
        history.setKid(this);
    }


    public void removeRecipient(History history) {
        histories.remove(history);
        history.setKid(null);
    }


    @Override
    public String toString() {

        // printing histories with lazy loading
        // and no session will cause issues
        return "Kid{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", friendAbs=" + friendAbs +
                "} " + super.toString();
    }
}



