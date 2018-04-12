package com.example.vector.chatapplicationmvp.model;

public interface LoginRepository {
    void signIn(final String email, final String password);
    void signUp(String email, String password);
    void checkAlreadyAuthenticated();
}
