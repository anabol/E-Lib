package ru.AccountLib.hibernate.dao;

public class Factory {
    private static UserDAO userDAO = null;
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
}
