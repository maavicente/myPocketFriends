package org.academiadecodigo.mypocketfriends.persistence.kids.dao.jpa;


import org.academiadecodigo.mypocketfriends.persistence.kids.dao.KidDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.springframework.stereotype.Repository;


public class JpaKidDao extends GenericJpaDao<Kid> implements KidDao {

    public JpaKidDao() {
        super(Kid.class);
    }
}
