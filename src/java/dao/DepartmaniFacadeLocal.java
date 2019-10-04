/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Departmani;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface DepartmaniFacadeLocal {

    void create(Departmani departmani);

    void edit(Departmani departmani);

    void remove(Departmani departmani);

    Departmani find(Object id);

    List<Departmani> findAll();

    List<Departmani> findRange(int[] range);

    int count();
    
}
