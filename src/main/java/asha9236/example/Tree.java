package asha9236.example;

public class Tree {
    private BranchNode root;

//CONSTRUCTORS//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Tree () {
        this.root = new BranchNode("ROOT");
    }

//HELPER METHODS////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * inserts new leaf nodes (logs) in respective branches
     * @param data the new data to insert
     */
    public void insertData (Values data) {
        LeafNode tempLeaf = new LeafNode(data);
        String id = tempLeaf.getValue();
        String[] idParts = id.split("\\."); /*splits the id by the dots but in java dots are for any characters
        and \ are special characters as well so we need to add two \ to make the dot valid*/

        BranchNode current = root; //initialize at root to traverse

        for (int i = 0; i < 3; i++) { //goes to 3 to not waste space : yyyy.mm.dd
            String idPart = idParts[i];
            TreeNode child = current.getChildNode(idPart);

            if (child == null) { //if the branch node(s) does not exist, create it
                child = new BranchNode(idPart);
                current.addChild(child);
            }

            current = (BranchNode) child; //move one position
        }

        current.addChild(new LeafNode(data)); //add the leaf node
    }

    /**
     * searches through the tree for a leaf nodes
     * @param id the id of the node to search for
     * @return the Value of the node if the node is found, or null if the node is not found
     */
    public Values searchLeafNode (String id) {
        String[] idParts = id.split("\\."); /*splits the id by the dots but in java dots are for any characters
        and \ are special characters as well so we need to add two \ to make the dot valid*/

        BranchNode current = root; //initialize at root to traverse

        for (int i = 0; i < 3; i++) {
            current = (BranchNode) current.getChildNode(idParts[i]);
            if (current == null) {
                System.out.println("[ERROR : NO NODE FOUND]");
                return null;
            }
        }

        TreeNode tempLeaf = current.getChildNode(id);

        if (tempLeaf != null && tempLeaf.isLeaf()) {
            return ((LeafNode) tempLeaf).getData();
        }

        return null;
    }

    /**
     * deletes a node and cleans up the tree if needed
     * @param id the id of the node to delete
     * @return true if the node is deleted
     */
    public boolean deleteLeafNode(String id) {
        String[] idParts = id.split("\\.");
        BranchNode current = root;

        /**
         * Traverse the tree to find the parent of the leaf node
         */
        for (int i = 0; i < 3; i++) { // Only go up to days (yyyy, MM, dd)
            current = (BranchNode) current.getChildNode(idParts[i]);
            if (current == null) {
                System.out.println("[ERROR : NODE NOT FOUND]");
                return false; // Not found
            }
        }

        // Find and remove the leaf node
        TreeNode leafNode = current.getChildNode(id);
        if (leafNode != null && leafNode.isLeaf()) {
            current.getChildren().remove(leafNode); // Remove the leaf node
            cleanUpTree(current); // Clean up empty internal nodes
            return true; // Successfully deleted
        }

        return false; // Leaf node not found
    }

    /**
     * cleans up the tree if a certain branch nodes does not have any child node
     * @param node the node to clean up
     */
    private void cleanUpTree(BranchNode node) {
        if (node.getChildren().isEmpty() && !node.value.equals("root")) {
            // Find the parent of this node
            BranchNode parent = findParent(root, node);
            if (parent != null) {
                parent.getChildren().remove(node); // Remove the empty node
                cleanUpTree(parent); // Recursively clean up
            }
        }
    }

    /**
     * finds the parent of a node
     * @param current the current node
     * @param target the target node
     * @return the parent of the node
     */
    private BranchNode findParent(BranchNode current, TreeNode target) {
        for (TreeNode child : current.getChildren()) {
            if (child == target) {
                return current; // Found the parent
            }
            if (!child.isLeaf()) {
                BranchNode result = findParent((BranchNode) child, target);
                if (result != null) {
                    return result; // Found the parent in the subtree
                }
            }
        }
        return null; // Parent not found
    }

    // Print the tree
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(TreeNode node, int depth) {
        if (node == null) return;

        // Indent based on depth
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.print(node.value);

        // Print leaf value if this is a leaf node
        if (node.isLeaf()) {
            System.out.print("\n -> " + ((LeafNode) node).getData().toString());
        }

        // Recursively print children (only for internal nodes)
        if (!node.isLeaf()) {
            BranchNode branch = (BranchNode) node;
            for (TreeNode child : BranchNode.children) {
                printTree(child, depth + 1);
            }
        }
    }

//BASE METHODS//////////////////////////////////////////////////////////////////////////////////////////////////////////

}
