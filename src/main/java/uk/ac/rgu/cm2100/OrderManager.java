/*
 * Not used, Model class used to store as much data as possible and add, get and set methods called from
 * classes created in Coursework 1
 */
package uk.ac.rgu.cm2100;

import java.util.ArrayList;
import java.util.List;

public class OrderManager extends Model {

    private List<Order> orders;

    public OrderManager(){
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
    public List<Order> getOrders(){
        return this.orders;
    }
}
