package com.example.vector.chatapplicationmvp.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.vector.chatapplicationmvp.R;
import com.example.vector.chatapplicationmvp.presenters.ContactListPresenter;
import com.example.vector.chatapplicationmvp.presenters.ContactListPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactListActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recViewContacts)
    RecyclerView recyclerView;

    private ContactListAdapater adapter;
    private ContactListPresenter contactListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);

        contactListPresenter = new ContactListPresenterImpl();
        contactListPresenter.onCreate();

        toolbar.setSubtitle(contactListPresenter.getCurrentUserEmail());
        setSupportActionBar(toolbar);

        setupAdapter();
        setupRecyclerView();


    }

    @Override
    protected void onResume() {
        super.onResume();
        contactListPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        contactListPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contactListPresenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contactlist, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupRecyclerView() {
    }

    private void setupAdapter() {
    }
}
