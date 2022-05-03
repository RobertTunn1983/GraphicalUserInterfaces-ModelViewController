/* 
* Crust.java, created - 24 October 2021 by Robert Tunn 
* Last updated - 27 October 2021
*/
package uk.ac.rgu.cm2100;

public enum Crust { 
  
    THIN,
    MEDIUM,
    DEEP,
    CHEESE_AND_SAUCE_STUFFED_CRUST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}