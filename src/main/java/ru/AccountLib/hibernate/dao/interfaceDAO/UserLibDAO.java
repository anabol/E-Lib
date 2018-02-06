package ru.AccountLib.hibernate.dao.interfaceDAO;

import ru.AccountLib.hibernate.entity.UserLibEntity;

import java.util.List;

public interface UserLibDAO {
    public List<UserLibEntity> findAll();
    boolean addBookInUserLib(int bookId, int userId);
    void deleteUserBook(int userId, int bookId);
}
