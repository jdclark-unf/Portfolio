/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project4justinclark;

/**
  * Defines a node of a binary tree
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Node 
  {
    public Country countryData;
    public Node leftChild;
    public Node rightChild;
    
    public void displayNode()
      {
        System.out.print("{" + countryData + "} ");
      } // end displayNode()
  } // end class Node