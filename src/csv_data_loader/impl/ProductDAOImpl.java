/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader.impl;

import csv_data_loader.dao.ProductDAO;
import csv_data_loader.enties.Product;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOImpl implements ProductDAO {
    List<Product> lst=new ArrayList<>();
    
    @Override
    public List<Product> getAll() {
        return lst;
    }

    @Override
    public Product getById(int id) {
       
        for(Product p:lst){
          if(p.getId()==id){
              return p;
          }  
        }
       return null;
    }

    @Override
    public boolean insert(Product p) {
        return lst.add(p);
        
    }
    
}
