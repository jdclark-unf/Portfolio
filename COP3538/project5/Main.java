/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project5justinclark;

import java.io.*;

/**
  * Creates a hash table of countries read from a file
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Main
  {

    /**
      * Main body of program
      * @param args the command line arguments
      * @throws IOException
      */
    public static void main(String[] args) throws IOException
      {
        // Initialize variables
        int size = 23;                                  // Size of hash table
        String file1 = "ECountriesTrees.txt";           // Country file
        String file2 = "ECountriesTreesUpdate.txt";     // Update file
        String file3 = "ErrorList.txt";                 // Error output file
        
        // Prepare to read country file into hash table
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file3));
        HashTable table = new HashTable(size);
        
        // Read country file
        while (reader.ready())
          {
            Country currentCountry = new Country(reader.readLine().split(","));
            table.addCountry(new Link(currentCountry));
          } // end while
        
        // Print hash table
        System.out.println("Hash Table\n");
        System.out.println("Index  Country Name\n");
        table.displayTable();
        
        // Update hash table
        reader = new BufferedReader(new FileReader(file2));
        while (reader.ready())
          {
            String[] updateCommand = reader.readLine().split(",");
            
            if (updateCommand[0].compareTo("D") == 0)
              {
                if (table.findLink(updateCommand[1]) != null)
                    table.removeCountry(updateCommand[1]); // end if country exists
                else
                    writer.write("Country not found: " + updateCommand[1] + "\n"); // end else country not found
              } // end if country is to be deleted
            else
              {
                if (table.findLink(updateCommand[1]) == null)
                  {
                    String[] newCountry = {updateCommand[1], ""};
                    table.addCountry(new Link(new Country(newCountry)));
                  } // end if country exists
                else
                    writer.write("Duplicate country: " + updateCommand[1] + "\n"); // end else country not found
              } // end else country is to be added
          } // end while
        
        // Print updated hash table
        System.out.println("\n\nUpdated Hash Table\n");
        System.out.println("Index  Country Name\n");
        table.displayTable();
        System.out.println("\n* indicates a deleted item\n");
        
        // Update file streams
        writer.close();
        reader = new BufferedReader(new FileReader(file3));
        
        // Print error list
        System.out.println("\nError List\n");
        while (reader.ready())
          {
            System.out.println(reader.readLine());
          } // end while
      } // end main()

  } // end class Main
