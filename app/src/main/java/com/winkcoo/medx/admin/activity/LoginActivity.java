package com.winkcoo.medx.admin.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.winkcoo.medx.admin.R;
import com.winkcoo.medx.admin.Utils.MyDialog;
import com.winkcoo.medx.admin.Utils.MyProgressBar;
import com.winkcoo.medx.admin.api.Api;
import com.winkcoo.medx.admin.api.ApiListener;
import com.winkcoo.medx.admin.model.LoginResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.MY_ID;
import static com.winkcoo.medx.admin.data.data.TOKEN;
import static com.winkcoo.medx.admin.data.data.loginResponse;

public class LoginActivity extends AppCompatActivity implements  ApiListener.LoginListener {
    @BindView(R.id.ed_email)
    EditText ed_email;
    @BindView(R.id.ed_password)
    EditText ed_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    public void login(View view) {
        String email=ed_email.getText().toString().trim();
        String password=ed_password.getText().toString().trim();
        if (email.length()>0){
            if (password.length()>0){
                MyProgressBar.with(LoginActivity.this);
                Api.getInstance().loginUser(email,password,this);
            }
        }
    }

    @Override
    public void onLoginSuccess(LoginResponse list) {



        MyProgressBar.dismiss();
        if (list.getStatus()==true&&list.getUserInfo().getUserType().equals("a")){
            loginResponse=list;
            TOKEN="Bearer " + list.getAccessToken();
            MY_ID=list.getUserInfo().getId();
            startActivity(new Intent(this,MainActivity.class));
        }else {
            MyDialog.getInstance().with(LoginActivity.this).message("Login failed").show();
        }
    }

    @Override
    public void onLoginFailed(String msg) {
        MyProgressBar.dismiss();

        MyDialog.getInstance().with(LoginActivity.this).message(msg).show();


    }
}
