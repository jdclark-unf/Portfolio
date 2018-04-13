/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project4justinclark;

/**
  * Defines a tree of Country objects
  * @author Justin Clark <n00882194@ospreys.unf.edu>
  */
public class Tree 
  {
    public Node root;
        
    public Tree()
      {
        root = null;
      } //end constructor
    
    /**
     * Finds a specific node of the tree
     * @param key Name of desired node
     * @return specified node
     */
    public Node find(String key)
      {
        Node current = root;
        
        while (current.countryData.getName().compareTo(key) != 0)
          {
            if (current.countryData.getName().compareTo(key) < 0)
                current = current.leftChild; // end if
            else
                current = current.rightChild; //end else
            
            if (current == null)
                return null; // end if
          } // end while
        
        return current;
      } // end find()
    
    /**
     * Inserts a new country into the tree
     * @param currentCountry 
     * @return Nothing
     */
    public void insert(Country currentCountry)
      {
        Node newNode = new Node();
        newNode.countryData = currentCountry;
        
        if (root == null)
            root = newNode; // end if
        else
          {
            Node current = root;
            Node parent;
            
            while (true)
              {
                parent = current;
                
                if (current.countryData.getName().compareTo(currentCountry.getName()) > 0)
                  {
                    current = current.leftChild;
                    
                    if (current == null)
                      {
                        parent.leftChild = newNode;
                        return;
                      } // end inner if
                  } // end outer if
                else
                  {
                    current = current.rightChild;
                      
                    if (current == null)
                      {
                        parent.rightChild = newNode;
                        return;
                      } // end if
                  } //end else
              } //end while
          } //end else
      } //end insert()
    
    /**
     * Deletes a node from the tree
     * @param key Name of node
     * @return status of deletion
     */
    public boolean delete(String key)
      {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        
        // Search for node
        while (current.countryData.getName().compareTo(key) != 0)
          {
            parent = current;
            
            if (current.countryData.getName().compareTo(key) > 0)
              {
                isLeftChild = true;
                current = current.leftChild;
              } //end if
            else
              {
                isLeftChild = false;
                current = current.rightChild;
              } //end else
            if (current == null)
                return false; //end if (node not found)
          } //end while
        
        // If node has no children, delete it
        if (current.leftChild == null && current.rightChild == null)
          {
            if (current == root)
                root = null; //end if
            else if (isLeftChild)
                parent.leftChild = null; //end else if
            else
                parent.rightChild = null; // end else
          } //end if
        
        // If node has no right child, replace with left subtree
        else if (current.rightChild == null)
          {
            if (current == root)
                root = current.leftChild; // end if
            else if (isLeftChild)
                parent.leftChild = current.leftChild; // end else if
            else
                parent.rightChild = current.rightChild; // end else
          } //end if
        
        // If node has no left child, replace with right subtree
        else if (current.leftChild == null)
          {
            if (current == root)
                root = current.rightChild; // end if
            else if (isLeftChild)
                parent.leftChild = current.rightChild; // end else if
            else
                parent.rightChild = current.rightChild; // end else
          } //end if
        
        // If node has two children, replace with in-order successor
        else
          {
            Node successor = getSuccessor(current);
            
            if (current == root)
                root = successor; //end if
            else if (isLeftChild)
                parent.leftChild = successor; //end else if
            else
                parent.rightChild = successor; // end else
            
            successor.leftChild = current.leftChild;
          } // end else
        
        return true;
      } //end delete()
    
    /**
     * Traverses the tree according to a prescribed scanning order
     * @param traverseType choice of scan order
     * @return Nothing
     */
    public void traverse(int traverseType)
      {
        switch (traverseType)
          {
            case 1: // Recursive NLR
                scanRecNLR(root);
                break;
            case 2: // Recursive LNR
                scanRecLNR(root);
                break;
            case 3: // Recursive LRN
                scanRecLRN(root);
                break;
            case 4: // Recursive RNL
                scanRecRNL(root);
                break;
            case 5: // Iterative LNR
                scanIterLNR(root);
                break;
            case 6: // Iterative RNL
                scanIterRNL(root);
                break;
          } // end switch
        
        System.out.println();
      } //end traverse()
    
    /**
     * Displays tree
     * @param Nothing
     * @return Nothing
     */
    public void displayTree()
      {
        Stack globalStack = new Stack(10);        
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        
        System.out.println("................................................................");
        
        while (!isRowEmpty)
          {
            Stack localStack = new Stack(10);
            isRowEmpty = true;
            
            for (int i = 0; i < nBlanks; i++)
                System.out.print(' ');
            
            while (!globalStack.isEmpty())
              {
                Node temp = (Node)globalStack.pop();
                
                if (temp != null)
                  {
                    System.out.print(temp.countryData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    
                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false; // end inner if
                  } // end outer if
                else
                  {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                  } // end else
                
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' '); // end for
              } // end inner while
            
            System.out.println();
            nBlanks /= 2;
            
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop()); //end inner while            
          } // end outer while
        
        System.out.println("................................................................");
      } //end displayTree()
    
    /**
     * Determines next in-order successor of node to be deleted
     * @param delNode node marked for deletion
     * @return in-order successor
     */
    private Node getSuccessor(Node delNode)
      {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        
        while (current != null)
          {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
          } //end while
        
        if (successor != delNode.rightChild)
          {
            successorParent.leftChild = successorParent.rightChild;
            successor.rightChild = delNode.rightChild;
          } // end if
        
        return successor;
      } //end getSuccessor()
    
    /**
     * Performs a recursive NLR scan on tree
     * @param localRoot root of current subtree
     * @return Nothing
     */
    private void scanRecNLR(Node localRoot)
      {
        if (localRoot != null)
          {
            System.out.println(localRoot.countryData);
            scanRecNLR(localRoot.leftChild);
            scanRecNLR(localRoot.rightChild);
          } //end if
      } //end scanRecNLR()
    
    /**
     * Performs a recursive LNR scan on tree
     * @param localRoot root of current subtree
     * @return Nothing
     */
    private void scanRecLNR(Node localRoot)
      {
        if (localRoot != null)
          {
            scanRecLNR(localRoot.leftChild);
            System.out.printf("%-20s%-20s\n", localRoot.countryData.getName(), localRoot.countryData.getCapital());
            scanRecLNR(localRoot.rightChild);
          } //end if
      } //end scanRecLNR()
    
    /**
     * Perform a recursive LRN scan on tree
     * @param localRoot root of current subtree
     * @return Nothing
     */
    private void scanRecLRN(Node localRoot)
      {
        scanRecLRN(localRoot.leftChild);
        scanRecLRN(localRoot.rightChild);
        System.out.println(localRoot.countryData);
      } // end scanRecLRN()
    
    /**
     * Performs a recursive RNL scan on tree
     * @param localRoot root of current subtree
     * @return Nothing
     */
    private void scanRecRNL(Node localRoot)
      {
        if (localRoot != null)
          {
            scanRecRNL(localRoot.rightChild);
            System.out.printf("%-20s%-20s\n", localRoot.countryData.getName(), localRoot.countryData.getCapital());
            scanRecRNL(localRoot.leftChild);
          } //end if
      } //end scanRecRNL()
    
    /**
     * Performs an iterative LNR scan on tree
     * @param localRoot root of current subtree
     * @return Nothing
     */
    private void scanIterLNR(Node localRoot)
      {
        Stack scanStack = new Stack(10);
        Node current = localRoot;
        
        while (true)
          {
            if (current != null)
              {
                scanStack.push(current);
                current = current.leftChild;
              } // end if
            else
              {
                if (scanStack.isEmpty())
                    return;
                current = scanStack.pop();
                System.out.printf("%-20s%-20s\n", current.countryData.getName(), current.countryData.getCapital());
                current = current.rightChild;
              } //end else
          } // end while
      } // end scanIterLNR()
    
    /**
     * Performs an iterative RNL scan on tree
     * @param localRoot root of current subtree
     * @return Nothing
     */
    private void scanIterRNL(Node localRoot)
      {
        Stack scanStack = new Stack(10);
        Node current = localRoot;
        
        while (true)
          {
            if (current != null)
              {
                scanStack.push(current);
                current = current.rightChild;
              } // end if
            else
              {
                if (scanStack.isEmpty())
                    return;
                current = scanStack.pop();
                System.out.printf("%-20s%-20s\n", current.countryData.getName(), current.countryData.getCapital());
                current = current.leftChild;
              } //end else
          } // end while
      } // end scanIterLNR()
  } // end class Tree
