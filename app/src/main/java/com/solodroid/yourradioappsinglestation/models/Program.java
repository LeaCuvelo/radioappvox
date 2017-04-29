package com.solodroid.yourradioappsinglestation.models;

/**
 * Created by leandro.luis.cuvelo on 4/25/2017.
 */

public class Program {

    private String hours, title, day;

    public Program(String hours, String title, String day) {
        this.hours = hours;
        this.title = title;
        this.day = day;
    }

    public Program() {

    }


    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
