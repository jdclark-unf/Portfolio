/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4justinclark;

/**
  * Holds data about countries
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Country
  {
    private String name;
    private String capital;
    private int population;
    
    /**
      * Default constructor
      * @param tokens an array of tokens parsed from one line of input file
      */
    public Country(String[] tokens)
      {
        name = tokens[0];
        capital = tokens[1];
        population = Integer.parseInt(tokens[2]);
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
      * Gets population of capital city
      * @return population attribute
      */
    public int getPopulation()
      {
        return population;
      } // end getPopulation()
    
    /**
      * Displays all attributes of object in-line
      * @return formatted string containing all attributes of object
      */
    @Override public String toString()
      {
        String outputString = String.format("%-20s%-20s%,20d", name, capital, population);
        return outputString;
      } //end toString()
  } // end Country class
