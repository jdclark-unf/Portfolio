/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project5justinclark;

/**
  * Defines a link (node) within a linked list
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Link 
  {
    private Country countryData;
    public Link next;
    
    /**
     * Default constructor
     * @param inputString Text to be stored at link address
     * @return None
     */
    public Link(Country currentCountry)
      {
        countryData = currentCountry;
      } // end constructor
    
    /**
     * Gets the key (country name) associated with a link
     * @param None
     * @return String representation of key
     */
    public String getKey()
      {
        return countryData.getName();
      } // end getKey()
  } // end class Link
