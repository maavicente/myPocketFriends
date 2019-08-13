package org.academiadecodigo.mypocketfriends.converters;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.springframework.stereotype.Component;

@Component
public class KidToKidDto extends AbstractConverter<Kid, KidDto> {


    @Override
    public KidDto convert(Kid kid) {

        KidDto kidDto = new KidDto();
        kidDto.setId(kid.getId());
        kidDto.setFirstName(kid.getFirstName());
        kidDto.setLastName(kid.getLastName());
        kidDto.setEmail(kid.getEmail());
        kidDto.setPhone(kid.getPhone());

        return kidDto;
    }
}
