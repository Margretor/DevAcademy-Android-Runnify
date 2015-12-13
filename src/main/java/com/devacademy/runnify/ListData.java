package com.devacademy.runnify;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by darke on 09.12.2015.
 */
public class ListData {
    private Date date;
    private String km;
    private String timeRound;
    private String totalTime;
    private ArrayList<Integer> iconId;

    public ListData(Date date, String km, String timeRound, String totalTime, ArrayList<Integer> iconId) {
        this.date = date;
        this.km = km;
        this.timeRound = timeRound;
        this.totalTime = totalTime;
        this.iconId = iconId;
    }

    public Date getDate(){
        return date;
    }

    public String getKm() {
        return km;
    }

    public String getTimeRound() {
        return timeRound;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public ArrayList<Integer> getIconid() {
        return iconId;
    }
}
