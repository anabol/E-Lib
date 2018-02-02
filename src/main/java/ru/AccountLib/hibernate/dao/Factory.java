package ru.AccountLib.hibernate.dao;

public class Factory {
    private static UserDAO userDAO = null;
    private static BookDAO bookDAO = null;
    private static UserLibDAO userLibDAO = null;
    private static TableNameDAO tableNameDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public static UserDAO getUserDAO() {
        if (userDAO == null){
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    public static BookDAO getBookDAO() {
        if (bookDAO == null){
            bookDAO = new BookDAOImpl();
        }
        return bookDAO;
    }
    public static UserLibDAO getUserLibDAO() {
        if (userLibDAO == null) {
            userLibDAO = new UserLibDAOImpl();
        }
        return userLibDAO;
    }

    public static TableNameDAO getTableNameDAO() {
        if (tableNameDAO == null){
            tableNameDAO = new TableNameDAOImpl();
        }
        return tableNameDAO;
    }
}
