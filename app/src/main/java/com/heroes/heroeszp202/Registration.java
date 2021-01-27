package com.heroes.heroeszp202;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");

        Button register=findViewById(R.id.registers);
        final EditText username=findViewById(R.id.usernames);
        final EditText email=findViewById(R.id.email);
        final EditText password=findViewById(R.id.passwords);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Validation.isValidUsername(username.getText().toString()) &&
                        Validation.isValidEmail(email.getText().toString()) &&
                        Validation.isValidPassword(password.getText().toString()))  {

                    Intent goToLoginActivity = new Intent(Registration.this, LoginActivity.class);
                    startActivity(goToLoginActivity);

                  
                } else {
                    username.setError(getResources().getString(R.string.register_invalid_validation));
                    username.requestFocus();
                }


            }
        });
    }
}
