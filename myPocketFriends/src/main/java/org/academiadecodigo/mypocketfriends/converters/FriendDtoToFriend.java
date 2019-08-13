package org.academiadecodigo.mypocketfriends.converters;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FriendDtoToFriend implements Converter<FriendDto, Friend> {

    private FriendFactory friendFactory;

    @Autowired
    public void setFriendFactory(FriendFactory friendFactory) {
        this.friendFactory = friendFactory;
    }


    @Override
    public Friend convert(FriendDto accountDto) {

        Friend friend = null;

        friend = friendFactory.createAccount(accountDto.getType());
        friend.credit(accountDto.getBalance() != null ? Double.parseDouble(accountDto.getBalance()) : 0);

        return friend;
    }
}

