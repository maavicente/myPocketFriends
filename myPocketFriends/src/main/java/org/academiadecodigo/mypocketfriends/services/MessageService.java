package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;

public interface MessageService {

    Message get(Integer id);
}
