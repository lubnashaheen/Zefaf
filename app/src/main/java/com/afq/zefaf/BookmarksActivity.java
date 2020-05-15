package com.afq.zefaf;

import android.content.Intent;
import android.os.Bundle;

import com.afq.zefaf.Adapter.BookmarksAdapter;
import com.afq.zefaf.Model.Bookmarks;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookmarksActivity extends AppCompatActivity {


    private ArrayList<Bookmarks> mExampleList;

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

    public void firebase() {
        
    }


    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }


    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new Bookmarks(R.drawable.pic, "venue 1", "address", "4", true));
        mExampleList.add(new Bookmarks(R.drawable.pic, "venue 2", "address", "4", true));
        mExampleList.add(new Bookmarks(R.drawable.pic, "venue 3", "address", "4", true));
        mExampleList.add(new Bookmarks(R.drawable.pic, "venue 4", "address", "4", true));
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
