package org.academiadecodigo.mypocketfriends.command;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class FriendDto {

    public static final String moneyRegex = "^\\$?0*[1-9]\\d*(\\.\\d{0,2})?|\\d*(\\.0[1-9])|\\d*(\\.[1-9]\\d?)?$?";

    private Integer id;

    @NotNull(message = "A message is need to be saved")
    @NotBlank(message = "A message is need to be saved")
    private String message;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getMessage() {
        return message;
    }


/*    public Friend getFriend() {
        return type;
    }

    public void setType(Friend friend) {
        this.friend = friend;
    }*/


/*    @Override
    public String toString() {
        return "FriendDto{" +
                ", friend=" + friend +
                ", message=" + message +
                '}';
    }*/
}
