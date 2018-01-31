package ru.AccountLib.hibernate.main;

import ru.AccountLib.hibernate.dao.*;
import ru.AccountLib.hibernate.entity.BookEntity;

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
//        List<UserEntity> users = Factory.getInstance().getUserDAO().getAllUsers();
//        System.out.println("All USERS!!!!");
//        for (int i = 0; i <= users.size(); i++){
//            System.out.println("Имя:" + users.get(i).getLog() + ", Password:" + users.get(i).getPassword() + ", ID:" + users.get(i).getId());
//        }

        List<BookEntity> books = Factory.getInstance().getBookDAO().getAllBooks();
        Iterator iterator = books.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}