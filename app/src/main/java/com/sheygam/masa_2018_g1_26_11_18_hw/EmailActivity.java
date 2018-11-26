package com.sheygam.masa_2018_g1_26_11_18_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PASSWORD_ACTIVITY_CODE = 0x01;
    private EditText inputEmail;
    private Button backBtn, nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        inputEmail = findViewById(R.id.input_email);
        backBtn = findViewById(R.id.back_btn);
        nextBtn = findViewById(R.id.next_btn);
        backBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_btn){
            finish();
        }else if(v.getId() == R.id.next_btn){
            String email = String.valueOf(inputEmail.getText());
            Intent intent = new Intent(this,PasswordActivity.class);
            intent.putExtra("EMAIL",email);
            startActivityForResult(intent,PASSWORD_ACTIVITY_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == PASSWORD_ACTIVITY_CODE){
            setResult(RESULT_OK,data);
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
