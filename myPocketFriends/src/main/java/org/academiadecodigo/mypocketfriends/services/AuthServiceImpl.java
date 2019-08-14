package org.academiadecodigo.mypocketfriends.services;

import org.academiadecodigo.mypocketfriends.model.Kid;

public class AuthServiceImpl implements AuthService {

    private KidService kidService;
    private Kid accessingKid;

    public void setKidService(KidService kidService) {
        this.kidService = kidService;
    }

    @Override
    public boolean authenticate(Integer id) {
        accessingKid = kidService.get(id);
        return accessingKid != null;
    }

    @Override
    public Kid getAccessingKid() {
        return accessingKid;
    }
}
