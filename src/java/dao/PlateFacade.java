/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Plate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class PlateFacade extends AbstractFacade<Plate> implements PlateFacadeLocal {

    @PersistenceContext(unitName = "ProjekatKI401PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlateFacade() {
        super(Plate.class);
    }
    
}
