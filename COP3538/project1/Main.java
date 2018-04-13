/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project1justinclark;

import java.io.*;

/**
  *  Reads text from a file and performs various operations thereupon
  *  @author Justin Clark
  */
public class Main
  {
    /**
      * This is where the magic happens
      * @param args the command line arguments
      */
    public static void main(String[] args) throws IOException
      {
        Collection countryCollection = new Collection();
        
        System.out.println("Contents of Text File\n");
        System.out.println("Country\t\tCapital\t\tRegion\t\t\tRegion_Nbr\t\tCapital_Population\n");
        countryCollection.printArray();
        
        countryCollection.selectionSort();
        System.out.println("Results of Selection Sort\n");
        System.out.println("Country\t\tCapital\t\tRegion\t\t\tRegion_Nbr\t\tCapital_Population\n");
        countryCollection.printArray();
        
        System.out.println("Results of Sequential Search\n");
        System.out.println("Search Key\tProbes\t\tStatus\n");
        countryCollection.sequentialSearch();
        
        System.out.print("\n\n");
        System.out.println("Results of Binary Search\n");
        System.out.println("Search Key\tProbes\t\tStatus\n");
        countryCollection.binarySearch();
      } // end main
  }