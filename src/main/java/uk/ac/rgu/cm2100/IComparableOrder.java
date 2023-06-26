/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.rgu.cm2100;

/**
 *
 * @author DELL
 */
public interface IComparableOrder extends Comparable <IMenuItem> {
    public void addItem(IMenuItem item);
    
    public int total();
    
    public void print();
    
    public void writeToFile();
    
    public void sortByName();
    
    public void sortByPrice();
}
