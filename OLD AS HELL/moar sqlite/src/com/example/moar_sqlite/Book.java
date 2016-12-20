package com.example.moar_sqlite;

/**
 * Created by Sam on 2/3/2015.
 */
public class Book {

    private int id;
    private String title;
    private String author;

    public Book(){}

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    //getters & setters

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author
                + "]";
    }
}
