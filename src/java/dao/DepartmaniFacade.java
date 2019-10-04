/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Departmani;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class DepartmaniFacade extends AbstractFacade<Departmani> implements DepartmaniFacadeLocal {

    @PersistenceContext(unitName = "ProjekatKI401PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmaniFacade() {
        super(Departmani.class);
    }
    
}
