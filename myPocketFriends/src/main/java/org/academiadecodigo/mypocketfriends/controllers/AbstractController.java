package org.academiadecodigo.mypocketfriends.controllers;


import org.academiadecodigo.mypocketfriends.services.AuthService;

public abstract class AbstractController implements Controller {

    protected AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void init() {
        authService.getAccessingKid();
    }
}
