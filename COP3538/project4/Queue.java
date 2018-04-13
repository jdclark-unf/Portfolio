/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project4justinclark;

/**
  * Defines a queue of Country objects
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Queue
  {
    // Declare Queue attributes
    private Tree[] treeQueue;
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
        treeQueue = new Tree[maxSize];
        front = 0;
        rear = -1;
        numItems = 0;
      } //end constructor Queue()
    
    /**
      * Insert Tree object into rear of queue
      * @param currentTree Tree object to be inserted
      * @return Nothing
      */
    public void insert(Tree currentTree)
      {
        if (rear == treeQueue.length - 1)
            rear = -1;
        treeQueue[++rear] = currentTree;
        numItems++;
      } // end insert()
    
    /**
      * Remove and output Tree object from front of queue
      * @param Nothing
      * @return Tree object at front of queue
      */
    public Tree remove()
      {
        Tree temp = treeQueue[front++];
        if (front == maxSize)
            front = 0;
        numItems--;
        return temp;
      } //end remove()
    
    /**
      * Report which Tree object is at front of queue
      * @param Nothing
      * @return Tree object at front of queue
      */
    public Tree peekFront()
      {
        return treeQueue[front];
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
    
    /**
     * Prints contents of queue to console
     * @param Nothing
     * @return Nothing
     */
    public void printQueue()
      {
        System.out.println("Contents of Queue");
        System.out.printf("\n%-20s%-20s%20s\n\n", "Country", "Capital", "Population of Capital");
        
        for (int i = 0; i < numItems; i++)
            System.out.println(treeQueue[i].root.countryData.toString());
      } //end printQueue()    
  } // end class Queue
