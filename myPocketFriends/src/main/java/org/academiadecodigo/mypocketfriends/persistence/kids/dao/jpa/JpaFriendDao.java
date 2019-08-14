package org.academiadecodigo.mypocketfriends.persistence.kids.dao.jpa;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.FriendDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.AbstractFriend;
import org.springframework.stereotype.Repository;



public class JpaFriendDao extends GenericJpaDao<AbstractFriend> implements FriendDao {

    public JpaFriendDao() {
        super(AbstractFriend.class);
    }
}
