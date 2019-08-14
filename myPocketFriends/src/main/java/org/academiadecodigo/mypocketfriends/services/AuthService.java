package org.academiadecodigo.mypocketfriends.services;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;

public interface AuthService {

    boolean authenticate(Integer id);

    Kid getAccessingKid();
}
