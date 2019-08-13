package org.academiadecodigo.mypocketfriends.persistence.kids.model.friends;

import javax.persistence.Entity;


@Entity
public class SavingsFriendAbs extends FriendAbs {

    public static final double MIN_BALANCE = 100;

    @Override
    public boolean canDebit(double amount) {
        return super.canDebit(amount) && (getBalance() - amount) >= MIN_BALANCE;
    }


    @Override
    public boolean canWithdraw() {
        return false;
    }
}
