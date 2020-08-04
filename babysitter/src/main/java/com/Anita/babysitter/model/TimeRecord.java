package com.Anita.babysitter.model;

import com.Anita.babysitter.util.TimeMap;

public class TimeRecord {
    // ==================================================================================================
    // See comments static initialization code from the TimeMap class
    // to understand how times values are stored
    // ==================================================================================================

    private int startTime;
    private int bedTime;
    private int endTime;

    public TimeRecord(int startTime, int bedTime, int endTime){
        this.startTime = startTime;
        this.bedTime = bedTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getBedTime() {
        return bedTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "TimeRecord{" +
                "startTime=" + startTime + " -> " + TimeMap.map(startTime) +
                ", bedTime=" + bedTime + " -> " + TimeMap.map(bedTime) +
                ", endTime=" + endTime + " -> " + TimeMap.map(endTime) +
                '}';
    }

}
