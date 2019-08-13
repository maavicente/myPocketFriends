package org.academiadecodigo.mypocketfriends.persistence.kids.dao;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);

}
