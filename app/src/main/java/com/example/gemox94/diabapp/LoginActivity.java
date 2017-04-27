package com.example.gemox94.diabapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static String email = "gerardo@correo.com";
    private static String pass  = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_login    = (Button) findViewById(R.id.login_btn_login);
        Button btn_register = (Button) findViewById(R.id.login_btn_register);


        /**
         * Login Button click event
         */
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText et_email  = (TextInputEditText) findViewById(R.id.login_et_email);
                TextInputEditText et_pass   = (TextInputEditText) findViewById(R.id.login_et_password);

                /**
                 * Validate email and password
                 */
                if (email.equals(et_email.getText().toString())){
                    if (pass.equals(et_pass.getText().toString())){
                        /**
                         * Logic when credentials are valid
                         */

                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this, "Password incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Email invalido", Toast.LENGTH_SHORT).show();
                }

            }
        });

        /**
         * TODO: Create logic to start intent to register
         */

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
