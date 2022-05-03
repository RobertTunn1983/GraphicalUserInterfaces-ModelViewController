/*
 * Size.java, created 28 Decemeber 2021 by Robert Tunn
 * Last updated - 5 January 2022
 */
package uk.ac.rgu.cm2100;

import java.util.ArrayList;

import java.beans.*;

public class Model implements PropertyChangeListener {

    private final PropertyChangeSupport amend = new PropertyChangeSupport(this);

    public Model() {
        amend.addPropertyChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName() + " has been changed");
        System.out.println("Old Value = " + evt.getOldValue());
        System.out.println("New Value = " + evt.getNewValue());
    }

    //Method to change PizzaTopping name with firePropertyChange built in
    //To remove topping from list of available toppings set name to "" and price to 0 with next method
    public void changeToppingNamePropertyChange(String varName, PizzaTopping inputPT, String inputString) {

        String oldValue, newValue;

        //Get name before update with accessor in PizzaTopping
        oldValue = inputPT.getName();

        //Call the mutator in PizzaTopping
        inputPT.setName(inputString);

        //Get name after update
        newValue = inputPT.getName();

        //Fire property change
        amend.firePropertyChange(varName, oldValue, newValue);
    }

    public void changeToppingPricePropertyChange(String varName, PizzaTopping inputPT, Integer inputPrice) {

        Integer oldPrice, newPrice;

        oldPrice = inputPT.getPrice();

        inputPT.setPrice(inputPrice);

        newPrice = inputPT.getPrice();

        amend.firePropertyChange(varName, oldPrice, newPrice);
    }

    public void changeSideNamePropertyChange(String varName, Side inputSide, String inputString) {

        String oldValue, newValue;

        oldValue = inputSide.getName();

        inputSide.setName(inputString);

        newValue = inputSide.getName();

        amend.firePropertyChange(varName, oldValue, newValue);
    }

    public void changeSidePricePropertyChange(String varName, Side inputSide, Integer inputPrice) {

        Integer oldPrice, newPrice;

        oldPrice = inputSide.getPrice();

        inputSide.setPrice(inputPrice);

        newPrice = inputSide.getPrice();

        amend.firePropertyChange(varName, oldPrice, newPrice);
    }

    public void changeDrinkNamePropertyChange(String varName, Drink inputDrink, String inputString) {

        String oldValue, newValue;

        oldValue = inputDrink.getName();

        inputDrink.setName(inputString);

        newValue = inputDrink.getName();

        amend.firePropertyChange(varName, oldValue, newValue);
    }

    public void changeDrinkPricePropertyChange(String varName, Drink inputDrink, Integer inputPrice) {

        Integer oldPrice, newPrice;

        oldPrice = inputDrink.getPrice();

        inputDrink.setPrice(inputPrice);

        newPrice = inputDrink.getPrice();

        amend.firePropertyChange(varName, oldPrice, newPrice);
    }

    public void changeAlcoholStatusPropertyChange(String varName, Drink inputDrink, Boolean inputBool) {

        Boolean oldBool, newBool;

        oldBool = inputDrink.getAlcohol();

        inputDrink.setAlcohol(inputBool);

        newBool = inputDrink.getAlcohol();

        amend.firePropertyChange(varName, oldBool, newBool);
    }

    //ARRAYS OF PIZZA, SIDE AND DRINK OBJECTS
    static ArrayList<Pizza> currentPizzaList    = new ArrayList<>();
    static ArrayList<Side>  sideList            = new ArrayList<>();
    static ArrayList<Drink> drinkList           = new ArrayList<>();
    static ArrayList<Order> orderList           = new ArrayList<>();

    //SET DEFAULT VARIABLES LOADED ON SOFTWARE LAUNCH

    //PIZZA TOPPINGS IN PROGRESS
    public static ArrayList<PizzaTopping> toppingsArrayList = new ArrayList<>();

    static final PizzaTopping setTopping1  = new PizzaTopping("BBQ Sauce", 75);
    static final PizzaTopping setTopping2  = new PizzaTopping("Green Olives", 120);
    static final PizzaTopping setTopping3  = new PizzaTopping("Prawns", 150);
    static final PizzaTopping setTopping4  = new PizzaTopping("Tomato Sauce", 75);
    static final PizzaTopping setTopping5  = new PizzaTopping("Black Olives", 120);
    static final PizzaTopping setTopping6  = new PizzaTopping("Tuna", 140);
    static final PizzaTopping setTopping7  = new PizzaTopping("Mozzarella", 120);
    static final PizzaTopping setTopping8  = new PizzaTopping("Mushrooms", 120);
    static final PizzaTopping setTopping9  = new PizzaTopping("Ham", 140);
    static final PizzaTopping setTopping10 = new PizzaTopping("Beef", 140);
    static final PizzaTopping setTopping11 = new PizzaTopping("not assigned", 0);
    static final PizzaTopping setTopping12 = new PizzaTopping("not assigned", 0);

    //SIDES AT INITIALISATION
    static final Side side1     = new Side ("Chips", 100);
    static final Side side2     = new Side ("Garlic Bread", 200);
    static final Side side3     = new Side ("Garlic Dip", 80);
    static final Side side4     = new Side ("Salsa Dip", 80);
    static final Side side5     = new Side ("not assigned", 0);

    //DRINKS AT INITIALISATION
    static final Drink drink1   = new Drink ("Cola (litre)", 250, false);
    static final Drink drink2   = new Drink ("Cola (can)", 100, false);
    static final Drink drink3   = new Drink ("Pepsi (litre)", 250, false);
    static final Drink drink4   = new Drink ("Pepsi (can)", 100, false);
    static final Drink drink5   = new Drink ("Red Wine (litre)", 600, true);
    static final Drink drink6   = new Drink ("Brandy (litre)", 1200, true);
    static final Drink drink7   = new Drink ("not assigned", 0, false);

    //ORDER KEEPS TRACK OF MAIN ORDER BEING CREATED
    //CURRENTSUBORDER KEEPS TRACK OF CURRENT PIZZAS, SIDES AND DRINKS BEING ADDED TO MAIN ORDER
    public static Order order = new Order();
    public static Order currentSubOrder = new Order();

    //VARIABLES USED IN DIFFERENT CLASSES AND METHODS
    //iF THE VARIABLES ARE LOCAL, I LEAVE THEM IN THE CONTROLLERS
    public static String toppingString = "";
    public static String orderItemsList = "";
    public static String orderProgressString = "";
    public static String deleteOrderComboBoxCHOICE = "";
    public static Integer orderTotal = 0;

    //IT WAS VERY USEFUL TO PUT THIS METHOD HERE BECAUSE IT AVOIDED INTERFERING WITH OTHER BOOLEANS
    public Boolean alcoCheck(Drink inputDrink) {

        Boolean output;

        if (inputDrink.getAlcoholYN() == "Yes") {
            output = true;
        } else {
            output = false;
        }

        return output;
    }
}
