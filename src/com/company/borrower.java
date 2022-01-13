package com.company;

public class borrower {
    private String username;
    private String borrowedbook;


    public borrower(String username, String borrowedbook){
        this.username = username;
        this.borrowedbook = borrowedbook;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBorrowedbook() {
        return borrowedbook;
    }

    public void setBorrowedbook(String borrowedbook) {
        this.borrowedbook = borrowedbook;
    }
}
