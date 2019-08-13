package org.academiadecodigo.mypocketfriends.services;


import org.academiadecodigo.mypocketfriends.model.Kid;

import java.util.List;
import java.util.Set;

public interface KidService {

    Kid get(Integer id);

    List<Kid> list();



}
