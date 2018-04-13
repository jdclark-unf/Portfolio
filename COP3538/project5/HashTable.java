/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project5justinclark;

/**
  * Defines a hash table using an array of linked lists for separate chaining
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class HashTable 
  {
    private SortedList[] hashArray;
    private int arraySize;
        
    /** 
     * Default constructor
     * @param size size of new array for hash table
     * @return Nothing
     */
    public HashTable(int size)
      {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        
        for (int i = 0; i < arraySize; i++)
            hashArray[i] = new SortedList(); // end for
      } // end constructor
    
    /**
     * Prints the hash table to console
     * @param Nothing
     * @return Nothing
     */
    public void displayTable()
      {
        for (int i = 0; i < arraySize; i++)
          {
            System.out.printf("%-7d", i);
            if (hashArray[i].getFirst() != null)
                hashArray[i].displayList();
            else
                System.out.println("**");
          } // end for
      } // end displayTable()
    
    /**
     * Performs a hashing function on a string using Horner's rule (modified)
     * @param key Keyword to be hashed
     * @return Hash value of key
     */
    public int hashFunc(String key)
      {
        int hashVal = 0;
                
        for (int i = 0; i < key.length(); i++)
          {
            int letter = key.charAt(i) - 97;
            hashVal = (hashVal * 27 + letter) % arraySize;
          } // end for
        
        return hashVal;
      } // end hashFunc()
    
    /**
     * Adds a new country to hash table 
     * @param newLink New Link object to hold country
     * @return Nothing
     */
    public void addCountry(Link newLink)
      {
        String key = newLink.getKey().toLowerCase();
        int hashVal = hashFunc(key);
        
        hashArray[hashVal].insert(newLink);
      } // end addLink()
    
    /**
     * Logically deletes a country
     * @param key Name of country to be deleted
     * @return Nothing
     */
    public void removeCountry(String key)
      {
        int hashVal = hashFunc(key.toLowerCase());
        hashArray[hashVal].delete(key);
      } // end removeLink()
    
    /**
     * Searches for a given country in table
     * @param key Name of country to be found
     * @return Link containing desired country (returns null if not found)
     */
    public Link findLink(String key)
      {
        int hashVal = hashFunc(key.toLowerCase());
        Link keyLink = hashArray[hashVal].find(key);
        
        return keyLink;
      } // end findLink()
  } // end class HashTable
