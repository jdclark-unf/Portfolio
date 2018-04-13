/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project4justinclark;

/**
  * Defines a stack of Node objects
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Stack 
  {
    // Declare Stack attributes
    private Node[] nodeStack;
    private int maxSize;
    private int top;
    
    /**
      * Default constructor
      * @param newSize Size of new stack      
      */
    public Stack(int newSize)
      {
        maxSize = newSize;
        nodeStack = new Node[maxSize];
        top = -1;
      } // end Stack()
    
    /**
      * Puts a new Node object on top of stack
      * @param currentNode Node object to be added
      * @return Nothing
      */
    public void push(Node currentNode)
      {
        nodeStack[++top] = currentNode;
      } // end push()
    
    /**
      * Removes and outputs Node object from top of stack
      * @param Nothing
      * @return Node object from top of stack
     */
    public Node pop()
      {
        return nodeStack[top--];
      } // end pop()
    
    /**
      * Report which Node object is on top of stack
      * @param Nothing
      * @return Node object from top of stack
      */
    public Node peek()
      {
        return nodeStack[top];
      } // end peek()
    
    /**
      * Determines whether stack is empty
      * @param Nothing
      * @return Empty status
      */
    public boolean isEmpty()
      {
        return (top == -1);
      } // end isEmpty()
    
    /**
      * Determines whether stack is full
      * @param Nothing
      * @return Full status
      */
    public boolean isFull()
      {
        return (top == maxSize - 1);
      } // end isFull()
    
  } // end class Stack
