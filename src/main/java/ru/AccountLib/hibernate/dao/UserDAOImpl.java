package ru.AccountLib.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.AccountLib.hibernate.dao.interfaceDAO.UserDAO;
import ru.AccountLib.hibernate.entity.BookEntity;
import ru.AccountLib.hibernate.entity.UserEntity;
import ru.AccountLib.hibernate.entity.UserLibEntity;
import ru.AccountLib.hibernate.utils.HibernateSessionFactory;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
//    private Session session;

//    public Session getSession() {
//        return session;
//    }

//    public void setSession(Session session) {
//        this.session = session;
//    }

    public void addUser(UserEntity userEntity) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(userEntity);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public UserEntity getUser(String log, String password) {
        Session session = null;
        List<UserEntity> list = new ArrayList<UserEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            Query query = session.createQuery("from UserEntity where log = :paramName and password = :paramPas");
            query.setParameter("paramName", log);
            query.setParameter("paramPas", password);
            list = query.list();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        if (list.isEmpty()){
            return null;
        }else {
            return list.get(0);
        }
    }
//    public void deleteUser(UserEntity userEntity) throws SQLException {
//        Session session = null;
//        try {
//            session = HibernateSessionFactory.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.delete(userEntity);
//            session.getTransaction().commit();
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()){
//                session.close();
//            }
//        }
//    }

    public void deleteUser(int userEntityId) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            UserEntity userEntity = session.get(UserEntity.class, userEntityId);
            session.delete(userEntity);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public void editUser(int userEntityId, String log, String password, String gender, String role) throws SQLException {
        UserEntity userEntity = this.getUser(userEntityId);
        userEntity.setPassword(password);
        userEntity.setLog(log);
        userEntity.setId(userEntityId);
        userEntity.setGender(gender);
        userEntity.setRole(role);
        this.addUser(userEntity);
    }

    public UserEntity getUser(int userEntityId) {
        Session session = null;
        UserEntity user = new UserEntity();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            user = session.get(UserEntity.class, userEntityId);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return user;
    }

    public List getAllUsers() throws SQLException {
        Session session = null;
        List<UserEntity> users = new ArrayList<UserEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            users = session.createCriteria(UserEntity.class).list();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return users;
    }

    @Override
    public Set<BookEntity> getBookForUser(int userEntityId) {
        Session session = null;
//        BookEntity book = new BookEntity();
        Set<BookEntity> books = new HashSet<BookEntity>();
        UserEntity userEntity = new UserEntity();
        Set<UserLibEntity> userLibs = new HashSet<UserLibEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            userEntity = session.get(UserEntity.class, userEntityId);
            userLibs = userEntity.getUserLibs();
            for (UserLibEntity userLib : userLibs) {
                books.add(userLib.getBookEntity());
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return books;
    }

    public Set<UserLibEntity> getUserLibs(int userEntityId){
        Session session = null;
        Set<UserLibEntity> userLibs = new HashSet<UserLibEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            UserEntity userEntity = session.get(UserEntity.class, userEntityId);
            userLibs = userEntity.getUserLibs();
        } catch (Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return userLibs;
    }
}
