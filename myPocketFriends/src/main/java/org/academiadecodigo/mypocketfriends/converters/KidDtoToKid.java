package org.academiadecodigo.mypocketfriends.converters;


import org.academiadecodigo.mypocketfriends.persistence.kids.model.Kid;
import org.academiadecodigo.mypocketfriends.services.KidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KidDtoToKid implements Converter<KidDto, Kid> {

    private KidService kidService;


    @Autowired
    public void setKidService(KidService kidService) {
        this.kidService = kidService;
    }


    @Override
    public Kid convert(KidDto kidDto) {

        Kid kid = (kidDto.getId() != null ? kidService.get(kidDto.getId()) : new Customer());

        kid.setFirstName(kidDto.getFirstName());
        kid.setLastName(kidDto.getLastName());
        kid.setEmail(kidDto.getEmail());
        kid.setPhone(kidDto.getPhone());

        return kid;
    }
}
