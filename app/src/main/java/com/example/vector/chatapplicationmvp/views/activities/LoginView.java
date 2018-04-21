package com.example.vector.chatapplicationmvp.views.activities;

public interface LoginView {

    void enabledInputs();
    void disabledInputs();

    void showProgresBar();
    void hideProgressBar();

    void handledSignIn();
    void handledSignUp();

    void navigateToHome();
    void loginError(String error);

    void newUserSucces();
    void newUserError(String error);

    void navigateToMainScreen();
}
