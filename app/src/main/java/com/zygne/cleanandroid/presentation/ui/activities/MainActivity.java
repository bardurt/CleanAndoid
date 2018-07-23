package com.zygne.cleanandroid.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zygne.clean2.threading.AndroidThread;
import com.zygne.cleanandroid.R;
import com.zygne.cleanandroid.presentation.presenters.concrete.UserPresenterImpl;
import com.zygne.cleanandroid.presentation.presenters.interfaces.UserPresenter;

public class MainActivity extends AppCompatActivity implements
        UserPresenter.View{

    private UserPresenter userPresenter;

    private EditText etUsername;
    private Button btnValidateUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userPresenter = new UserPresenterImpl(AndroidThread.getInstance(), this);

        etUsername = findViewById(R.id.et_username);
        btnValidateUsername = findViewById(R.id.btn_validate_username);

        btnValidateUsername.setOnClickListener(view -> {
            userPresenter.validateUsername(etUsername.getText().toString());
        });

    }

    @Override
    public void usernameValid() {
        Toast.makeText(MainActivity.this, "Username is valid", Toast.LENGTH_LONG).show();
    }

    @Override
    public void usernameInvalid() {
        Toast.makeText(MainActivity.this, "Username is invalid", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        // TODO: 22/07/2018 show some progress indicatior
    }

    @Override
    public void hideProgress() {
        // TODO: 22/07/2018 hide progress
    }
}
