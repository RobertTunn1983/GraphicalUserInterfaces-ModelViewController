/* 
* Side.java, created 19 October 2021 by Robert Tunn
* Last updated - 5 January 2022
*/
package uk.ac.rgu.cm2100;

import java.util.ArrayList;

public class Side implements IMenuItem {
    
    private String name;
    private int price;

    public Side(String name, int price){
        this.name = name;
        this.price = price;
    }
    
    public static ArrayList<Side> addSide 
        (ArrayList<Side> inputSideList, Side inputSideEle) {        
        
        inputSideList.add(inputSideEle);     
        return inputSideList;
    }

    @Override
    public int getPrice() {  
        return price;
    }
    
    @Override
    public String getName() {
        return name;
    }

    public void setPrice(Integer input) {

        this.price = input;
    }

    public void setName(String input) {

        this.name = input;
    }

    @Override
    public String getDescription() {
        return name + ": " + price;
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