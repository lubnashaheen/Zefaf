package com.afq.zefaf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private ImageView mImageView2;

    private TextView tvforgetpassword;
    private TextView mTextnewaccount;
    private EditText mEditTextphone;

    private EditText mEditTextpass;
    private Button mButtonlogin;

    private ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mImageView2 = findViewById(R.id.imageView2);

        tvforgetpassword = findViewById(R.id.tvforgetpass);
        mTextnewaccount = findViewById(R.id.textnewaccount);
        mEditTextphone = findViewById(R.id.editTextphone);
        mEditTextpass = findViewById(R.id.editTextpass);
        mButtonlogin = findViewById(R.id.buttonlogin);
        mAuth = FirebaseAuth.getInstance();

        mButtonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userlogin();
            }
        });

        mTextnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, Regster.class);
                startActivity(intent);
            }
        });

        tvforgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, ForGetPassWord.class);
                startActivity(intent);
            }
        });

        progressBar = findViewById(R.id.progressbar);
    }

    private void userlogin() {
        String phone = mEditTextphone.getText().toString().trim();
        String password = mEditTextpass.getText().toString().trim();


        if (password.isEmpty()) {
            mEditTextpass.setError("Password is required");
            mEditTextpass.requestFocus();
            return;
        }

        if (password.length() < 6) {
            mEditTextpass.setError("Minimum length of password should be 6");
            mEditTextpass.requestFocus();
            return;
        }


        if (phone.isEmpty()) {
            mEditTextphone.setError("Phone is required");
            mEditTextphone.requestFocus();
            return;
        }
        if (mEditTextphone.length() < 10) {
            mEditTextphone.setError("Enter a valid mobile");
            mEditTextphone.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);


        mAuth.signInWithEmailAndPassword(phone, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(SignInActivity.this, ActivityMap.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, LoginAct.class));

        }
    }


}
