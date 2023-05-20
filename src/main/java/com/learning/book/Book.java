package com.learning.book;

public class Book {
    private String title;
    private int Id;
    private String author;
    public Book(String title, int Id, String author){
        this.title = title;
        this.Id = Id;
        this.author = author;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setId(int Id){
        this.Id = Id;
    }

    public int getId(){
       return  this.Id;
    }
}
