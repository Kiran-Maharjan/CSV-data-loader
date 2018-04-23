/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader;

import csv_data_loader.dao.DistributorDAO;
import csv_data_loader.dao.OrderDAO;
import csv_data_loader.dao.ProductDAO;
import csv_data_loader.enties.Distributor;
import csv_data_loader.enties.Order;
import csv_data_loader.enties.Product;
import csv_data_loader.impl.DistributorDAOImpl;
import csv_data_loader.impl.OrderDAOImpl;
import csv_data_loader.impl.ProductDAOImpl;
import csv_data_loader.utils.CSV_DataLoader;
import csv_data_loader.utils.Loader;
import csv_data_loader.utils.ProductLoader;
import java.io.IOException;

/**
 *
 * @author kiran
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // ---file location
        String productFile="D:/java/CSV_Data_Loader/Products.csv";
        String distributorFile="D:/java/CSV_Data_Loader/Distributors.csv";
        String orderFile="D:/java/CSV_Data_Loader/Orders.csv";
        
        //--Data Access Object  define      
        ProductDAO productDAO=new ProductDAOImpl();
        OrderDAO orderDAO=new OrderDAOImpl();
        DistributorDAO distributorDAO=new DistributorDAOImpl();
        
        //--Load CSV controlling DAO
        CSV_DataLoader csvDL=new CSV_DataLoader();
        csvDL.setProDAO(productDAO);
        csvDL.setDstDAO(distributorDAO);
        csvDL.setOrdDAO(orderDAO);
        
        //--load csv to memory
        ProductLoader load=new ProductLoader(); //--loading product file using loader class
        load.setProDAO(productDAO);
        load.load(productFile);
        
        csvDL.loadDistributors(distributorFile,","); //--give your line split syntax
        csvDL.loadOrder(orderFile);//--loading using csv_dataloader class
        
        //--now do any operation
        System.out.println("--------All Products name");
        for(Product p:productDAO.getAll()){
            
            System.out.println(""+p.getName());
        }
        
        System.out.println("----All Distributors name");

        for(Distributor d:distributorDAO.getAll()){
            System.out.println(""+d.getName());
        }
        
        
         System.out.println("\n-----------------All Orders info");

        for(Order o:orderDAO.getAll()){
           // System.out.println(""o.getDist()+" \t"+o.getPro()+o.getDate());
            System.out.println("Distributor \t Product \t Quantity \t Discount \t Date"); 
           System.out.print(o.getDist().getName());
            System.out.print("\t"+o.getPro().getName());
               System.out.print("\t"+o.getQuantity());
               System.out.print("\t"+o.getDiscount());
               System.out.print("\t"+o.getDate());
               System.out.println("\n");
        }
    }
    
}
