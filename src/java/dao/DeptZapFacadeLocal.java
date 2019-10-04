/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.DeptZap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface DeptZapFacadeLocal {

    void create(DeptZap deptZap);

    void edit(DeptZap deptZap);

    void remove(DeptZap deptZap);

    DeptZap find(Object id);

    List<DeptZap> findAll();

    List<DeptZap> findRange(int[] range);

    int count();
    
}
