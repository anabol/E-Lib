package ru.AccountLib.hibernate.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "account")
public class UserEntity {
     private int id;
     private String log;
     private String password;

     public UserEntity(){
     }

     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
     @GeneratedValue(generator = "increment")
     @GenericGenerator(name = "increment", strategy = "increment")
     @Column(name = "id")
     public int getId() {
          return id;
     }

    public void setId(int userId) {
          this.id = userId;
    }

    @Column(name = "log")
    public String getLog() {
          return log;
    }

    public void setLog(String log) {
          this.log = log;
    }

    @Column(name = "password")
    public String getPassword() {
          return password;
     }

    public void setPassword(String password) {
          this.password = password;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (log != null ? !log.equals(that.log) : that.log != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (log != null ? log.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User" +
                "id=" + id +
                ", log='" + log + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
