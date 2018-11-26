package com.sheygam.masa_2018_g1_26_11_18_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputPassword;
    private Button backBtn, okBtn;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        inputPassword = findViewById(R.id.input_password);
        backBtn = findViewById(R.id.back_btn);
        okBtn = findViewById(R.id.ok_btn);

        email = getIntent().getStringExtra("EMAIL");

        backBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_btn){
            finish();
        }else if(v.getId() == R.id.ok_btn){
            String password = String.valueOf(inputPassword.getText());
            Intent intent = new Intent();
            intent.putExtra("EMAIL",email);
            intent.putExtra("PASSWORD",password);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
