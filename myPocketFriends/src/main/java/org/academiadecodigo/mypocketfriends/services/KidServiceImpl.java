package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.persistence.kids.dao.FriendDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.dao.KidDao;
import org.academiadecodigo.mypocketfriends.persistence.kids.dao.MessageDao;
import org.springframework.stereotype.Service;

/**
 * An {@link KidService} implementation
 */
@Service
public class KidServiceImpl implements KidService {

    private KidDao kidDao;
    private MessageDao messageDao;
    private FriendDao friendDao;

}

