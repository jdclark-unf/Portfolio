/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4justinclark;

import java.io.*;

/**
 * Organizes and displays country data read from a file
 * @author Justin Clark <n00882194@ospreys.unf.edu>
 */
public class Main
  {

    /**
     * @param args the command line arguments
     * @return None
     */
    public static void main(String[] args) throws IOException
      {
        Collection treeCollection = new Collection();
        
        treeCollection.buildArray(21);
        treeCollection.buildQueue(30);
        
        System.out.println();
        treeCollection.printQueue();
        
        treeCollection.buildTree();
        treeCollection.printTree();
        
        treeCollection.removeNodes("Belarus,Ukraine,Latvia");
        treeCollection.removeNodes("Denmark,Norway");
        treeCollection.removeNodes("Sweden,Estonia");
      }
  } // end class Main
