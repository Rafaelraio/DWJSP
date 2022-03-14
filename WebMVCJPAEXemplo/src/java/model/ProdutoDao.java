/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.Produto;
import javax.persistence.EntityTransaction;

/**
 *
 * @author alkaw
 */


public class ProdutoDao extends GenericDao<entidades.Produto, Long> {
    public ProdutoDao() {
       super(entidades.Produto.class);
    }   
    
    public Produto salvar(String n, Integer q, Float p) { 
       Produto prod = new Produto(n, q, p);
       EntityTransaction t = entityManager.getTransaction();
       t.begin();
      
       entityManager.persist(prod);
       entityManager.flush();
       t.commit();
       return prod;
   }
}