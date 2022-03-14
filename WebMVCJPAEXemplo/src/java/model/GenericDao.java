/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author alkaw
 * @param <T>
 * @param <I>
 */
public abstract class GenericDao<T, I extends Serializable> {

   //@Inject
   protected EntityManager entityManager;

   private Class<T> persistedClass;

   protected GenericDao() {
   }

   protected GenericDao(Class<T> persistedClass) {
       this();
       this.persistedClass = persistedClass;
       
       if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("WebMVCJPAEXemploPU").createEntityManager();
        }
   }

   //public T salvar(@Valid T entity) {
   public T salvar(T entity) {    
       EntityTransaction t = entityManager.getTransaction();
       t.begin();
       entityManager.persist(entity);
       entityManager.flush();
       t.commit();
       return entity;
   }

   //public T atualizar(@Valid T entity) {
      public T atualizar(T entity) {
       EntityTransaction t = entityManager.getTransaction();
       t.begin();
       entityManager.merge(entity);
       entityManager.flush();
       t.commit();
       return entity;
   }

   public void remover(I id) {
       T entity = encontrar(id);
       EntityTransaction tx = entityManager.getTransaction();
       tx.begin();
       T mergedEntity = entityManager.merge(entity);
       entityManager.remove(mergedEntity);
       entityManager.flush();
       tx.commit();
   }

   public List<T> getList() {
       CriteriaBuilder builder = entityManager.getCriteriaBuilder();
       CriteriaQuery<T> query = builder.createQuery(persistedClass);
       query.from(persistedClass);
       return entityManager.createQuery(query).getResultList();
   }

   public T encontrar(I id) {
       return entityManager.find(persistedClass, id);
   }
}