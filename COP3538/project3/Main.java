/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project3justinclark;

import java.io.*;

/**
  * Creates and displays a linked list of user data
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Main
  {
    /**
      * Entry point of program
      * @param args the command line arguments
      * @return None
      */
    public static void main(String[] args) throws IOException
      {
        ListControl control = new ListControl();
        
        control.buildList();
        control.printList(0);
        control.displayMenu();
        
        System.out.println("\nThat's All Folks!");
      } // end main()
  } // end class Main