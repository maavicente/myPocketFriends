package org.academiadecodigo.mypocketfriends.persistence.kids.model.friends;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.AbstractModel;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public abstract class AbstractFriend extends AbstractModel {

    private String image;

    private String characteristics;
    private FriendType friendType;
    private String name;
    private String path;

    @ManyToOne
    private Kid kid;

    public AbstractFriend(FriendType friendType) {
        this.friendType = friendType;
        this.name = friendType.getName();
        this.path = friendType.getPath();
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
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

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}