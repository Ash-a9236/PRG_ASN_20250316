package asha9236.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Log {
    private String id;
    private String crewMember;
    private Date date;
    private String message;

//CONSTRUCTOR///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Log (String crewMember, String message) {
        this.id = "L" + dateFormatter();
        this.crewMember = crewMember;
        this.date = new Date();
        this.message = message;
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

    public String getCrewMember() {
        return crewMember;
    }

    public void setCrewMember(String crewMember) {
        this.crewMember = crewMember;
    }

    public Date getDate() {
        return date;
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
        Log log = (Log) o;
        return Objects.equals(id, log.id) && Objects.equals(crewMember, log.crewMember)
                && Objects.equals(date, log.date) && Objects.equals(message, log.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, crewMember, date, message);
    }

    @Override
    public String toString() {
        return "LOG " + id +
                "\n    " + date +
                "\n    Crew Member : " + crewMember +
                "\n    Message : " + message;
    }
}
