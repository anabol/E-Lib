package ru.AccountLib.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.AccountLib.hibernate.dao.interfaceDAO.UserLibDAO;
import ru.AccountLib.hibernate.entity.BookEntity;
import ru.AccountLib.hibernate.entity.UserEntity;
import ru.AccountLib.hibernate.entity.UserLibEntity;
import ru.AccountLib.hibernate.utils.HibernateSessionFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserLibDAOImpl implements UserLibDAO {
    @Override
    public boolean addBookInUserLib(int bookId, int userId) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            Query query = session.createQuery("from UserLibEntity where user = :paramUser and bookEntity = :paramBook");
            UserEntity userEntity = session.get(UserEntity.class, userId);
            BookEntity bookEntity = session.get(BookEntity.class, bookId);
            query.setParameter("paramUser", userEntity);
            query.setParameter("paramBook", bookEntity);
            List list = query.list();
            if (list.isEmpty()){
                UserLibEntity userLibEntity = new UserLibEntity(userEntity, bookEntity);
                session.beginTransaction();
                session.persist(userLibEntity);
                session.getTransaction().commit();
                return true;
            } else{
                return false;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            return false;
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public List<UserLibEntity> findAll() {
        Session session = null;
        List<UserLibEntity> userLibs = new ArrayList<UserLibEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            userLibs = session.createCriteria(UserLibEntity.class).list();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return userLibs;
    }

    @Override
    public void deleteUserBook(int userId, int bookId) {
        Session session = null;
        UserEntity userEntity = new UserEntity();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            userEntity = session.get(UserEntity.class, userId);
            BookEntity bookEntity = session.get(BookEntity.class, bookId);

            Query query =  session.createQuery("delete UserLibEntity where user = :paramUser " +
                    "and bookEntity = :paramBook");
            query.setParameter("paramUser", userEntity);
            query.setParameter("paramBook", bookEntity);
            int result = query.executeUpdate();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
