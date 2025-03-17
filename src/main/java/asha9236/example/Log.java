package asha9236.example;

import java.util.Date;
import java.util.Objects;

public class Log extends Values {
    private String crewMember;
    private String message;

//CONSTRUCTOR///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Log (String crewMember, String message) {
        this.id = "L" + dateFormatter();
        this.crewMember = crewMember;
        this.date = new Date();
        this.message = message;
    }

//BASE METHODS//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getCrewMember() {
        return crewMember;
    }

    public void setCrewMember(String crewMember) {
        this.crewMember = crewMember;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Log log = (Log) o;
        return Objects.equals(crewMember, log.crewMember) && Objects.equals(message, log.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), crewMember, message);
    }

    @Override
    public String toString() {
        return "LOG " + id +
                "\n    " + date +
                "\n    Crew Member : " + crewMember +
                "\n    Message : " + message;
    }
}
