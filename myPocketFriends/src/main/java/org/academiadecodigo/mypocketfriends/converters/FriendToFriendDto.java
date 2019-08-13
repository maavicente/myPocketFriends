package org.academiadecodigo.mypocketfriends.converters;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend;
import org.springframework.stereotype.Component;


@Component
public class FriendToFriendDto extends AbstractConverter<org.academiadecodigo.mypocketfriends.persistence.kids.model.friends.Friend, AccountDto> {


    @Override
    public AccountDto convert(Friend friend) {

        AccountDto accountDto = new AccountDto();
        accountDto.setId(friend.getId());
        accountDto.setType(friend.getAccountType());
        accountDto.setBalance(String.valueOf(friend.getBalance()));

        return accountDto;
    }
}
