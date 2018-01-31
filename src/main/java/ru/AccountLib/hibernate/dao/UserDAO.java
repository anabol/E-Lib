package ru.AccountLib.hibernate.dao;

import ru.AccountLib.hibernate.entity.UserEntity;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public void addUser(UserEntity userEntity) throws SQLException;
    public void deleteUser(int userEntityId) throws SQLException;
//    public void deleteUser(UserEntity userEntity) throws SQLException;
    public List getAllUsers() throws SQLException;
    public UserEntity getUser(int UserEntityId);
    public void editUser(int UserEntityId, String log, String password)throws SQLException;
    public UserEntity getUser(String log, String password);
}
