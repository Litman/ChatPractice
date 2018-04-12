package com.example.vector.chatapplicationmvp.interactors;

public interface LoginInteractor {
    void checkAlreadyAuthenticated();
    void doSignIn(String email, String password);
    void doSignUp(String email, String password);
}
