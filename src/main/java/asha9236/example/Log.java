package asha9236.example;

import java.util.Date;

public class Log {
    private String id;
    private String crewMember;
    private Date date;
    private String message;


    public Log (String crewMember, Date date, String message) {
        this.id = "L";
        this.crewMember = crewMember;
        this.date = date;
        this.message = message;
    }
}
