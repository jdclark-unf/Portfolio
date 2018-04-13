/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project2justinclark;

/**
  * Defines a stack of Country objects
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Stack 
  {
    // Declare Stack attributes
    private Country[] countryStack;
    private int maxSize;
    private int top;
    
    /**
      * Default constructor
      * @param newSize Size of new stack      
      */
    public Stack(int newSize)
      {
        maxSize = newSize;
        countryStack = new Country[maxSize];
        top = -1;
      } // end Stack()
    
    /**
      * Puts a new Country object on top of stack
      * @param currentCountry Country object to be added
      * @return Nothing
      */
    public void push(Country currentCountry)
      {
        countryStack[++top] = currentCountry;
      }  //end push()
    
    /**
      * Removes and outputs Country object from top of stack
      * @param Nothing
      * @return Country object from top of stack
     */
    public Country pop()
      {
        return countryStack[top--];
      } // end pop()
    
    /**
      * Report which Country object is on top of stack
      * @param Nothing
      * @return Country object from top of stack
      */
    public Country peek()
      {
        return countryStack[top];
      } // end peek()
    
    /**
      * Determines whether stack is empty
      * @param Nothing
      * @return Empty status
      */
    public boolean isEmpty()
      {
        return (top == -1);
      } // end isEmpty()
    
    /**
      * Determines whether stack is full
      * @param Nothing
      * @return Full status
      */
    public boolean isFull()
      {
        return (top == maxSize - 1);
      } // end isFull()
    
  } // end class Stack
