/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.DeptMenadzer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface DeptMenadzerFacadeLocal {

    void create(DeptMenadzer deptMenadzer);

    void edit(DeptMenadzer deptMenadzer);

    void remove(DeptMenadzer deptMenadzer);

    DeptMenadzer find(Object id);

    List<DeptMenadzer> findAll();

    List<DeptMenadzer> findRange(int[] range);

    int count();
    
}
