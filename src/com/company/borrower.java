package com.company;

public class borrower {
    private String username;
    private String password;
    private boolean employee;


    public borrower(String username, String password, boolean employee){
        this.username = username;
        this.password = password;
        this.employee = employee;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBorrowedbook() {
        return password;
    }

    public void setBorrowedbook(String borrowedbook) {
        this.password = borrowedbook;
    }

    public boolean isEmployee() {
        return employee;
    }

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }
}
