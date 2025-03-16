package asha9236.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Sensor {
    private String id;
    private Date date;
    private String temperature;

//CONSTRUCTOR///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Sensor (String temperature) {
        this.id = "S" + dateFormatter();
        this.date = new Date(); //date input in YYYYMMDD
        this.temperature = temperature + "°C";
    }

    public String dateFormatter () {
        //since we are in space : need to specify the time zone
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.HHmmssSSS");
        String formattedDate = now.format(formatter);

        return formattedDate;
    }

//BASE METHODS//////////////////////////////////////////////////////////////////////////////////////////////////////////


    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id) && Objects.equals(date, sensor.date) && Objects.equals(temperature, sensor.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, temperature);
    }

    @Override
    public String toString() {
        return "SENSOR " + id +
                "\n    " + date +
                "\n    temperature : " + temperature;
    }
}
