package asha9236.example;

import java.util.Date;
import java.util.Objects;

public class Telemetry extends Values {
    private String oxygenLevel;

//CONSTRUCTOR///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Telemetry(String oxygenLevel) {
        this.id = "T" + dateFormatter();
        this.date = new Date();
        this.oxygenLevel = oxygenLevel + "%";
    }

//BASE METHODS//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(String oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Telemetry telemetry = (Telemetry) o;
        return Objects.equals(oxygenLevel, telemetry.oxygenLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), oxygenLevel);
    }

    @Override
    public String toString() {
        return "TELEMETRY " + id +
                "\n    " + date +
                "\n    Oxygen level : " + oxygenLevel;
    }
}
