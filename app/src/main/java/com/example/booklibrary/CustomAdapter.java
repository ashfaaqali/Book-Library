package com.example.booklibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList bookID, bookTitle, bookAuthor, bookPages;

    CustomAdapter(
            Context context,
            ArrayList bookID,
            ArrayList bookTitle,
            ArrayList bookAuthor,
            ArrayList bookPages){

        this.context = context;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;

    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.BookID.setText(String.valueOf(bookID.get(position)));
        holder.BookTitle.setText(String.valueOf(bookTitle.get(position)));
        holder.BookAuthor.setText(String.valueOf(bookAuthor.get(position)));
        holder.BookPages.setText(String.valueOf(bookPages.get(position)));
    }

    @Override
    public int getItemCount() {
        return bookID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView BookID, BookTitle, BookAuthor, BookPages;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            BookID = itemView.findViewById(R.id.id);
            BookTitle = itemView.findViewById(R.id.title);
            BookAuthor = itemView.findViewById(R.id.author);
            BookPages = itemView.findViewById(R.id.pages);
        }
    }
}
