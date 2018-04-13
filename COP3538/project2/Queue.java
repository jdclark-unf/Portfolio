/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project2justinclark;

/**
  * Defines a queue of Country objects
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Queue
  {
    // Declare Queue attributes
    private Country[] countryQueue;
    private int maxSize;
    private int front;
    private int rear;
    private int numItems;
    
    /**
      * Default constructor
      * @param newSize Size of new queue
      */
    public Queue(int newSize)
      {
        maxSize = newSize;
        countryQueue = new Country[maxSize];
        front = 0;
        rear = -1;
        numItems = 0;
      } //end constructor Queue()
    
    /**
      * Insert Country object into rear of queue
      * @param currentCountry Country object to be inserted
      * @return Nothing
      */
    public void insert(Country currentCountry)
      {
        if (rear == countryQueue.length - 1)
            rear = -1;
        countryQueue[++rear] = currentCountry;
        numItems++;
      } // end insert()
    
    /**
      * Remove and output country object from front of queue
      * @param Nothing
      * @return Country object at front of queue
      */
    public Country remove()
      {
        Country temp = countryQueue[front++];
        if (front == maxSize)
            front = 0;
        numItems--;
        return temp;
      } //end remove()
    
    /**
      * Report which Country object is at front of queue
      * @param Nothing
      * @return Country object at front of queue
      */
    public Country peekFront()
      {
        return countryQueue[front];
      } // end peekFront()
    
    /**
      * Determines whether queue is empty
      * @param Nothing
      * @return Empty status
      */
    public boolean isEmpty()
      {
        return (numItems == 0);
      } // end isEmpty()
    
    /**
      * Determines whether queue is full
      * @param Nothing
      * @return Full status
      */
    public boolean isFull()
      {
        return (numItems == maxSize);
      } // end isFull()
    
    /**
      * Gets size of queue
      * @param Nothing
      * @return Size of queue, i.e. How many items are in it
      */
    public int getSize()
      {
        return numItems;
      } // end size()
    
  } // end class Queue
