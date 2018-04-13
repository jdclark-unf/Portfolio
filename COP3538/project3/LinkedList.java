/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project3justinclark;

/**
  * Defines a linked list
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class LinkedList 
  {
    private Link first, last;
    private int length;
        
    /**
     * Default constructor
     * @param None
     * @return None
     */
    public LinkedList()
      {
        first = null;
        last = null;
        length = 0;
      } // end constructor
    
    /**
     * Gets first link in list
     * @return First link in list
     */
    public Link getFirst()
      {
        return first;
      } // end getFirst()
    
    /**
     * Gets last link in list
     * @return Last link in list
     */
    public Link getLast()
      {
        return last;
      } // end getLast()
    
    /**
     * Gets the number of links in list
     * @param None
     * @return Number of links in list
     */
    public int getLength()
      {
        return length;
      } // end getLength();
    
    /**
     * Determines whether or not the list is empty
     * @param None
     * @return Status of list
     */
    public boolean isEmpty()
      {
        return first == null;
      } //end isEmpty()
    
    /**
     * Inserts a link at beginning of list
     * @param data Data to be linked
     * @return None
     */
    public void insertFirst(String data)
      {
        Link newLink = new Link(data);
        
        if (isEmpty())
            last = newLink; //end if
        else
            first.previous = newLink; //end else
        
        newLink.next = first;
        first = newLink;
        length++;
      } // end insertFirst()
    
    /**
     * Inserts a link at end of list
     * @param data Data to be linked
     * @return None
     */
    public void insertLast(String data)
      {
        Link newLink = new Link(data);
        
        if (isEmpty())
            first = newLink; //end if
        else
          {
            last.next = newLink;
            newLink.previous = last;
          } // end else
        
        last = newLink;
        length++;
      } // end insertLast()
    
    /**
     * Inserts a link after another specified link
     * @param key Search key for prior link
     * @param data Data to be linked
     * @return Status of insertion
     */
    public boolean insertAfter(String key, String data)
      {
        Link current = first;
        Link newLink = new Link(data);
        
        while (current.linkData.compareTo(key) != 0)
          {
            current = current.next;
            if (current == null)
                return false;
          } // end while
        
        if (current == last)
          {
            newLink.next = null;
            last = newLink;
          } // end if
        else
          {
            newLink.next = current.next;
            current.next.previous = newLink;
          } // end else
        
        newLink.previous = current;
        current.next = newLink;
        length++;
        return true;
      } // end insertAfter()
    
    /**
     * Deletes first link in list
     * @param None
     * @return Deleted link
     */
    public Link deleteFirst()
      {
        Link temp = first;
        
        if (first.next == null)
            last = null; // end if
        else
            first.next.previous = null; //end else
        
        first = first.next;
        length--;
        return temp;
      } // end deleteFirst()
    
    /**
     * Deletes last link in list
     * @param None
     * @return Deleted link
     */
    public Link deleteLast()
      {
        Link temp = last;
        
        if (first.next == null)
            first = null; // end if
        else
            last.previous.next = null; // end else
        
        last = last.previous;
        length--;
        return temp;
      } // end deleteLast()
    
    /**
     * Deletes a specified link
     * @param key Search key to identify desired link
     * @return Deleted link
     */
    public Link deleteKey(String key)
      {
        Link current = first;
        
        while (current.linkData.compareTo(key) != 0)
          {
            current = current.next;
            
            if (current == null)
                return null; // end if
          } // end while
        
        if (current == first)
            first = current.next; // end if
        else
            current.previous.next = current.next; // end else
        
        if (current == last)
            last = current.previous; // end if
        else
            current.next.previous = current.previous; // end else
        
        length--;
        return current;
      } // end deleteKey()
    
    /**
     * Traverses and prints list in order of entry
     * @param None
     * @return None
     */
    public void displayForward()
      {
        System.out.print("");
        
        Link current = first;
        
        while (current != null)
          {
            current.displayLink();
            current = current.next;
          } // end while
        
        System.out.println("");
      } // end displayForward()
    
    /** 
     * Traverses and prints list in reversed order of entry
     * @param None
     * @return None
     */
    public void displayBackward()
      {
        System.out.print("");
        
        Link current = last;
        
        while (current != null)
          {
            current.displayLink();
            current = current.previous;
          } // end while
        
        System.out.println("");
      } // end displayBackward()
  } // end class LinkedList
