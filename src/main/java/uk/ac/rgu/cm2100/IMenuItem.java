/* 
* IMenuItem.java, created 19 October 2021 by Robert Tunn
* Last updated - 5 November 2021
*/
package uk.ac.rgu.cm2100;

import java.util.Comparator;

public interface IMenuItem extends Comparable <IMenuItem> {
    
    public int getPrice();
    
    public String getDescription();
    
    public String getName();

    public class PriceComparator implements Comparator <IMenuItem> {

        public PriceComparator(){
        }
        
        @Override
        public int compare(IMenuItem o1, IMenuItem o2) {
            
            return Integer.compare(o1.getPrice(), o2.getPrice());
     
        }
    }
}
