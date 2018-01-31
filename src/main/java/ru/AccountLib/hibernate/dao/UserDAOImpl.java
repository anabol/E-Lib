package ru.AccountLib.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.AccountLib.hibernate.entity.UserEntity;
import ru.AccountLib.hibernate.utils.HibernateSessionFactory;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
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

    public void editUser(int userEntityId, String log, String password) throws SQLException {
        UserEntity userEntity = this.getUser(userEntityId);
        userEntity.setPassword(password);
        userEntity.setLog(log);
        userEntity.setId(userEntityId);
        this.addUser(userEntity);
    }

    public UserEntity getUser(int UserEntityId) {
        Session session = null;
        UserEntity user = new UserEntity();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            user = session.get(UserEntity.class, UserEntityId);
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
}
