/* 
* Pizza.java, created 26 October 2021 by Robert Tunn
* Last updated - 5 January 2022
*/
package uk.ac.rgu.cm2100;

import java.util.ArrayList;

public class Pizza implements IMenuItem {

    private String name;   
    private Crust crust; 
    private ArrayList<PizzaTopping> toppings; 
    public final int BASE_PRICE = 300;       
    //Added by me
    private Size size;

    public Pizza(String name, Crust crust, Size size){
        this.name = name;
        this.crust = crust;
        this.size = size;
        this.toppings = new ArrayList<>();
    }

    public void addToppings(ArrayList<PizzaTopping> toppings){
        this.toppings.addAll(toppings);
    }

    //I have added this in myself
    public static ArrayList<Pizza> addPizza 
        (ArrayList<Pizza> pizzaArrayList, Pizza inputPizzaEle) {        

        pizzaArrayList.add(inputPizzaEle);     
        return pizzaArrayList;
    }

    public ArrayList<PizzaTopping> getToppings() {
        return this.toppings;
    }

    public Crust getCrust() {
        return this.crust;
    }
    
    public void setCrust(Crust input) {
        crust = input;
    }
    
    public Size getSize() {
        return this.size;
    }
    
    public void setSize(Size input) {
        size = input;
    }
    
    @Override
    public final String getName(){
        return this.name;
    }
 
    @Override
    public int getPrice() {
        
        ArrayList<PizzaTopping> inputPizza = this.toppings;
        
        int pizzaPrice = this.BASE_PRICE;
        
        for (int i = 0; i < inputPizza.size(); i++) {
            pizzaPrice += inputPizza.get(i).getPrice();
        }
      
        return pizzaPrice;   
    }   

    @Override
    public String getDescription() {
        
        return "\nDetails:\n" + this.name + "  " + this.getPrice() 
                + "p\nCrust: " + crust + "\nSize: " + size + "\nToppings: "
                + toppings.toString();
    }
    
    public String toString(){
        return this.name + "  " + this.getPrice() + "p";
    }  

    @Override
    public int compareTo(IMenuItem otherItem) {
        
        int comparePrice = ((IMenuItem)otherItem).getPrice();
      
        return this.getPrice() - comparePrice;
    }
}