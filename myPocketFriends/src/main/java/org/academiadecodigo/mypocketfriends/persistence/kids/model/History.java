package org.academiadecodigo.mypocketfriends.persistence.kids.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recipient")
public class History extends AbstractModel {

    private String name;
    private String email;
    private String phone;
    private Integer accountNumber;
    private String description;

    @ManyToOne
    private Kid kid;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
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


    public Integer getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Kid getKid() {
        return kid;
    }


    public void setKid(Kid kid) {
        this.kid = kid;
    }


    @Override
    public String toString() {
        return "History{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", accountNumber=" + accountNumber +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
