/*
 ---it loads file from csv to memory..
--- taken token and map to memory
 */
package csv_data_loader.utils;

import csv_data_loader.dao.DistributorDAO;
import csv_data_loader.dao.OrderDAO;
import csv_data_loader.dao.ProductDAO;
import csv_data_loader.enties.Distributor;
import csv_data_loader.enties.Order;
import csv_data_loader.enties.Product;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kiran
 */
public class CSV_DataLoader {
    private ProductDAO proDAO;
    private DistributorDAO dstDAO;
    private OrderDAO ordDAO;

    public void setProDAO(ProductDAO proDAO) {
        this.proDAO = proDAO;
    }

   
    public void setDstDAO(DistributorDAO dstDAO) {
        this.dstDAO = dstDAO;
    }

    public void setOrdDAO(OrderDAO ordDAO) {
        this.ordDAO = ordDAO;
    }

    
      

    public  void loadDistributors(String filename,String splitor) throws IOException {
        for (String line : FileHelper.readline(filename)) {
            String[] tokens = line.split(splitor);
            if (tokens.length >= 2) {
                Distributor dst=new Distributor();
                int id = Integer.parseInt(tokens[0]);
                if (dstDAO.getById(id) == null) {
                    dst.setId(id);
                    dst.setName(tokens[1]);

                    dstDAO.insert(dst);
                }
            }
        }
    }

    public void loadOrder(String filename) throws IOException {
        
        for (String line : FileHelper.readline(filename)) {
            String[] tokens = line.split(",");
            if (tokens.length >= 5) {
                Order ord=new Order();
                Product pro=new Product();
                Distributor dst=new Distributor();
                int distId = Integer.parseInt(tokens[0]);
                int proId = Integer.parseInt(tokens[1]);
                pro = proDAO.getById(proId);
                dst = dstDAO.getById(distId);
                if ((pro != null) && (dst != null)) {
                    ord.setDist(dst);
                    ord.setPro(pro);
                    ord.setQuantity(Integer.parseInt(tokens[2]));
                    ord.setDiscount(Integer.parseInt(tokens[3]));
                    try {
                        SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
                        ord.setDate(df.parse(tokens[4]));
                    } catch (ParseException pe) {
                    }
                    ordDAO.insert(ord);
                }

            }
        }
    }
}
