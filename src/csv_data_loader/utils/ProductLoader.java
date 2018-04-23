/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader.utils;

import csv_data_loader.dao.ProductDAO;
import csv_data_loader.enties.Product;
import java.io.IOException;

/**
 *
 * @author kiran
 */
public class ProductLoader extends Loader{
 private ProductDAO proDAO;
 
 public void setProDAO(ProductDAO proDAO) {
        this.proDAO = proDAO;
    }
 
    @Override
    public void load(String filename) throws IOException {
        
       for (String line : FileHelper.readline(filename)) {
            String[] tokens = line.split(",");
            if (tokens.length >= 3) {
                                Product pro =new Product();

                int id = Integer.parseInt(tokens[0]);
                if (proDAO.getById(id) == null) {
                    pro.setId(Integer.parseInt(tokens[0]));
                    pro.setName(tokens[1]);
                    pro.setPrice(Integer.parseInt(tokens[2]));
                    proDAO.insert(pro);
                }
            }

        }
    }
        
    }
    

