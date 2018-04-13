/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project1justinclark;

/**
  * Holds data about countries
  * @author Justin Clark
  */
public class Country
  {
    private String name;
    private String capital;
    private String region;
    private int number;
    private int population;
    
    /**
      * Default constructor
      * @param tokens an array of tokens parsed from one line of input file
      */
    public Country(String[] tokens)
      {
        name = tokens[0];
        capital = tokens[1];
        region = tokens[2];
        number = Integer.parseInt(tokens[3]);
        population = Integer.parseInt(tokens[4]);
      } // end Country
    
    /**
      * Gets country's name
      * @return name attribute
      */
    public String getName()
      {
        return name;
      }
    
    /**
      * Gets country's capital city
      * @return capital attribute
      */
    public String getCapital()
      {
        return capital;
      }
    
    /**
      * Gets country's region
      * @return region attribute
      */
    public String getRegion()
      {
        return region;
      }
    
    /**
      * Gets country's region number
      * @return number attribute
      */
    public int getNumber()
      {
        return number;
      }
    
    /**
      * Gets population of capital city
      * @return population attribute
      */
    public int getPopulation()
      {
        return population;
      }
    
    /**
      * Displays all attributes of object in-line
      * @return formatted string containing all attributes of object
      */
    @Override public String toString()
      {
        String outputString = String.format("%-16s%-16s%-24s%10d%,32d", name, capital, region, number, population);
        return outputString;
      }
  }
