package com.example.vector.chatapplicationmvp.views.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.vector.chatapplicationmvp.R;
import com.example.vector.chatapplicationmvp.presenters.LoginPresenter;
import com.example.vector.chatapplicationmvp.presenters.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.etEmail)
    AutoCompleteTextView mEmail;

    @BindView(R.id.etPassword)
    EditText mPassword;

    @BindView(R.id.lnlContainLogin)
    View mContainLogin;

    @BindView(R.id.pbProgressLogin)
    View mProgressLogin;

    @BindView(R.id.btnSignIn)
    Button btnSignIn;

    @BindView(R.id.btnSignUp)
    Button btnSignUp;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.checkForAuthenticateUser();

    }

    @OnClick(R.id.btnSignUp)
    public void signUp(){
        mEmail.setError(null);
        mPassword.setError(null);

        loginPresenter.registerNewUser(mEmail.getText().toString(), mPassword.getText().toString());
    }

    @OnClick(R.id.btnSignIn)
    public void signIn(){
        mEmail.setError(null);
        mPassword.setError(null);
        loginPresenter.validateLogin(mEmail.getText().toString(), mPassword.getText().toString());
    }


    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }



    @Override
    public void enabledInputs() {
        setInputs(true);
    }


    @Override
    public void disabledInputs() {
        setInputs(false);
    }

    @Override
    public void showProgresBar() {
        mProgressLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressLogin.setVisibility(View.GONE);
    }

    @Override
    public void handledSignIn() {

    }

    @Override
    public void handledSignUp() {

    }

    @Override
    public void navigateToHome() {
        Intent intentHome = new Intent(this, HomeActivity.class);
        startActivity(intentHome);

    }

    @Override
    public void loginError(String error) {
        mPassword.setText("");
        @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String msgError = String.format(getString(R.string.login_error_message_singin), error);
        mPassword.setError(msgError);
    }

    @Override
    public void newUserSucces() {
        Snackbar.make(mContainLogin, R.string.login_notice_message_useradded, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void newUserError(String error) {
        mEmail.setError(error);
        @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String msgError = String.format(getString(R.string.login_error_message_singin), error);
        mEmail.setError(msgError);
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, ContactListActivity.class ));
    }

    private void setInputs(boolean b) {
        btnSignIn.setEnabled(true);
        btnSignUp.setEnabled(true);
        mEmail.setEnabled(true);
        mPassword.setEnabled(true);
    }
}
