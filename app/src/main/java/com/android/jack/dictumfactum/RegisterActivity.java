package com.android.jack.dictumfactum;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    MaterialEditText username, email, password;
    Button btn_register;

    RadioButton rb1;
    RadioButton rb2;
    String txt_lawyer_status;


    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Регистрация");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_register = findViewById(R.id.btn_register);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);


        auth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = username.getText().toString();
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                if(rb1.isChecked()){
                    txt_lawyer_status = "notlawyer";
                    rb2.setChecked(false);
                }

                if(rb2.isChecked()){
                    txt_lawyer_status = "lawyer";
                    rb1.setChecked(false);
                }


                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_lawyer_status)){
                    Toast.makeText(RegisterActivity.this, "Все поля обязательны для заполнения", Toast.LENGTH_SHORT).show();
                }else if (txt_password.length()<6){
                    Toast.makeText(RegisterActivity.this, "Пароль должен состоять не менее чем из 6 символов", Toast.LENGTH_SHORT).show();
                }else{
                    register(txt_username, txt_email, txt_password);
                }

            }
        });

    }

    private void register(final String username, String email, String password){


        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid = firebaseUser.getUid();


                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);


                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL", "default");
                            hashMap.put("status", "offline");


                            if(txt_lawyer_status.equals("notlawyer")){
                                hashMap.put("lawyer_status", "notlawyer");
                            }else{
                                hashMap.put("lawyer_status", "lawyer");
                            }


                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });



                        }else {
                            Toast.makeText(RegisterActivity.this, "Вы не можете зарегистрироваться с данным email и паролем", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
