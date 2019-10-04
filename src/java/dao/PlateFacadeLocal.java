/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Plate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface PlateFacadeLocal {

    void create(Plate plate);

    void edit(Plate plate);

    void remove(Plate plate);

    Plate find(Object id);

    List<Plate> findAll();

    List<Plate> findRange(int[] range);

    int count();
    
}
