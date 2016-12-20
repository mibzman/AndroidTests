package com.example.database_test;

/**
 * Created by Sam on 4/17/14.
 */
public class Book {

    //private int id;
    private String title;
    private String author;

    public Book(){}

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    //getters & setters

    private long id;
    private String comment;

    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String comment) {
        this.comment = comment;
    }

    public void setTitle(String comment) {
        this.comment = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return comment;
    }
}