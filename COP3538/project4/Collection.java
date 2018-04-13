/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project4justinclark;
import java.io.*;

/**
  * Provides a control interface for various data structures
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Collection 
  {
    private String[] stringArray;
    private Queue treeQueue;
    private IOControl ioc;
    private Tree searchTree;
    
    /**
     * Gets the current Binary Search Tree
     * @return Binary Search Tree object
     */
    public Tree getTree()
      {
        return searchTree;
      } // end getTree()
    
    /**
     * Builds an array of Strings
     * @param maxSize Maximum size of array
     * @return Nothing
     * @throws IOException 
     */
    public void buildArray(int maxSize) throws IOException
      {
        stringArray = new String[maxSize];
        ioc = new IOControl();

        for (int i = 0; i < maxSize; i++)
            stringArray[i] = ioc.getString(); // end for
      } //end buildArray()
    
    /**
     * Builds a queue of Trees
     * @param maxSize Maximum size of queue
     * @return Nothing
     */
    public void buildQueue(int maxSize)
      {
        treeQueue = new Queue(maxSize);
        
        for (int i = 0; i < stringArray.length; i++)
          {
            Country currentCountry = new Country(stringArray[i].split(","));
            Tree currentTree = new Tree();
            
            currentTree.insert(currentCountry);
            treeQueue.insert(currentTree);
          } // end for
      } // end buildQueue()
    
    /**
     * Builds a Binary Search Tree from a queue of Trees
     * @param Nothing
     * @return Nothing
     */
    public void buildTree()
      {
        searchTree = new Tree();
        
        while (!treeQueue.isEmpty())
          {
            searchTree.insert(treeQueue.remove().root.countryData);
          } // end while
      } //end buildTree()
    
    /**
     * Print contents of array to console
     * @param Nothing
     * @return Nothing
     */
    public void printArray()
      {
        for (int i = 0; i < stringArray.length; i++)
            System.out.println(stringArray[i]); // end for
      } // end printArray()
    
    /**
     * Print contents of queue to console
     * @param Nothing
     * @return Nothing
     */
    public void printQueue()
      {
        treeQueue.printQueue();
      } // end printQueue()
    
    /**
     * Print contents of Binary Search Tree to console
     * @param Nothing
     * @return Nothing
     */
    public void printTree()
      {
        System.out.println("\nRecursive LNR Scan");
        System.out.println("Country Name        Capital\n");
        searchTree.traverse(2);
        
        System.out.println("\nIterative LNR Scan");
        System.out.println("Country Name        Capital\n");
        searchTree.traverse(5);
        
        System.out.println("\nRecursive RNL Scan");
        System.out.println("Country Name        Capital\n");
        searchTree.traverse(4);
        
        System.out.println("\nIterative RNL Scan");
        System.out.println("Country Name        Capital\n");
        searchTree.traverse(6);        
      } // end printTree()
    
    /**
     * Removes a number of nodes from the Binary Search Tree
     * @param inputString comma-delimited list of node keys
     * @return Nothing
     */
    public void removeNodes(String inputString)
      {
        String[] keys = inputString.split(",");
        
        // Delete each key in turn
        for (int i = 0; i < keys.length; i++)
          {
            searchTree.delete(keys[i]);
          } // end for
        
        printUpdate(keys);
      } // end removeNodes()
    
    /**
     * Performs a recursive LNR scan on Binary Search Tree, updated to indicate deleted nodes
     * @param inputTokens tokenized list of deleted node keys
     * @return Nothing
     */
    private void printUpdate(String[] inputTokens)
      {
        System.out.print("\nRecursive LNR Scan (sans ");
        
        if (inputTokens.length > 2)
          {
            for (int i = 0; i < inputTokens.length - 1; i++)
                System.out.print(inputTokens[i] + ", ");
            System.out.print("and " + inputTokens[inputTokens.length - 1] + ")\n");
          } // end if
        else
            System.out.print(inputTokens[0] + " and " + inputTokens[1] + ")\n");  // end else (inputTokens.length <= 2)
        
        System.out.println("Country Name        Capital\n");
        searchTree.traverse(2);
      } // end printUpdate()
  } // end class Collection
