package com.example.database_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import org.w3c.dom.Comment;

import java.util.List;
import java.util.Random;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setContentView(R.layout.main);

        MySQLiteHelper db = new MySQLiteHelper(this);

        /**
         * CRUD Operations
         * */
        // add Books
        db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));
        db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));
        db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));

        // get all books
        List<Book> list = db.getAllBooks();

        // delete one book
        db.deleteBook(list.get(0));

        // get all books
        db.getAllBooks();

    }

}