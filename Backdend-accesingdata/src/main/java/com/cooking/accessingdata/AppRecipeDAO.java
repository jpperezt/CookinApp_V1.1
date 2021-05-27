package com.cooking.accessingdata;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppRecipeDAO {
 
    @Autowired
    private EntityManager entityManager;
 
    public Recipe findRecipe(String recipe_name) {
        try {
            String sql = "Select * from Cooking_Lab.RECIPE" + " e " //
                    + " Where e.recipe_name = :recipe_name ";
 
            Query query = entityManager.createQuery(sql, Recipe.class);
            query.setParameter("recipeName", recipe_name);
 
            return (Recipe) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
 
}

