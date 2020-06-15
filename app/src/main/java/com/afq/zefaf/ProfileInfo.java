package com.afq.zefaf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.afq.zefaf.Adapter.CustomListAdapter;
import com.afq.zefaf.Model.MenuItems;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileInfo extends AppCompatActivity {


    private CircleImageView mProfileImage;
    private TextView mTxtUserName;
    private TextView mTxtUserEmail;
    private ListView mLv;
    Uri uri;
    private TextView txtEditProfileInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);

        mProfileImage = findViewById(R.id.profile_image);
        mTxtUserName = findViewById(R.id.txtUserName);
        mTxtUserEmail = findViewById(R.id.txtUserEmail);
        mLv = findViewById(R.id.lv);
        txtEditProfileInfo = findViewById(R.id.txtEditProfileInfo);

        txtEditProfileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileInfo.this,EditProfileInfo.class);
                startActivity(intent);
            }
        });

        MenuList();

        mProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                if (intent != null) {

                    uri = intent.getData();
                    mProfileImage.setImageURI(uri);
                }
            }
        }

    }


    public void MenuList() {

        ArrayList<MenuItems> profileData = new ArrayList<>();

        profileData.add(new MenuItems(R.drawable.ic_user, getString(R.string.full_name)));
        profileData.add(new MenuItems(R.drawable.ic_email, getString(R.string.email_address)));
        profileData.add(new MenuItems(R.drawable.ic_mobile, getString(R.string.mobile_number)));
        profileData.add(new MenuItems(R.drawable.ic_logout, getString(R.string.logout)));

        CustomListAdapter adapt = new CustomListAdapter(this, R.layout.menu_list_item, profileData);

        mLv.setAdapter(adapt);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //edit name

                }
                if (i == 1) {
                    //edit email
                }
                if (i == 2) {
                    //edit mobile
                }
                if (i == 3) {
                    //logout
                }
            }
        });
    }

}
