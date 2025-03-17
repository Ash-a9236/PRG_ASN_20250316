package asha9236.example;

import java.util.ArrayList;

public class BranchNode extends TreeNode {
    ArrayList<TreeNode> children;

//CONSTRUCTORS//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public BranchNode (String value) { //base constructor
        this.value = value;
        this.children = null;
    }

    public BranchNode (String value, int childrenNumber) { //constructor to initialize the ArrayList
        this.value = value;
        this.children = new ArrayList<>(childrenNumber);
    }

//@OVERRIDE/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean isLeaf() { //returns false because branch nodes cannot hold information
        return false;
    }
//HELPER METHODS////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * adds a new child Node to the tree
     * @param newChild the new Node
     */
    public void addChild (TreeNode newChild) {
        children.add(newChild);
    }

    /**
     * removes a child Node from the tree through the value
     * @param value the value of the child Node to delete (e.g. March : value = 03
     */
    public void removeChild (String value) {
        if (getChildNode(value) == null) {
            System.out.println("[ERROR : NO NODE FOUND]");
        } else {
            for (int i = 0; i < children.size(); i++) {
                if (getChildNode(value).equals(children.get(i).value)) {
                    children.remove(i);
                    System.out.println("Node removed from system");
                }
            }
        }
    }

    /**
     * gets a child node though the value of it
     * @param value the value to match
     * @return the child node
     */
    public TreeNode getChildNode (String value) {
        for (TreeNode child : children) {
            if (child.value.equals(value)) {
                return child;
            }
        }
        return null;
    }
}
