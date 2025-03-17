package asha9236.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class LeafNode extends TreeNode {
    private Values data;

//CONSTRUCTORS//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public LeafNode (Values data) { //base constructor
        this.value = dateFormatter();
        this.data = data;
    }

//@OVERRIDE/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean isLeaf() { //returns true because leaf nodes only hold information
        return true;
    }

//HELPER METHODS////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String dateFormatter () {
        //since we are in space : need to specify the time zone
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.HHmmssSSS");
        String formattedDate = now.format(formatter);

        return formattedDate;
    }

//BASE METHODS//////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void setData(Values data) {
        this.data = data;
    }

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
