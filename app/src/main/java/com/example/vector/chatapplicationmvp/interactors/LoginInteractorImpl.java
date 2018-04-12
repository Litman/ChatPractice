package com.example.vector.chatapplicationmvp.interactors;

import com.example.vector.chatapplicationmvp.model.LoginRepository;
import com.example.vector.chatapplicationmvp.model.LoginRepositoryImpl;

public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;


    public LoginInteractorImpl() {
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkAlreadyAuthenticated() {
        loginRepository.checkAlreadyAuthenticated();
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email, password);
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRepository.signIn(email, password);
    }
}
