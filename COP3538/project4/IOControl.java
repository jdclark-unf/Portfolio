/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project4justinclark;

import java.io.*;

/**
  * Provides an interface for Input/Output operations
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class IOControl 
  {
    private String inputFile;
    private BufferedReader inputReader;
    
    public IOControl() throws IOException
      {
        inputFile = "ECountriesTrees.txt";
        inputReader = new BufferedReader(new FileReader(inputFile));
      } // end constructor
    
    public String getString() throws IOException
      {
        return inputReader.readLine();
      } // end getString()
  } // end class IOControl
