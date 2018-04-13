/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2justinclark;

/**
  * Holds data about countries
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Country
  {
    // Declare Country attributes
    private String name;
    private String capital;
    private int number;
    
    /**
      * Default constructor
      * @param tokens An array of tokens parsed from one line of input file
      */
    public Country(String[] tokens)
      {
        name = tokens[0];
        capital = tokens[1];
        number = Integer.parseInt(tokens[3]);
      } // end Country()
    
    /**
      * Gets country's name
      * @param Nothing
      * @return name attribute
      */
    public String getName()
      {
        return name;
      } // end getName()
    
    /**
      * Gets country's capital city
      * @param Nothing
      * @return capital attribute
      */
    public String getCapital()
      {
        return capital;
      } // end getCapital()
    
    /**
      * Gets country's region number
      * @param Nothing
      * @return number attribute
      */
    public int getNumber()
      {
        return number;
      } // end getNumber()
    
    /**
      * Displays all attributes of object in-line
      * @param Nothing
      * @return formatted string containing all attributes of object
      */
    @Override public String toString()
      {
        String outputString = String.format("%-16s%-16s", name, capital);
        return outputString;
      } // end toString()
  } // end class Country
