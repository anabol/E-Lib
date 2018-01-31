package ru.AccountLib.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_lib", schema = "account")
public class UserLibEntity {
    private int id;
    private Date addDate;
//    private BookEntity bookByBookId;
//    private UserEntity userByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "add_date", nullable = true, insertable = true, updatable = true)
    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        UserLibEntity that = (UserLibEntity) o;
//
//        if (id != that.id) return false;
//        if (addDate != null ? !addDate.equals(that.addDate) : that.addDate != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (addDate != null ? addDate.hashCode() : 0);
//        return result;
//    }

//    @ManyToOne
//    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
//    public BookEntity getBookByBookId() {
//        return bookByBookId;
//    }
//
//    public void setBookByBookId(BookEntity bookByBookId) {
//        this.bookByBookId = bookByBookId;
//    }

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    public UserEntity getUserByUserId() {
//        return userByUserId;
//    }
//
//    public void setUserByUserId(UserEntity userByUserId) {
//        this.userByUserId = userByUserId;
//    }
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }

    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "book_id")
    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLibEntity that = (UserLibEntity) o;

        if (id != that.id) return false;
        if (addDate != null ? !addDate.equals(that.addDate) : that.addDate != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return book != null ? book.equals(that.book) : that.book == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (addDate != null ? addDate.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserLibEntity{" +
                "id=" + id +
                ", addDate=" + addDate +
                ", user=" + user +
                ", book=" + book +
                ", book id=" + getBook().getBookId() +
                ", user id=" + getUser().getId() +
                '}';
    }
}
