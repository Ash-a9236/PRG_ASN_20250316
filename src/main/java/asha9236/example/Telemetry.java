package asha9236.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Telemetry {
    private String id;
    private Date date;
    private String oxygenLevel;

//CONSTRUCTOR///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Telemetry(String oxygenLevel) {
        this.id = "T" + dateFormatter();
        this.date = new Date();
        this.oxygenLevel = oxygenLevel + "%";
    }

    public String dateFormatter() {
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

    public String getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(String oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Telemetry telemetry = (Telemetry) o;
        return Objects.equals(id, telemetry.id) && Objects.equals(date, telemetry.date)
                && Objects.equals(oxygenLevel, telemetry.oxygenLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, oxygenLevel);
    }

    @Override
    public String toString() {
        return "TELEMETRY " + id +
                "\n    " + date +
                "\n    Oxygen level : " + oxygenLevel;
    }
}
