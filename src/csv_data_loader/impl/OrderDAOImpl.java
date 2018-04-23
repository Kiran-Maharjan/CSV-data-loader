/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader.impl;

import csv_data_loader.dao.OrderDAO;
import csv_data_loader.enties.Order;
import java.util.ArrayList;
import java.util.List;


public class OrderDAOImpl implements OrderDAO {
    List<Order> lst=new ArrayList<>();
    
    @Override
    public List<Order> getAll() {
        return lst;
    }

    @Override
    public Order getById(int id) {
       
        for(Order p:lst){
          if(p.getId()==id){
              return p;
          }  
        }
       return null;
    }

    @Override
    public boolean insert(Order p) {
        return lst.add(p);
        
    }
    
}
