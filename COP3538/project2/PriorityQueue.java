/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project2justinclark;

/**
  * Defines a priority queue of Country objects
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class PriorityQueue
  {
    // Declare PriorityQueue attributes
    private Country[] countryPQueue;
    private int maxSize;
    private int numItems;
            
    /**
      * Default constructor
      * @param newSize Size of new priority queue
      */
    public PriorityQueue(int newSize)
      {
        maxSize = newSize;
        countryPQueue = new Country[maxSize];
        numItems = 0;
      } // end PriorityQueue()
    
    /**
      * Insert Country object to its appropriate position in priority queue
      * @param currentCountry Country object to be inserted
      * @return Nothing
      */
    public void insert(Country currentCountry)
      {
        int i;
        
        if (numItems == 0)
            countryPQueue[numItems++] = currentCountry; // end if
        else
          {
            for (i = numItems - 1; i >= 0; i--)
              {
                if (currentCountry.getName().compareTo(countryPQueue[i].getName()) > 0)
                    countryPQueue[i+1] = countryPQueue[i]; // end if
                else
                    break; // end else
              } //end for
            
            countryPQueue[i+1] = currentCountry;
            numItems++;            
          } // end else
      } // end insert()
    
    /**
      * Removes and outputs Country object at rear of priority queue
      * @param Nothing
      * @return Country object at rear of priority queue
      */
    public Country remove()
      {
        return countryPQueue[--numItems];
      } // end remove()
    
    /**
      * Report which Country object is at lowest priority in queue
      * @param Nothing
      * @return Country object at minimum priority
      */
    public Country peekMin()
      {
        return countryPQueue[numItems - 1];
      } // end peekMin()
    
    /**
      * Determines whether priority queue is empty
      * @param Nothing
      * @return Empty status
      */
    public boolean isEmpty()
      {
        return (numItems == 0);
      } //end isEmpty()
    
    /**
      * Determine whether priority queue is full
      * @param Nothing
      * @return Full status
      */
    public boolean isFull()
      {
        return (numItems == maxSize);
      } //end isFull()
    
    /**
      * Report which Country object is at given index
      * @param index Index to be examined
      * @return Country object at index
      */
    public Country peekIndex(int index)
      {
        return countryPQueue[index];
      } // end peekIndex()
    
    /**
      * Gets size of priority queue
      * @param Nothing
      * @return Size of priority queue, i.e. How many items are in it
      */
    public int getSize()
      {
        return numItems;
      } // end getSize()
    
   } // end class PriorityQueue
