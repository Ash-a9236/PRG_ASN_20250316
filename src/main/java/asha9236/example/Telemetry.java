package asha9236.example;

import java.util.Date;

public class Telemetry {
    private String id;
    private Date date;
    private String oxygenLevel;


    public Telemetry (Date date, String oxygenLevel) {
        this.id = "T";
        this.date = date;
        this.oxygenLevel = oxygenLevel;
    }
}
