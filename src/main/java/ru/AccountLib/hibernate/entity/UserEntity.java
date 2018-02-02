package ru.AccountLib.hibernate.entity;

import javax.persistence.*;
//import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "account")
public class UserEntity implements Serializable{
    private int id;
    private String password;
    private String log;
    private String role;
    private String gender;

    public UserEntity() {
    }

    public UserEntity(String password, String log, String gender) {
        this.password = password;
        this.log = log;
        this.gender = gender;
        this.role = "USER";
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "log", nullable = false, length = 20)
    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 20)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (log != null ? !log.equals(that.log) : that.log != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (log != null ? log.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    private Set<UserLibEntity> userLibs = new HashSet<UserLibEntity>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<UserLibEntity> getUserLibs() {
        return userLibs;
    }

    public void setUserLibs(Set<UserLibEntity> userLibs) {
        this.userLibs = userLibs;
    }

    public void addUserLib(UserLibEntity userLibEntity){
        userLibEntity.setUser(this);
        getUserLibs().add(userLibEntity);
    }

    public void removeUserLib(UserLibEntity userLibEntity){
        getUserLibs().remove(userLibEntity);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", log='" + log + '\'' +
                ", role='" + role + '\'' +
                ", gender='" + gender + '\'' +
//                ", userLibs=" + userLibs +
                '}';
    }
}
