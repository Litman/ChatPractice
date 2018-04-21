package com.example.vector.chatapplicationmvp.presenters;

public interface ContactListPresenter {
    void onCreate();

    int getCurrentUserEmail();

    void onResume();

    void onPause();

    void onDestroy();
}
