package com.example.vector.chatapplicationmvp.presenters;

import com.example.vector.chatapplicationmvp.interactors.LoginInteractor;
import com.example.vector.chatapplicationmvp.interactors.LoginInteractorImpl;
import com.example.vector.chatapplicationmvp.views.activities.LoginView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class LoginPresenterImpl implements LoginPresenter {
    EventBus eventBus;
    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        //this.eventBus = GreenRobotEventBus.getInstance();
        this.mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
        eventBus.unregister(this);
    }

    @Override
    public void checkForAuthenticateUser() {
        if(mLoginView != null){
            mLoginView.disabledInputs();
            mLoginView.showProgresBar();
        }
        mLoginInteractor.checkAlreadyAuthenticated();
    }

    @Override
    public void validateLogin(String email, String password) {
        if(mLoginView != null){
            mLoginView.disabledInputs();
            mLoginView.showProgresBar();
        }
        mLoginInteractor.doSignIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if(mLoginView != null){
            mLoginView.disabledInputs();
            mLoginView.showProgresBar();
        }
        mLoginInteractor.doSignUp(email, password);
    }


    /*@Override
    @Subscribe
    public void onEventMainThread(LoginEvent event){
        switch (event.getEventType()){

        }
    }*/

    private void onSignInSucces(){
        if(mLoginView != null){
            mLoginView.navigateToMainScreen();
        }
    }

    private void onSignUpSucces(){
        if(mLoginView != null){
            mLoginView.newUserSucces();
        }
    }

    private void onSignInError(String error){
        if(mLoginView != null){
            mLoginView.hideProgressBar();
            mLoginView.enabledInputs();
            mLoginView.loginError(error);
        }
    }

    private void onSignUpError(String error){
        if(mLoginView != null){
            mLoginView.hideProgressBar();
            mLoginView.enabledInputs();
            mLoginView.loginError(error);
        }
    }

    private void onFailedToRecoverSession(){
        if(mLoginView != null){
            mLoginView.hideProgressBar();
            mLoginView.enabledInputs();
        }
    }




}
