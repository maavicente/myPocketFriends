package org.academiadecodigo.mypocketfriends.persistence.kids.dao.jpa;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.MessageDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.springframework.stereotype.Repository;

@Repository
public class JpaMessageDao extends GenericJpaDao<Message> implements MessageDao {

    public JpaMessageDao() {
        super(Message.class);
    }
}
