/* 
* Order.java, created 22 October 2021 by Robert Tunn
* Last updated - 5 January 2022
*/
package uk.ac.rgu.cm2100;

import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Order implements IOrder {

    ArrayList<IMenuItem> items;

    public Order() {
        items = new ArrayList<IMenuItem>();
    }
    
    @Override
    public void addItem (IMenuItem item) {this.items.add(item);}

    public void printItems () {

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

    @Override
    public int total() {
     
        int output = 0;
        
        for (int i = 0; i < items.size(); i++) {
            output += items.get(i).getPrice();
        }
        
        return output;
    }

    @Override
    public void writeToFile() {

        //Create an ArrayList of objects
        ArrayList<Object> list = new ArrayList<>();
        
        //Copy IMenuItem ArrayList to the ArrayList of objects
        for (int i = 0; i < items.size(); i++) {
            list.add(items.get(i));
        }  
        
        try {

            //Create PrintWriter Object and new File
            PrintWriter pw = new PrintWriter
                (new File("C:\\Users\\Robert's account\\Desktop\\order.csv"));

            //Create StringBuilder Object
            StringBuilder sb = new StringBuilder();

            //Iterate over array of Objects
            for (int i = 0; i < list.size(); i++) {            

                //Assign object variable to Object at pos i...
                Object pos = list.get(i);
                
                if (list.get(i) instanceof Pizza) {

                    //...and assign variables to fields within class using
                    //getter methods for each concrete type
                    String outputName = ((Pizza) pos).getName();
                    int outputPrice = ((Pizza) pos).getPrice();
                    ArrayList<PizzaTopping> outputToppingList
                            = ((Pizza) pos).getToppings();
                    Crust outputCrust = (((Pizza) pos).getCrust());
                    Size outputSize = (((Pizza) pos).getSize());
                    
                    //PIZZA,<Name>,<Price>,<Crust>,<Size>,<Toppings>
                    sb.append("PIZZA,");
                    sb.append(outputName + ",");
                    sb.append(outputPrice + ",");
                    sb.append(outputCrust + ",");
                    sb.append(outputSize + ",");
                    
                    for (int a = 0; a < outputToppingList.size(); a++) {
                        sb.append(outputToppingList.get(a) + ",");
                    }
                    
                    sb.append("\n");
                }

                else if (items.get(i) instanceof Side) {

                    String outputName = ((Side) pos).getName();
                    int outputPrice = ((Side) pos).getPrice();
                    
                    //SIDE,<Name>,<Price>
                    sb.append("SIDE,");
                    sb.append(outputName + ",");
                    sb.append(outputPrice + ",");
                    sb.append("\n");
                }

                else if (items.get(i) instanceof Drink) {

                    String outputName = ((Drink) pos).getName();
                    int outputPrice = ((Drink) pos).getPrice();
                    String outputAlcohol = ((Drink) pos).getAlcoholYN();                  
                    
                    //DRINK,<Name>,<Price>,<Alcoholic?>
                    sb.append("DRINK,");
                    sb.append(outputName + ",");
                    sb.append(outputPrice + ",");
                    sb.append(outputAlcohol + ",");   
                    sb.append("\n");
                }
            }

            //After all fields in String form have been appended to output 
            //String, send to PrintWriter Object and close file
            pw.write(sb.toString());
            pw.close();

            }
            catch (Exception e) {
            //NO NEED FOR ELABORATE EXCEPTION CLAUSE
        }
    }


    @Override
    public void print() {

        //Some embellishments to add to functionality
        System.out.println("ORDER DETAILS\n");

        System.out.printf("%-15s%15s\n\n", "Item", "Cost(£)");

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%-15s%15.2f\n", items.get(i).getName(),
                    ((float)items.get(i).getPrice())/100);
        }

        System.out.println();
        System.out.printf("%-15s%15.2f", "TOTAL", (((float)this.total())/100));

        //Add date and time stamp to receipt
        Date transTimeDate = new Date(System.currentTimeMillis()
            + TimeUnit.HOURS.toMillis(0));
    }

    @Override
    public void sortByName() {

        Comparator<IMenuItem> name =
	(IMenuItem o1, IMenuItem o2) -> o1.getName().compareTo(o2.getName());        

        Collections.sort(items, name);
     
        //Print to console
        for(IMenuItem str: items){
            System.out.println(str);
	    }
    }

    @Override
    public void sortByPrice() {
     
        Collections.sort(items);
        
        for(IMenuItem str: items){
            System.out.println(str);
	    }
    }

    @Override
    public int compareTo(IMenuItem o) {
        return 0;
    }
}



  
