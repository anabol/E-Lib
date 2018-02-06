package ru.AccountLib.hibernate.dao.interfaceDAO;

import org.hibernate.Session;
import ru.AccountLib.hibernate.entity.BookEntity;
import ru.AccountLib.hibernate.entity.UserEntity;
import ru.AccountLib.hibernate.entity.UserLibEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface UserDAO {
    public void addUser(UserEntity userEntity) throws SQLException;
    public void deleteUser(int userEntityId) throws SQLException;
//    public void deleteUser(UserEntity userEntity) throws SQLException;
    public List getAllUsers() throws SQLException;
    public UserEntity getUser(int UserEntityId);
    public void editUser(int UserEntityId, String log, String password, String gender, String role)throws SQLException;
    public UserEntity getUser(String log, String password);
    Set<BookEntity> getBookForUser(int userEntityId);
    Set<UserLibEntity> getUserLibs(int userEntityId);
//    void setSession(Session session);
}
