/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project3justinclark;

/**
  * Defines a link (node) within a linked list
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Link 
  {
    public String linkData;
    public Link next;
    public Link previous;
    
    /**
     * Default constructor
     * @param inputString Text to be stored at link address
     * @return None
     */
    public Link(String inputString)
      {
        linkData = inputString;
      } // end constructor
    
    /**
     * Prints link
     * @param None
     * @return None
     */
    public void displayLink()
      {
        System.out.println(linkData);
      } // end displayLink()
  } // end class Link
