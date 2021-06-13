package org.example;

import java.util.Date;

public class Data {
    private Date date;
    private int temperature;

    public Data(Date date, int temperature){
        this.date = date;
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public int getTemperature() {
        return temperature;
    }
}
