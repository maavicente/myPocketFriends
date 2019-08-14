package org.academiadecodigo.mypocketfriends.services;


import org.academiadecodigo.mypocketfriends.command.KidDto;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface KidService {

    Kid getKid(Integer id);

    Kid save(Kid kid);

    List<Kid> list();

    List<Message> listMessages(Integer id);

    void addMessage(Message message);

}
