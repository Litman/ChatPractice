package com.example.vector.chatapplicationmvp.presenters;

public interface LoginPresenter {

    void onCreate();
    void onDestroy();
    void checkForAuthenticateUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);

//    void onEventMainThread(LoginEvent event);

}
