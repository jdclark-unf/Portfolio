/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project3justinclark;

import java.io.*;

/**
  * User interface to access and modify a linked list
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class ListControl 
  {
    private LinkedList stringList;
    private BufferedReader inputReader;
    
    /**
     * Default constructor
     * @param None
     * @return None
     */
    public ListControl()
      {
        stringList = new LinkedList();
        inputReader = new BufferedReader(new InputStreamReader(System.in));
      } // end constructor
    
    /**
     * Builds a linked list from user input
     * @param None
     * @return None
     * @throws IOException 
     */
    public void buildList() throws IOException
      {
        String input;        
        boolean repeat = true;
        
        // Loop until user gives stop command
        while (repeat)
          {
            System.out.println("\nInput a string and press enter (input -1 to stop)");
            input = inputReader.readLine();
            
            if (input.compareTo("") == 0)
                System.out.println("\nInvalid input"); // end if                
            else if (input.compareTo("-1") != 0)
                stringList.insertLast(input); //end if
            else
                repeat = false; // end else
          } // end while
      } // end buildList()
    
    /**
     * Prints contents of list
     * @param mode List version selector (zero for initial list, nonzero for updated list)
     * @return None
     */
    public void printList(int mode)
      {
        if (mode == 0)
          {
            System.out.println("\nInitial List:\n");
            stringList.displayForward();
            
            System.out.println("Number of Nodes in List: " + stringList.getLength());
          } // end if
        else
          {
            System.out.println("\nUpdated List (forward order):\n");
            stringList.displayForward();
            
            System.out.println("\nUpdated List (backward order):\n");
            stringList.displayBackward();
            
            System.out.println("Number of Nodes in List: " + stringList.getLength());
          } // end else
      } //end printList()
    
    /**
     * Displays user menu
     * @param None
     * @return None
     * @throws IOException 
     */
    public void displayMenu() throws IOException
      {
        String input;
        boolean repeat = true;
        
        // Loop until user gives stop command
        while (repeat)
          {
            System.out.println("\nUpdate Menu\n");
            System.out.println("1. Delete First");
            System.out.println("2. Delete Last");
            System.out.println("3. Insert First");
            System.out.println("4. Insert Last");
            System.out.println("5. Delete Node");
            System.out.println("6. Insert Node After");
            System.out.println("7. Display Updated Linked List");
            System.out.println("8. Terminate");
            System.out.println("\nPlease type your selection (1-8) and press enter:");
            
            input = inputReader.readLine();
            repeat = select(input);
          } //end while
      } // end displayMenu()
    
    /**
     * Confirms and executes menu selection
     * @param menuItem Item selected by user
     * @return Condition of execution
     * @throws IOException 
     */
    public boolean select(String menuItem) throws IOException
      {
        String input;
        
        switch (menuItem)
          {
            case "1":
                if (stringList.isEmpty())
                    System.out.println("\nNo nodes available for deletion");
                else
                    System.out.println("\nDeleted first node: " + stringList.deleteFirst().linkData);
                
                if (continuePrompt())
                    return true;
                else
                    return false;
            case "2":
                if (stringList.isEmpty())
                    System.out.println("\nNo nodes available for deletion"); // end if
                else
                    System.out.println("\nDeleted last node: " + stringList.deleteLast().linkData); //end else
                
                if (continuePrompt())
                    return true;
                else
                    return false;
            case "3":
                System.out.println("\nEnter data for new node:");
                input = inputReader.readLine();
                if (stringList.isEmpty() || input.compareTo(stringList.getFirst().linkData) < 0)
                    {
                      stringList.insertFirst(input);
                      System.out.println("\nNode " + input.toString() + " inserted at beginning of list");
                    }
                else
                    System.out.println("\nNode " + input.toString() + " cannot be inserted at beginning of list");
                
                if (continuePrompt())
                    return true;
                else
                    return false;
            case "4":
                System.out.println("\nEnter data for new node:");
                input = inputReader.readLine();
                if (input.compareTo(stringList.getLast().linkData) > 0)
                    {
                      stringList.insertLast(input);
                      System.out.println("\nNode " + input.toString() + " inserted at end of list");
                    }
                else
                    System.out.println("\nNode " + input.toString() + " cannot be inserted at end of list");
                
                if (continuePrompt())
                    return true;
                else
                    return false;
            case "5":
                if (stringList.isEmpty())
                    System.out.println("\nNo nodes available for deletion"); //end if
                else
                  {
                    System.out.println("\nEnter node to be deleted:");
                    input = inputReader.readLine();
                    
                    if (stringList.deleteKey(input) != null)
                        System.out.println("\nNode " + input + " deleted: "); // end if
                    else
                        System.out.println("\nNode " + input + " not found"); // end else
                  } // end else
                
                if (continuePrompt())
                    return true;
                else
                    return false;
            case "6":
                if (stringList.isEmpty())
                    System.out.println("No nodes in list"); // end if
                else
                  {
                    System.out.println("\nEnter data for new node:");
                    String data = inputReader.readLine();
                    System.out.println("\nEnter node to insert after:");
                    String node = inputReader.readLine();
                    if (stringList.insertAfter(node, data))
                        System.out.println("\nNode " + data + " inserted after node " + node); // end if
                    else
                        System.out.println("\nNode " + node + " not found"); // end else
                  } // end else
                
                if (continuePrompt())
                    return true;
                else
                    return false;
            case "7":
                printList(1);
                if (continuePrompt())
                    return true;
                else
                    return false;
            case "8":
                return false;
            default:
                return true;
          } // end switch
      } // end select()
    
    /**
     * Asks user whether or not to continue
     * @param None
     * @return User's answer
     * @throws IOException 
     */
    public boolean continuePrompt() throws IOException
      {
        String input;
        boolean choice = false;
        boolean repeat = true;
        
        // Loop until user enters a valid answer
        while (repeat)
          {
            System.out.println("\nDo you wish to continue? (Y/N)");
            input = inputReader.readLine();
            
            if (input.compareToIgnoreCase("Y") == 0 || input.compareToIgnoreCase("Yes") == 0)
              {
                choice = true;
                repeat = false;
              }
            else if (input.compareToIgnoreCase("N") == 0 || input.compareToIgnoreCase("No") == 0)
              {
                choice = false;
                repeat = false;
              }
            else
                repeat = true;
          } // end while
        
        return choice;
      } //end continuePrompt()

  } // end class ListControl
