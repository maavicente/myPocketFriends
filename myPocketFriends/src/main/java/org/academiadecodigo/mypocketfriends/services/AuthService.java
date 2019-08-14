package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.model.Kid;

public interface AuthService {

    boolean authenticate(Integer id);

    Kid getAccessingKid();
}
