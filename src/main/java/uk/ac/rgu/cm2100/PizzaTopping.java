/* 
* PizzaTopping.java, created 19 October 2021 by Robert Tunn
* Last updated - 5 January 2022
*/
package uk.ac.rgu.cm2100;

public class PizzaTopping {

    private String name;
    private int price;

    public PizzaTopping(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public final String getName(){
        return this.name;
    }

    public final void setName(String newName){
        this.name = newName;
    }
    
    public int getPrice(){
        return this.price;
    }

    public final void setPrice(int newPrice){
        this.price = newPrice;
    }
    
    public String toString(){
        return this.name;
    }       
}