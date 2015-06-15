package com.applaudo.applaudoteams.model;

import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Javier Hernandez on 14/06/2015.
 */
public class ScheduleGame  {

    private String date;
    private String stadium;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

}