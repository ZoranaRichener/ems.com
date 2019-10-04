/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.DeptZap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class DeptZapFacade extends AbstractFacade<DeptZap> {

    @PersistenceContext(unitName = "ProjekatKI401PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeptZapFacade() {
        super(DeptZap.class);
    }
    
}
