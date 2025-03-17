package asha9236.example;

import java.util.Date;
import java.util.Objects;

public class Sensor extends Values {
    private String temperature;

//CONSTRUCTOR///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Sensor (String temperature) {
        this.id = "S" + dateFormatter();
        this.date = new Date();
        this.temperature = temperature + "°C";
    }

//BASE METHODS//////////////////////////////////////////////////////////////////////////////////////////////////////////

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
        return Objects.equals(temperature, sensor.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(temperature);
    }

    @Override
    public String toString() {
        return "SENSOR " + id +
                "\n    " + date +
                "\n    temperature : " + temperature;
    }
}
