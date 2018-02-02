package ru.AccountLib.hibernate.dao;

import org.hibernate.Session;
import ru.AccountLib.hibernate.entity.UserEntity;
import ru.AccountLib.hibernate.entity.UserLibEntity;
import ru.AccountLib.hibernate.utils.HibernateSessionFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserLibDAOImpl implements UserLibDAO{
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
}
