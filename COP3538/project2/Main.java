/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2justinclark;

import java.io.*;

/**
  * Creates a collection of countries and prints them to the console
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Main
  {

    /**
      * Main method from which everything else follows
      * @param args the command line arguments
      * @return Nothing
      */
    public static void main(String[] args) throws IOException
      {
        // Create and populate collection
        Collection countryCollection = new Collection(43);        
        countryCollection.buildArray("Countries.Summer2013.txt");
        countryCollection.buildStack(20);
        countryCollection.buildQueue(23);
        
        // Build and print priority queues
        countryCollection.buildPQueues(20);
        countryCollection.printPQueue(1);
        countryCollection.printPQueue(2);
        System.out.println("\n");
                
        // Build and print circular queues
        countryCollection.buildCQueues(8);
        countryCollection.printCQueue(1);
        countryCollection.printCQueue(2); 
        System.out.println();
      } // end main()
    
  } // end class Main