package com.afq.zefaf.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afq.zefaf.Model.Bookmarks;
import com.afq.zefaf.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.BookmarkViewHolder> {
    ArrayList<Bookmarks> bookmarks = new ArrayList<>();
    OnItemClickListener listener;


    public interface OnItemClickListener {
        void OnItemClick(int position);

        void onBookmarkClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public BookmarksAdapter(ArrayList<Bookmarks> bookmarks) {
        this.bookmarks = bookmarks;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_bookmark, parent, false);
        BookmarkViewHolder holder = new BookmarkViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        Bookmarks bm = bookmarks.get(position);
        //set yo shit
        holder.mImgVenueImage.setImageResource(bm.getVenuePic());
        holder.mTextView9.setText(bm.getVenueRating());
        holder.mTxtVenueAddress.setText(bm.getVenueAddress());
        holder.mTxtVenueName.setText(bm.getVenueName());

    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    public static class BookmarkViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImgVenueImage;
        public ImageView mBookmarkImage;
        public TextView mTxtVenueName;
        public TextView mTextView9;
        public TextView mTxtVenueAddress;

        public BookmarkViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            mImgVenueImage = itemView.findViewById(R.id.imgVenueImage);
            mTxtVenueName = itemView.findViewById(R.id.txtVenueName);
            mTextView9 = itemView.findViewById(R.id.textView9);
            mTxtVenueAddress = itemView.findViewById(R.id.txtVenueAddress);
            mBookmarkImage = itemView.findViewById(R.id.imageView13);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
            mBookmarkImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onBookmarkClick(position);
                        }
                    }
                }
            });

        }
    }
}
