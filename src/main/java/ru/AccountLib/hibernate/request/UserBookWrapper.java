package ru.AccountLib.hibernate.request;

import java.util.Date;

public class UserBookWrapper {
    private Date addDate;
    private String bookName;
    private String bookAuth;
    private String bookText;
    private int bookId;
    private int userId;

    public UserBookWrapper(Date addDate, String bookName, String bookAuth, String bookText, int bookId, int userId) {
        this.addDate = addDate;
        this.bookName = bookName;
        this.bookAuth = bookAuth;
        this.bookText = bookText;
        this.bookId = bookId;
        this.userId = userId;
    }

    public UserBookWrapper() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

        public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuth() {
        return bookAuth;
    }

    public void setBookAuth(String bookAuth) {
        this.bookAuth = bookAuth;
    }

    public String getBookText() {
        return bookText;
    }

    public void setBookText(String bookText) {
        this.bookText = bookText;
    }
}
