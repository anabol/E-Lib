package ru.AccountLib.hibernate.main;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.proxy.HibernateProxy;
import ru.AccountLib.hibernate.dao.*;
import ru.AccountLib.hibernate.entity.BookEntity;
import ru.AccountLib.hibernate.entity.TableNameEntity;
import ru.AccountLib.hibernate.entity.UserEntity;
import ru.AccountLib.hibernate.entity.UserLibEntity;
import ru.AccountLib.hibernate.utils.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.xml.ws.FaultAction;
import java.sql.SQLException;
import java.util.*;

public class AppMain {

//    @PersistenceUnit
//    static EntityManager emf;

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

//        List<BookEntity> books = Factory.getInstance().getBookDAO().getAllBooks();
//        Iterator iterator = books.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next().toString());
//        }
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        UserDAO userDAO = new UserDAOImpl();
//        userDAO.setSession(session);
//        Transaction tx = session.beginTransaction();
//
//        UserEntity userEntity = userDAO.getUser(1);
//
//        Set<UserLibEntity> userLibs = userEntity.getUserLibs();
//
//        for (UserLibEntity userLib: userLibs) {
//            System.out.println(userLib.getBook());
//        }
//
//        tx.commit();
//        session.close();
//        UserEntity user = Factory.getInstance().getUserDAO().getUser(1);
//        Set<UserLibEntity> userLibs = user.getUserLibs();

//        Set<BookEntity> books = Factory.getInstance().getUserDAO().getBookForUser(1);
////        Set<UserLibEntity> userLibs = user.getUserLibs();
//        for (BookEntity book : books){
//            System.out.println(book);
//        }
//        BookEntity bookEntity = Factory.getInstance().getBookDAO().getBook(1);
//        UserEntity userEntity = Factory.getInstance().getUserDAO().getUser(2);
//        boolean result = Factory.getInstance().getUserLibDAO().addBookInUserLib(1, 9);
//        List<UserLibEntity> userLibEntities = Factory.getInstance().getUserLibDAO().findAll();
//        System.out.println(result);
//
//        for (UserLibEntity userLib : userLibEntities){
//            System.out.println(userLib);
//        }

//        List<UserEntity> users = Factory.getInstance().getUserDAO().getAllUsers();
//        for (UserEntity user: users
//             ) {
//            System.out.println(user);
//        }

//        List<BookEntity> books = Factory.getInstance().getBookDAO().getAllBooks();
//        for (BookEntity book : books
//             ) {
//            System.out.println(book);
//        }

//        Factory.getInstance().getTableNameDAO().addObj(73, 88);
//        List<TableNameEntity> tables = Factory.getInstance().getTableNameDAO().getAllTableName();
//        for (TableNameEntity table : tables){
//            System.out.println(table);
//        }

//        BookEntity book = Factory.getInstance().getBookDAO().getBook(1);
//        System.out.println(
//                book
//        );
//        Set<UserLibEntity> userLibs = Factory.getUserDAO().getUserLibs(1);
//        for (UserLibEntity userLibEntity : userLibs){
//            System.out.println(userLibEntity.getAddDate());
//        }

//        Factory.getInstance().getUserLibDAO().deleteUserBook(2, 1);
        int bookId = 4;
        String bookText = "789";
        Factory.getInstance().getBookDAO().updateTextBook(bookId, bookText);
    }
}