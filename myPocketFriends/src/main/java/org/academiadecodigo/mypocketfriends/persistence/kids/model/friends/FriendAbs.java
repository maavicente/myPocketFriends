package org.academiadecodigo.mypocketfriends.persistence.kids.model.friends;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.AbstractModel;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public abstract class FriendAbs extends AbstractModel {

    private double balance = 0;

    @ManyToOne
    private Kid kid;


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Kid getKid() {
        return kid;
    }


    public void setKid(Kid kid) {
        this.kid = kid;
    }



    public void credit(double amount) {
        if (canCredit(amount)) {
            balance += amount;
        }
    }


    public void debit(double amount) {
        if (canDebit(amount)) {
            balance -= amount;
        }
    }


    public boolean canCredit(double amount) {
        return amount > 0;
    }


    public boolean canDebit(double amount) {
        return amount > 0 && amount <= balance;
    }


    public boolean canWithdraw() {
        return true;
    }

    @Override
    public String toString() {
        return "FriendAbs{" +
                "balance=" + balance +
                ", customerId=" + (kid != null ? kid.getId() : null) +
                "} " + super.toString();
    }
}
