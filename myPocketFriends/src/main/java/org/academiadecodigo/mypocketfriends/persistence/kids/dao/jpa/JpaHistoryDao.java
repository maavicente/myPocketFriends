package org.academiadecodigo.mypocketfriends.persistence.kids.dao.jpa;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.HistoryDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.History;
import org.springframework.stereotype.Repository;

@Repository
public class JpaHistoryDao extends GenericJpaDao<History> implements HistoryDao {

    public JpaHistoryDao() {
        super(History.class);
    }
}
