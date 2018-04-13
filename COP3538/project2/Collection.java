/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2justinclark;

import java.io.*;

/**
  * Defines a collection of stacks and queues in which country data may be 
  * stored and manipulated
  * @author Justin Clark
  */
public class Collection
  {
    // Declare Collection attributes
    private Country[] countryArray;
    private Stack countryStack;
    private Queue countryQueue;
    private Queue countryCQueue1;
    private Queue countryCQueue2;
    private PriorityQueue countryPQueue1;
    private PriorityQueue countryPQueue2;
        
    /**
      * Default constructor
      * @param maxSize Maximum size of base array
      */
    public Collection(int maxSize)
      {        
        countryArray = new Country[maxSize];
      } // end Collection()
    
    /**
      * Builds an array of Country objects from a plain text file
      * @param fileName The file to be read
      * @return Nothing
      * @throws IOException 
      */
    public void buildArray(String fileName) throws IOException
      {
        BufferedReader inputReader = new BufferedReader(new FileReader(fileName));
        
        for (int i = 0; i < countryArray.length; i++)
          {
            countryArray[i] = new Country(inputReader.readLine().split("[ ]+"));            
          } // end for
      } // end buildArray()
    
    /**
      * Builds a stack of Country objects from base array 
      * @param maxSize Maximum size of stack
      * @return Nothing
      */
    public void buildStack(int maxSize)
      {
        countryStack = new Stack(maxSize);
        
        for (int i = 0; i < countryArray.length; i++)
          {
            int number = countryArray[i].getNumber();
            
            if (number == 1 || number == 2)
                countryStack.push(countryArray[i]);
          } //end for
      } // end buildStack()
    
    /**
      * Builds a queue of Country objects from base array
      * @param maxSize Maximum size of queue
      * @return Nothing
      */
    public void buildQueue(int maxSize)
      {
        countryQueue = new Queue(maxSize);
        int index = 0;
        
        while (!countryQueue.isFull())
          {
            if (countryArray[index].getNumber() > 2)
                countryQueue.insert(countryArray[index]); //end if
            index++;
          } //end while          
      } // end buildQueue()
    
    /**
      * Builds two priority queues of Country objects from stack
      * @param maxSize Maximum size of priority queues
      * @return Nothing
      */
    public void buildPQueues(int maxSize)
      {
        countryPQueue1 = new PriorityQueue(maxSize);
        countryPQueue2 = new PriorityQueue(maxSize);
        
        while (!countryStack.isEmpty())
          {
            if (countryStack.peek().getNumber() == 1)
                countryPQueue1.insert(countryStack.pop()); //end if
            else
                countryPQueue2.insert(countryStack.pop()); //end else
          } // end while
      } //end buildPQueues()
    
    /**
      * Builds two circular queues of Country objects from queue
      * @param maxSize Maximum size of circular queues
      * @return Nothing
      */
    public void buildCQueues(int maxSize)
      {
        countryCQueue1 = new Queue(maxSize);
        countryCQueue2 = new Queue(maxSize);
        
        while (!countryQueue.isEmpty())
          {
            if (countryQueue.peekFront().getNumber() == 3)
              {
                if (countryCQueue1.isFull())
                    System.out.println("For Region 3, item removed from queue: " + countryCQueue1.remove().getName());                
                countryCQueue1.insert(countryQueue.remove());
              } // end if
            else
              {
                if (countryCQueue2.isFull())
                    System.out.println("For region 4, item removed from queue: " + countryCQueue2.remove().getName());
                countryCQueue2.insert(countryQueue.remove());
              } //end else
          } // end while
      } // end buildCQueues()
    
    /**
      * Prints contents of priority queue to console
      * @param number Number of priority queue
      * @return Nothing
      */
    public void printPQueue(int number)
      {
        PriorityQueue currentPQueue;
        
        if (number == 1)
          {
            System.out.println("\n\nRegion 1: Northern Europe\n");
            currentPQueue = countryPQueue1;
          } //end if
        else
          {
            System.out.println("\n\nRegion 2: Western Europe\n");
            currentPQueue = countryPQueue2;
          } // end else
        
        for (int i = currentPQueue.getSize() - 1; i > -1; i--)
            System.out.println(currentPQueue.peekIndex(i).getName()); //end for
      } // end printPQueue()
    
    /**
      * Prints contents of circular queue to console
      * @param number Number of circular queue
      * @return Nothing
      */
    public void printCQueue(int number)
      {
        Queue currentCQueue;
        
        if (number == 1)
          {
            System.out.println("\n\nRegion 3: Eastern Europe\n");
            currentCQueue = countryCQueue1;
          } //end if
        else
          {
            System.out.println("\n\nRegion 4: Central Europe\n");
            currentCQueue = countryCQueue2;
          } //end else (number == 4)
        
        while (!currentCQueue.isEmpty())
            System.out.println(currentCQueue.remove().getName()); //end while
      } // end printCQueue()
  } // end class Collection
