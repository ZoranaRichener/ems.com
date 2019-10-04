/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Zaposleni;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface ZaposleniFacadeLocal {

    void create(Zaposleni zaposleni);

    void edit(Zaposleni zaposleni);

    void remove(Zaposleni zaposleni);

    Zaposleni find(Object id);

    List<Zaposleni> findAll();

    List<Zaposleni> findRange(int[] range);

    int count();
    
}
