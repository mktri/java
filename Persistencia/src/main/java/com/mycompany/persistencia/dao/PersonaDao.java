/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistencia.dao;

import com.mycompany.persistencia.modelo.Persona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author dpalomar
 */
@Stateless
public class PersonaDao {

    @PersistenceContext(unitName = "com.mycompany_Persistencia_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public void nueva(Persona object) {
        em.persist(object);
    }

    public List<Persona> todas() {
        return em.createQuery("select p from Persona p", Persona.class).getResultList();
    }
}
