package org.academiadecodigo.mypocketfriends.services;


import org.academiadecodigo.mypocketfriends.command.KidDto;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;

import java.util.List;

public interface KidService {

    KidDto getKid(Integer id);

    Kid save(Kid kid);

    List<Kid> list();

    List<Message> listMessages(Integer id);

    void addMessage(Integer id, Message message);

}
