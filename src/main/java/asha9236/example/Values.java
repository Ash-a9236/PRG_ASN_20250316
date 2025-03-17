package asha9236.example;

import java.util.Date;
import java.util.Objects;

public class Values {
    protected Date date;

    public Values () {
        this.date = new Date(); //date input in YYYYMMDD
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Values values = (Values) o;
        return Objects.equals(date, values.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date);
    }
}
