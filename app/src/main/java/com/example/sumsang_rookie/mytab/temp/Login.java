package com.example.sumsang_rookie.mytab.temp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sumsang_rookie.mytab.R;

public class Login extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountEdit = (EditText) findViewById(R.id.email);
        passwordEdit = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin") && password.equals("123456")){
                    Intent intent = new Intent(Login.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login.this, "account or password is wrong" +
                            "" +
                            "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
