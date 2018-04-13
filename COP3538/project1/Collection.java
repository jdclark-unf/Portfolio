/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project1justinclark;

import java.io.*;

/**
  * Provides various methods that can be performed on an array
  * @author Justin Clark
  */
public class Collection
  {
    private BufferedReader input;
    private Country[] countryArray;
    private String countryFile = "Countries.Summer2013.txt";
    private String searchFile = "Search.Trans.Summer2013.txt";
    
    /**
     * Default constructor
     * @throws IOException 
     */
    public Collection() throws IOException
      {        
        input = new BufferedReader(new FileReader(countryFile));
        
        countryArray = new Country[43];
        
        for (int i = 0; i < countryArray.length; i++)
          {
            String line = input.readLine();
            countryArray[i] = new Country(line.split("[ ]+"));
          } // end for
      } // end Collection constructor            
        
    /**
     * Prints contents of array to console
     */
    public void printArray()
      {
        for (int i = 0; i < countryArray.length; i++)
            System.out.println(countryArray[i]); // end for
        
        System.out.println("\n");
      } // end printArray()
    
    /**
     * Performs in-place comparison sorting on array
     */
    public void selectionSort()
      {
        int min, index1, index2;
       
        for (index1 = 0; index1 < countryArray.length - 1; index1++)
          {
            min = index1;
            
            for (index2 = index1 + 1; index2 < countryArray.length; index2++)
              {
                if (countryArray[index2].getName().compareTo(countryArray[index1].getName()) < 0)
                  {
                    min = index2;
                    swap(index1, min);
                  } // end if
               } // end inner for
            } // end outer for
      } //end selectionSort()
    
    /**
     * Performs linear keyword search on array and displays results
     * @throws IOException 
     */
    public void sequentialSearch() throws IOException
      {
        input = new BufferedReader(new FileReader(searchFile));
                                
        for (int i = 0; i < 13; i++)
          {
            String searchKey = input.readLine();
            String status = "Not Found";
            int probes = 0;
            
            for (int j = 0; j < countryArray.length; j++)
              {
                probes++;
                if (countryArray[j].getName().equals(searchKey))
                  {
                    status = "Found";
                    break;
                  } //end if
              } // end inner for
            
            System.out.printf("%-16s%-16d%-16s%n", "\"" + searchKey + "\"", probes, status);
          } // end outer for
      } // end sequentialSearch()
    
    /**
     * Performs half-interval keyword search on array and displays results
     * @throws IOException 
     */
    public void binarySearch() throws IOException
      {
        input = new BufferedReader(new FileReader(searchFile));
                                
        for (int i = 0; i < 13; i++)
          {
            String searchKey = input.readLine();
            String status = "Not Found";
            int probes = 0;
            int lowerBound = 0;
            int upperBound = 42;
            int middleIndex;
                        
            while ((upperBound >= lowerBound) && !status.equals("Found"))
              {
                middleIndex = (lowerBound + upperBound) / 2;
                probes++;
                
                if (countryArray[middleIndex].getName().compareTo(searchKey) < 0)
                    lowerBound = middleIndex + 1; // end if
                else if (countryArray[middleIndex].getName().compareTo(searchKey) > 0)
                    upperBound = middleIndex - 1; // end else if
                else
                  status = "Found"; // end else
              } // end while
            
            System.out.printf("%-16s%-16d%-16s%n", "\"" + searchKey + "\"", probes, status);
          } // end for
      } //end binarySearch()
    
    /**
     * Transposes two elements of array
     * @param pos1 position of first element
     * @param pos2 position of second element
     */
    private void swap(int pos1, int pos2)
      {
        // Create a temporary placeholder
        Country temp = countryArray[pos1];
        
        // Switch positions of objects between array and placeholder
        countryArray[pos1] = countryArray[pos2];
        countryArray[pos2] = temp;
      } // end swap()
  }
