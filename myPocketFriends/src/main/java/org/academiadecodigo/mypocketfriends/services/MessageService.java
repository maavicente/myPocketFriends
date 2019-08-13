package org.academiadecodigo.mypocketfriends.services;

import com.google.protobuf.Message;

public interface MessageService {

    Message get(Integer id);
}
