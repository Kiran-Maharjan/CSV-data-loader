/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader.enties;

import java.util.Date;

/**
 *
 * @author kiran
 */
public class Order {
    private int id;
    private Product pro;
    private Distributor dist;
    private int quantity;
    private double discount;
    private Date date;

    public Order() {
    }

    public Order(int id, Product pro, Distributor dist, int quantity, double discount, Date date) {
        this.id = id;
        this.pro = pro;
        this.dist = dist;
        this.quantity = quantity;
        this.discount = discount;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPro(Product pro) {
        this.pro = pro;
    }

    public void setDist(Distributor dist) {
        this.dist = dist;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Product getPro() {
        return pro;
    }

    public Distributor getDist() {
        return dist;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public Date getDate() {
        return date;
    }
    
    
}
