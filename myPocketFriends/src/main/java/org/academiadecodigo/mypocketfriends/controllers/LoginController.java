package org.academiadecodigo.mypocketfriends.controllers;

public class LoginController extends AbstractController {

    private Controller nextController;
    private boolean authFailed = false;

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void onLogin(int id) {
        if (authService.authenticate(id)) {
            nextController.init();
            return;
        }

        authFailed = true;
        init();
    }

    public boolean isAuthFailed() {
        return authFailed;
    }
}
