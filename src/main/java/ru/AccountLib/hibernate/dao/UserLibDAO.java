package ru.AccountLib.hibernate.dao;

import ru.AccountLib.hibernate.entity.UserLibEntity;

import java.util.List;

public interface UserLibDAO {
    public List<UserLibEntity> findAll();
}
