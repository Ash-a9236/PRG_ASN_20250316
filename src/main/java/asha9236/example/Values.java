package asha9236.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Values {
    protected String id;
    protected Date date;

    public Values () {
        this.id = dateFormatter();
        this.date = new Date(); //date input in YYYYMMDD
    }

    public String dateFormatter () {
        //since we are in space : need to specify the time zone
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.HHmmssSSS");
        String formattedDate = now.format(formatter);

        return formattedDate;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Values values = (Values) o;
        return Objects.equals(id, values.id) && Objects.equals(date, values.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
