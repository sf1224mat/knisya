package com.example.knisya.knisya;

/**
 * Created by Willi on 04/06/2017.
 */
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.knisya.knisya.R;
import com.example.knisya.knisya.UsersRecyclerAdapter;
import com.example.knisya.knisya.User;
import com.example.knisya.knisya.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

    private AppCompatActivity activity = UserListActivity.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    public Button btnShop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        Button btnShop = (Button) findViewById(R.id.btnShop);

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setTitle("");
        initViews();
        initObjects();

    }

    // inisialisasi view
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
    }

    //inisialisasi object yg untuk dipake
    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        databaseHelper = new DatabaseHelper(activity);

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);

        getDataFromSQLite();
    }

    // ngambil data dari sqlite
    private void getDataFromSQLite() {
        // AsyncTask sqlite
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllUser());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}