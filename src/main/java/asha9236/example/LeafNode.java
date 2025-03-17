package asha9236.example;

import java.util.ArrayList;
import java.util.Objects;

public class LeafNode extends TreeNode {
    private Values data;

//CONSTRUCTORS//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public LeafNode (Values data) { //base constructor
        this.value = value;
        this.data = data;
    }

//@OVERRIDE/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean isLeaf() { //returns true because leaf nodes only hold information
        return true;
    }
//HELPER METHODS////////////////////////////////////////////////////////////////////////////////////////////////////////
    //none lol

//BASE METHODS//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Values getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LeafNode leafNode = (LeafNode) o;
        return Objects.equals(data, leafNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
