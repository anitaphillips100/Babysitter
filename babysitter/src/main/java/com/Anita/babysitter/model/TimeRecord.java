package com.Anita.babysitter.model;

public class TimeRecord {
    int startTime;
    String startAmOrPm;
    int bedTime;
    String bedAmOrPm;
    int endTime;
    String endAmOrPm;

    public TimeRecord(int startTime, String startAmOrPm, int bedTime, String bedAmOrPm, int endTime, String endAmOrPm) {
        this.startTime = startTime;
        this.startAmOrPm = startAmOrPm;
        this.bedTime = bedTime;
        this.bedAmOrPm = bedAmOrPm;
        this.endTime = endTime;
        this.endAmOrPm = endAmOrPm;
    }
}
