/*
 * Not used, Model class used to store as much data as possible and add, get and set methods called from
 * classes created in Coursework 1
 */
package uk.ac.rgu.cm2100;

import java.util.ArrayList;
import java.util.List;

public class MenuManager extends Model {

    private ArrayList<IMenuItem> items;

    private ArrayList<PizzaTopping> availableToppings;

    public MenuManager(){
        this.items = new ArrayList<>();
        this.availableToppings = new ArrayList<>();
    }

    public void addItem(IMenuItem item){
        this.items.add(item);
    }

    public List<IMenuItem> getItems(){
        return this.items;
    }

    public void addTopping(PizzaTopping topping){
        this.availableToppings.add(topping);
    }

    public List<PizzaTopping> getToppings(){
        return this.availableToppings;
    }
}
