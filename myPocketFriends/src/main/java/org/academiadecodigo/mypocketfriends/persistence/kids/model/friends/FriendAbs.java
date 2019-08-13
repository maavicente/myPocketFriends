package org.academiadecodigo.mypocketfriends.persistence.kids.model.friends;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.AbstractModel;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public abstract class FriendAbs extends AbstractModel {

    private String image;

    @ManyToOne
    private Kid kid;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Kid getKid() {
        return kid;
    }


    public void setKid(Kid kid) {
        this.kid = kid;
    }


    @Override
    public String toString() {
        return "FriendAbs{" +
                "image=" + image +
                ", KidId=" + (kid != null ? kid.getId() : null) +
                "} " + super.toString();
    }
}
