/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5justinclark;

/**
  * Holds data about countries
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Country
  {
    private String name;
    private String capital;
        
    /**
      * Default constructor
      * @param tokens an array of tokens parsed from one line of input file
      */
    public Country(String[] tokens)
      {
        name = tokens[0];
        capital = tokens[1];
      } // end Country
    
    /**
      * Gets country's name
      * @return name attribute
      */
    public String getName()
      {
        return name;
      } //end getName()
    
    /**
      * Gets country's capital city
      * @return capital attribute
      */
    public String getCapital()
      {
        return capital;
      } // end getCapital()
    
    /**
      * Displays all attributes of object in-line
      * @return formatted string containing all attributes of object
      */
    @Override public String toString()
      {
        String outputString = String.format("%-20s%-20s", name, capital);
        return outputString;
      } //end toString()
  } // end Country class
