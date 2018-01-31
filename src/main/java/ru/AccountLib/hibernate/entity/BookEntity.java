package ru.AccountLib.hibernate.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book", schema = "account")
public class BookEntity {
    private int bookId;
    private String bookName;
    private String bookAuth;
    private byte[] bookText;

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "book_name", nullable = false, length = 20)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "book_auth", nullable = false, length = 20)
    public String getBookAuth() {
        return bookAuth;
    }

    public void setBookAuth(String bookAuth) {
        this.bookAuth = bookAuth;
    }

    @Basic
    @Column(name = "book-text", nullable = true)
    public byte[] getBookText() {
        return bookText;
    }

    public void setBookText(byte[] bookText) {
        this.bookText = bookText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (bookId != that.bookId) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;
        if (bookAuth != null ? !bookAuth.equals(that.bookAuth) : that.bookAuth != null) return false;
        if (!Arrays.equals(bookText, that.bookText)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (bookAuth != null ? bookAuth.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(bookText);
        return result;
    }

    private Set<UserLibEntity> userLibs = new HashSet<UserLibEntity>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<UserLibEntity> getUserLibs() {
        return userLibs;
    }

    public void setUserLibs(Set<UserLibEntity> userLibs) {
        this.userLibs = userLibs;
    }

    public void addUserLib(UserLibEntity userLibEntity){
        userLibEntity.setBook(this);
        getUserLibs().add(userLibEntity);
    }

    public void removeUserLib(UserLibEntity userLibEntity){
        getUserLibs().remove(userLibEntity);
    }
}
