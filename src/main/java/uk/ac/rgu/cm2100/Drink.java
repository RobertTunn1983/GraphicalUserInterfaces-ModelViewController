/* 
* Drink.java, created 22 October 2021 by Robert Tunn
* Last updated - 27 October 2021
*/
package uk.ac.rgu.cm2100;

import java.util.ArrayList;

public class Drink implements IMenuItem {
    
    private String name;
    private int price;
    private boolean alcohol;

    public Drink(String name, int price, boolean alcohol){
        this.name = name;
        this.price = price;
        this.alcohol = alcohol;
    }

    public static ArrayList<Drink> addDrink (ArrayList<Drink> inputDrinkList, 
            Drink inputDrinkEle) {        
        inputDrinkList.add(inputDrinkEle);     
        return inputDrinkList;
    }





    //GETTERS AND SETTERS
    @Override
    public int getPrice() {
        return this.price;
    }

    public void setPrice(Integer input) {
        this.price = input;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String input) {
        this.name = input;
    }

    public void setAlcohol(boolean input) {
        this.alcohol = input;
    }

    public boolean getAlcohol() {
        return this.alcohol;
    }

    //If drink is alcoholic a warning is added to obtain ID from buyer
    @Override
    public String getDescription() {
        
        if (this.alcohol == false) {
            return this.name + ":  " + this.price;  
        }
        else {
            return this.name + ": " + this.price 
                    + " (alcohol - ID required)";  
        }    
    }
    
    //I have added this for the benefit of the CSV file output
    public String getAlcoholYN() {
        
        if (this.alcohol == false) {
            return "No";  
        }
        else {
            return "Yes";  
        }
    }
    
    public String toString(){
        return getDescription();
    }  

    @Override
    public int compareTo(IMenuItem otherItem) {
                
        int comparePrice = ((IMenuItem)otherItem).getPrice();
    
        return this.getPrice() - comparePrice;
    }
}