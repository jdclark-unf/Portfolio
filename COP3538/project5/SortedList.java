/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project5justinclark;

/**
  * Defines a sorted singly-linked list
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class SortedList 
  {
    private Link first;
    
    /**
     * Default constructor
     * @param Nothing
     * @return Nothing
     */
    public SortedList()
      {
        first = null;
      } // end constructor
    
    /**
     * Gets the first link in list
     * @param Nothing
     * @return First link in current list
     */
    public Link getFirst()
      {
        return first;
      } // end getFirst()
    
    /**
     * Inserts a link to its proper place in list order
     * @param currentLink Link to be inserted
     * @return Nothing
     */
    public void insert(Link currentLink)
      {
        String key = currentLink.getKey();
        Link previous = null;
        Link current = first;
        
        while (current != null && key.compareTo(current.getKey()) > 0)
          {
            previous = current;
            current = current.next;
          } // end while
        
        if (previous == null)
            first = currentLink; // end if
        else
            previous.next = currentLink; // end else
        
        currentLink.next = current;
      } // end insert()
    
    /**
     * Logically deletes a link from the list
     * @param key Keyword of link to be deleted
     * @return Nothing
     */
    public void delete(String key)
      {
        Link previous = null;
        Link current = first;
        String[] nonItem = {key + "*", ""};
        
        while (current != null && key.compareTo(current.getKey()) != 0)
          {
            previous = current;
            current = current.next;
          } // end while
        
        if (previous == null)
            first = new Link(new Country(nonItem));
        else
            previous.next = new Link(new Country(nonItem));
      } // end delete()
    
    /**
     * Searches for a given link in list
     * @param key Keyword of desired link
     * @return Link containing desired country (returns null if not found)
     */
    public Link find(String key)
      {
        Link current = first;
        
        while (current != null && current.getKey().compareTo(key) <= 0)
          {
            if (current.getKey().compareTo(key) == 0)
                return current; // end if
            else
                current = current.next; // end else
          } // end while
        
        return null;
      } // end find()
    
    /**
     * Print current list to console with in-line formatting
     * @param Nothing
     * @return Nothing
     */
    public void displayList()
      {
        Link current = first;
        
        while (current != null)
          {
            System.out.print(current.getKey() + "  ");
            current = current.next;
          } // end while
        
        System.out.print("\n");
      } // end displayList()
  } // end class SortedList
