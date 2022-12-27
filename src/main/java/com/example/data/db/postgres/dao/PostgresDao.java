package com.example.data.db.postgres.dao;

import com.example.data.general.dao.AbstractDao;
import com.example.data.model.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class PostgresDao<T extends AbstractEntity, I> extends AbstractDao<T, I> {

    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostgresDao(EntityManagerFactory emf, Class<T> clazz) {
        super(clazz);
        this.emf = emf;
    }

    @Override
    public T create(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    @Override
    public T read(I id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(this);
        T t = em.find(clazz, id);
        em.close();
        return t;
    }

    @Override
    public T update(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    @Override
    public boolean delete(I id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T t = em.find(clazz, id);
        em.remove(t);
        em.getTransaction().commit();
        return true;
    }
}
