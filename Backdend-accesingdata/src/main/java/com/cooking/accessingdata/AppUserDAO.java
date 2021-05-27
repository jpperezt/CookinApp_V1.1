package com.cooking.accessingdata;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppUserDAO {
 
    @Autowired
    private EntityManager entityManager;
 
    public User findUserAccount(String user_name) {
        try {
            String sql = "Select * from Cooking_Lab.USER_APP" + " e " //
                    + " Where e.user_name = :user_name ";
 
            Query query = entityManager.createQuery(sql, User.class);
            query.setParameter("userName", user_name);
 
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
 
}
