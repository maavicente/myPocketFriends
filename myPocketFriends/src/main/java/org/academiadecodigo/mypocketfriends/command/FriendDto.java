package org.academiadecodigo.mypocketfriends.command;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class FriendDto {

    public static final String moneyRegex = "^\\$?0*[1-9]\\d*(\\.\\d{0,2})?|\\d*(\\.0[1-9])|\\d*(\\.[1-9]\\d?)?$?";

    private Integer id;

    @NotNull(message = "A message is need to be saved")
    @NotBlank(message = "A message is need to be saved")
    private String message;

    /**
     * Gets the id of the account DTO
     *
     * @return the account DTO id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the account DTO
     *
     * @param id the account DTO id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the account DTO balance
     *
     * @return the account DTO balance
     */
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
