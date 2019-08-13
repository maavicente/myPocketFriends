package org.academiadecodigo.mypocketfriends.model;

import org.academiadecodigo.mypocketfriends.model.Kid;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "psycho")
public class Psycho {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String userName;

/*
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "kids",
            fetch = FetchType.EAGER
    )
    private ArrayList<Kid> kidArrayList;
    */


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

    public String getPasword() {
        return password;
    }

    public void setPasword(String pasword) {
        this.password = pasword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/*    public ArrayList<Kid> getKidArrayList() {
        return kidArrayList;
    }

    public void setKidArrayList(ArrayList<Kid> kidArrayList) {
        this.kidArrayList = kidArrayList;
    }*/
}
