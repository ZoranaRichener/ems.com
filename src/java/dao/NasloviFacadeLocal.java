/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Naslovi;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface NasloviFacadeLocal {

    void create(Naslovi naslovi);

    void edit(Naslovi naslovi);

    void remove(Naslovi naslovi);

    Naslovi find(Object id);

    List<Naslovi> findAll();

    List<Naslovi> findRange(int[] range);

    int count();
    
}
