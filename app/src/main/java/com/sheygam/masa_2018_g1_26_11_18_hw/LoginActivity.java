package com.sheygam.masa_2018_g1_26_11_18_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int EMAIL_ACTIVITY_CODE = 0x01;
    private TextView emailTxt, passwordTxt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailTxt = findViewById(R.id.email_txt);
        passwordTxt = findViewById(R.id.password_txt);

        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn){
            Intent intent = new Intent(this,EmailActivity.class);
            startActivityForResult(intent,EMAIL_ACTIVITY_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == EMAIL_ACTIVITY_CODE){
            String email = data.getStringExtra("EMAIL");
            String password = data.getStringExtra("PASSWORD");
            emailTxt.setText(email);
            passwordTxt.setText(password);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
