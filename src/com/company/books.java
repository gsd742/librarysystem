package com.company;

public class books {
    private String booktitle ;
    private int isbn;
    private String author;
    private String genre;

    public books(String booktitle, int isbn, String author, String genre) {
        this.booktitle = booktitle;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
