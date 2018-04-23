/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader.impl;

import csv_data_loader.dao.DistributorDAO;
import csv_data_loader.enties.Distributor;
import java.util.ArrayList;
import java.util.List;


public class DistributorDAOImpl implements DistributorDAO {
    List<Distributor> lst=new ArrayList<>();
    
    @Override
    public List<Distributor> getAll() {
        return lst;
    }

    @Override
    public Distributor getById(int id) {
       
        for(Distributor p:lst){
          if(p.getId()==id){
              return p;
          }  
        }
       return null;
    }

    @Override
    public boolean insert(Distributor p) {
        return lst.add(p);
        
    }
    
}
