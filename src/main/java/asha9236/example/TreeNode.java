package asha9236.example;

public abstract class TreeNode {
    protected String value;

    public TreeNode () {
        this.value = null;
    }

    public TreeNode (String value) {
        this.value = value;
    }

    public abstract boolean isLeaf ();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
