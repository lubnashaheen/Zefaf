package com.afq.zefaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.afq.zefaf.Adapter.CustomListAdapter;
import com.afq.zefaf.Model.MenuItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TextView txtUserName;
    private TextView txtUserEmail;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        txtUserName = findViewById(R.id.txtUserName);
        txtUserEmail = findViewById(R.id.txtUserEmail);

        LinearLayout profileInfo = findViewById(R.id.profileInfo);

        profileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent intent = new Intent(MainActivity.this,ProfileInfo.class);
                startActivity(intent);*/
            }
        });

        MenuList();
    }

    public void MenuList(){


        ArrayList<MenuItems> data = new ArrayList<>();

        data.add(new MenuItems(R.drawable.ic_bookmarks,getString(R.string.bookmarks)));
        data.add(new MenuItems(R.drawable.ic_calender,getString(R.string.reservations)));
        data.add(new MenuItems(R.drawable.ic_credit_card,getString(R.string.credit_card)));
        data.add(new MenuItems(R.drawable.ic_language,getString(R.string.language)));
        data.add(new MenuItems(R.drawable.ic_terms,getString(R.string.terms_of_service)));
        data.add(new MenuItems(R.drawable.ic_policy,getString(R.string.privacy_policy)));
        data.add(new MenuItems(R.drawable.ic_help_center,getString(R.string.help_center)));
        data.add(new MenuItems(R.drawable.ic_info,getString(R.string.about_us)));

        CustomListAdapter adapt = new CustomListAdapter(this, R.layout.menu_list_item, data);

        lv.setAdapter(adapt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if (i == 0) {
//                    Intent intent = new Intent(MainActivity.this, EditProfile.class);
//                    startActivity(intent);
//                }
//                if (i == 1) {
//                    Intent intent = new Intent(Account.this, About.class);
//                    startActivity(intent);
//                }
            }
        });
    }

}
