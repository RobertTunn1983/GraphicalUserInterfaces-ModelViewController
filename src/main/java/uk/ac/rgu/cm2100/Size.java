/* 
* Size.java, created 1 November 2021 by Robert Tunn
* Last updated - 5 January 2022
*/
package uk.ac.rgu.cm2100;

public enum Size {
    
    SMALL,
    MED,
    LARGE,
    HUGE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
