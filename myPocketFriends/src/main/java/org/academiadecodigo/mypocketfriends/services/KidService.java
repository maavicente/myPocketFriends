package org.academiadecodigo.mypocketfriends.services;



public interface KidService {

    Kid getKid(Integer id);

    Kid save(Kid kid);

    List<Kid> list();

    List<Message> listMessages(Integer id);

    void addMessage(Integer id, Message message);

}
