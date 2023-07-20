package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText Title, Author, Pages;
    Button UpdateBtn;

    String id, title, author, pages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Title = findViewById(R.id.update_title_input);
        Author = findViewById(R.id.update_author_input);
        Pages = findViewById(R.id.update_number_of_pages);
        UpdateBtn = findViewById(R.id.update_button);

        getAndSetIntentData();

        UpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                title = Title.getText().toString().trim();
                author = Author.getText().toString().trim();
                pages = Pages.getText().toString().trim();
                myDB.UpdateData(id, title, author, pages);
            }
        });

    }
    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("author") && getIntent().hasExtra("pages")){
            // Getting Intent Data
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            // Setting Intent Data
            Title.setText(title);
            Author.setText(author);
            Pages.setText(pages);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}