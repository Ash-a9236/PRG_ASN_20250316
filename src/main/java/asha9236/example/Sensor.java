package asha9236.example;

import java.util.Date;

public class Sensor {
    private String id;
    private Date date;
    private String temperature;


    public Sensor (Date date, String temperature) {
        this.id = "S";
        this.date = date;
        this.temperature = temperature;
    }
}
