package controllers;

import views.MainTab;
import views.MainView;
import views.login.IdandPass;
import views.login.LoginView;

public class MainController {

    IdandPass idandPass;
    LoginView loginView;
    MainView mainView;
    MainTab mainTab;

    public MainController() {
        this.idandPass = new IdandPass();
        this.loginView = new LoginView(idandPass.getLoginInfo());
        this.mainView = new MainView();
        this.mainTab = new MainTab(this.mainView);
    }

    public MainTab getMainTab() {
        return this.mainTab;
    }
}
