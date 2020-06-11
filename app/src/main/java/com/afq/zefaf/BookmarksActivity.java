package com.afq.zefaf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.afq.zefaf.Adapter.BookmarksAdapter;
import com.afq.zefaf.Model.Bookmark;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookmarksActivity extends AppCompatActivity {


    private ArrayList<Bookmark> mExampleList;

    private RecyclerView mBookmarksRecyclerView;
    private BookmarksAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ZEFAF");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        createExampleList();
        buildRecyclerView();

    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }


    public void createExampleList() {

        mExampleList = new ArrayList<>();


        mExampleList.add(new Bookmark(R.drawable.pic, "venue 1", "address", "4"));
        mExampleList.add(new Bookmark(R.drawable.pic, "venue 2", "address", "4"));
        mExampleList.add(new Bookmark(R.drawable.pic, "venue 3", "address", "4"));

        myRef.child("Bookmark").push().setValue(new Bookmark(R.drawable.pic, "venue 1", "address", "4"));

        myRef.child("Bookmark").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(BookmarksActivity.this, "added", Toast.LENGTH_SHORT).show();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {

                    Bookmark bkm =  snap.getValue(Bookmark.class);

                    if (bkm != null) {

                        String VenueName = bkm.getVenueName();
                        String VenueAddress = bkm.getVenueAddress();
//                      bkm.getVenuePic();
                        String VenueRating = bkm.getVenueRating();

                        mExampleList.add(new Bookmark(R.drawable.pic, VenueName, VenueAddress, VenueRating));


                    }
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    public void buildRecyclerView() {
        mBookmarksRecyclerView = findViewById(R.id.bookmarksRecyclerView);
        mBookmarksRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BookmarksAdapter(mExampleList);
        mBookmarksRecyclerView.setLayoutManager(mLayoutManager);
        mBookmarksRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BookmarksAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(BookmarksActivity.this, HajsALan.class);
                startActivity(intent);
            }

            @Override
            public void onBookmarkClick(int position) {
                removeItem(position);
            }
        });
    }
}
