package com.afq.zefaf;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfileInfo extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    private CircleImageView profileImage;
    private EditText editname;
    private EditText editphone;
    private EditText editemail;
    private Button buttonlogin;
    private ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_info);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        profileImage = findViewById(R.id.profile_image);
        editname = findViewById(R.id.editname);
        editphone = findViewById(R.id.editphone);
        editemail = findViewById(R.id.editemail);
        buttonlogin = findViewById(R.id.buttonlogin);
        progressbar = findViewById(R.id.progressbar);


    }


    public void fillInfo() {

        if (user != null) {

            editname.setText(user.getDisplayName());
            editemail.setText(user.getEmail());
            editphone.setText(user.getPhoneNumber());

        }

    }

//    public void updateInfo() {
//        if (user != null) {
//
//
//            user.updateEmail(editemail.);
//
//            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
//                    .setDisplayName(name)
//                    .build();
//
//            user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//                    if (task.isSuccessful()) {
//                        Toast.makeText(Regster.this, "Profile updated", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//
//    }
}
