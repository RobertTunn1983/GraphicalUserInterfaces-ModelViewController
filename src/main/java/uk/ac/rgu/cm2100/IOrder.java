/* 
* IOrder.java, created 19 October 2021 by Robert Tunn
* Last updated - 1 November 2021
*/
package uk.ac.rgu.cm2100;

public interface IOrder extends Comparable <IMenuItem> {
    
    public void addItem(IMenuItem item);
    
    public int total();
    
    public void print();
    
    public void writeToFile();
    
    public void sortByName();
    
    public void sortByPrice();
}
