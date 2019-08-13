package org.academiadecodigo.mypocketfriends.persistence.kids.dao.jpa;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.FriendDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.FriendAbs;
import org.springframework.stereotype.Repository;


@Repository
public class JpaFriendDao extends GenericJpaDao<FriendAbs> implements FriendDao {

    public JpaFriendDao() {
        super(FriendAbs.class);
    }
}
