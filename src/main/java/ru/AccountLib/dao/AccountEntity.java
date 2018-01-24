package ru.AccountLib.dao;

import javax.persistence.*;

@Entity
@Table(name = "account", schema = "account")
public class AccountEntity {
    private int accountId;
    private String lastName;
    private String ferstName;
    private String email;
    private String registDate;

    @Id
    @Column(name = "accountId", nullable = false)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "ferstName", nullable = false, length = 45)
    public String getFerstName() {
        return ferstName;
    }

    public void setFerstName(String ferstName) {
        this.ferstName = ferstName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "registDate", nullable = true, length = 45)
    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (accountId != that.accountId) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (ferstName != null ? !ferstName.equals(that.ferstName) : that.ferstName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (registDate != null ? !registDate.equals(that.registDate) : that.registDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (ferstName != null ? ferstName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (registDate != null ? registDate.hashCode() : 0);
        return result;
    }
}
