package ru.AccountLib.main;

import org.hibernate.Session;
import ru.AccountLib.dao.Factory;
import ru.AccountLib.dao.UserEntity;
import ru.AccountLib.utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class AppMain {

    public static void main(String[] args) throws SQLException {
//        System.out.println("Hibernate tutorial");
//
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//
//        session.beginTransaction();
//
////        AccountEntity accountEntity = new AccountEntity();
////
////
////        accountEntity.setAccountId(20);
////        accountEntity.setFerstName("Petr");
////        accountEntity.setLastName("Artym");
////        accountEntity.setEmail("zachita@mail.РФ");
////        accountEntity.setRegistDate("28-38-3018");
////
////        session.save(accountEntity);
////        session.merge(accountEntity);
//        UserEntity userEntity = new UserEntity();
//
////        userEntity.setId(6);
//        userEntity.setLog("fghjkl");
//        userEntity.setPassword("1234");
//
//        session.save(userEntity);
//
//        session.getTransaction().commit();
//
//        session.close();
//
////        UserEntity user1 = new UserEntity();
////        UserEntity user2 = new UserEntity();
////
////        user1.setLog("max");
////        user2.setLog("Petr");
////        user1.setPassword("555");
////        user2.setPassword("777");
////
////        Factory.getInstance().getUserDAO().addUser(user1);
////        Factory.getInstance().getUserDAO().addUser(user2);
////
////        List<UserEntity> users = Factory.getInstance().getUserDAO().getAllUsers();
////        System.out.println("All USERS!!!!");
////        for (int i = 0; i <= users.size(); i++){
////            System.out.println("Имя:" + users.get(i).getLog() + ", Password:" + users.get(i).getPassword() + ", ID:" + users.get(i).getId());
////        }
        List<UserEntity> users = Factory.getInstance().getUserDAO().getUser("Max", "123");
        Iterator<UserEntity> iterator = users.iterator();
        UserEntity userEntity = new UserEntity();
        while (iterator.hasNext()){
            userEntity = iterator.next();
            System.out.println(userEntity.getLog() + ' ' + userEntity.getPassword() + ' ' + userEntity.getRole());
        }
        System.out.println("!!!!!!" + users.get(0).getLog() + ' ' + users.get(0).getPassword());
    }
}