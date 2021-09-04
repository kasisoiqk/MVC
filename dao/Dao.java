/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New.dao;

import java.util.List;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public interface Dao<P>{
    List<P> getAll();
    Object get(int id);
    boolean insert(P p);
    boolean update(P p);
    boolean delete(P p);
    boolean delete(int id);
    List<P> search(P p);
}
