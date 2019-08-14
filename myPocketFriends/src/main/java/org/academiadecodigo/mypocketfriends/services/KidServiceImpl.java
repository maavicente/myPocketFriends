package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.FriendType;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.Message;
import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KidServiceImpl implements KidService {

   //private KidDao kidDao;
    //private MessageDao messageDao;
    private List<Kid> list;
    ArrayList<Message> messages = new ArrayList<>();
   //private FriendDao friendDao;

    public ArrayList<Message> getMessages() {
        return messages;
    }



/*    public void setKidDao(KidDao kidDao) {
        this.kidDao = kidDao;
    }


    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }*/

    public KidServiceImpl(){
        init();
    }

    private void init(){

        list = new ArrayList<>();
        Kid kid = new Kid();
        kid.setId(0);
        kid.setFirstName("test");
        kid.setAddress("werwerw");

        ArrayList<Friend> listFriends = new ArrayList<>();

        listFriends.add(new Friend(FriendType.BUMBLEBEE));
        listFriends.add(new Friend(FriendType.CATARINA_PERES));

        kid.setAbstractFriendAbs(listFriends);

        list.add(kid);



    }



   /* @Autowired
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }*/

    @Override
    public Kid getKid(Integer id) {
        return list.get(id);
        //return kidDao.findById(id);
    }


    @Override
    public Kid save(Kid kid) {
      //  return kidDao.saveOrUpdate(kid);
        return new Kid();

    }

    @Override
    public List<Kid> list() {
        //return kidDao.findAll();
        return list;

    }

    @Override
    public List<Message> listMessages(Integer id) {

    //    Kid kid = kidDao.findById(id);

    //    if (kid == null) {
    //        throw new IllegalArgumentException("Kid does not exist");
    //    }

       // return new ArrayList<>(kidDao.findById(id).getMessages());
        return new ArrayList<>();
    }

    @Override
    public void addMessage(Message message) {
    //    Kid kid = kidDao.findById(id);

        messages.add(message);
    }

}

