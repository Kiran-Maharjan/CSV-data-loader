/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader.dao;

import java.util.List;

/**
 *
 * @author kiran
 */
public interface GenericDAO<T> {

    List<T> getAll();

    T getById(int id);

    boolean insert(T t);
}
