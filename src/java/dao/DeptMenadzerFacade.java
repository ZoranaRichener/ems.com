/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.DeptMenadzer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class DeptMenadzerFacade extends AbstractFacade<DeptMenadzer> implements DeptMenadzerFacadeLocal {

    @PersistenceContext(unitName = "ProjekatKI401PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeptMenadzerFacade() {
        super(DeptMenadzer.class);
    }
    
}