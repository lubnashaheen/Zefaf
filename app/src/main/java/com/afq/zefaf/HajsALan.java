package com.afq.zefaf;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HajsALan extends AppCompatActivity {


    private ImageView imgVenueImage;
    private ImageView imgBookmark;
    private TextView txtVenueRating;
    private TextView txtVenueAddress;
    private TextView txtVenueDescription;
    private Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hajsalan);

        imgVenueImage = findViewById(R.id.imgVenueImage);
        imgBookmark = findViewById(R.id.imgBookmark);
        txtVenueRating = findViewById(R.id.txtVenueRating);
        txtVenueAddress = findViewById(R.id.txtVenueAddress);
        txtVenueDescription = findViewById(R.id.txtVenueDescription);
        btnBook = findViewById(R.id.btnBook);

        imgBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
