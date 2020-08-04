package com.Anita.babysitter.util;

import java.util.ArrayList;

public final class TimeMap {

    // class that maps a time string to a number using 2 corresponding ArrayList's.
    // TIME_LIST and NUMBER_LIST are corresponding ArrayList's where the ith
    // element of TIME_LIST corresponds to the ith element of NUMBER_LIST;
    // These lists hold the valid times for start, bedtime, and end times.
    // Times (in format 'HH:MM PM') are mapped to numbers to simply
    // calculations.

    // This class also contains constants used to define valid time ranges

    public final static ArrayList<String> TIME_LIST = new ArrayList<>();
    private final static ArrayList<Integer> NUMBER_LIST = new ArrayList<>();

    public final static int MIN_VALID_START_TIME;
    public final static int MAX_VALID_START_TIME;
    public final static int MIN_VALID_BEDTIME_TIME;
    public final static int MAX_VALID_BEDTIME_TIME;
    public final static int MIN_VALID_END_TIME;
    public final static int MAX_VALID_END_TIME;

    public final static String MIN_VALID_START_TIME_STR;
    public final static String MAX_VALID_START_TIME_STR;
    public final static String MIN_VALID_BEDTIME_TIME_STR;
    public final static String MAX_VALID_BEDTIME_TIME_STR;
    public final static String MIN_VALID_END_TIME_STR;
    public final static String MAX_VALID_END_TIME_STR;

    private final static int MIN_START_TIME_INDEX;
    private final static int MAX_START_TIME_INDEX;
    private final static int MIN_BED_TIME_INDEX;
    private final static int MAX_BED_TIME_INDEX;
    private final static int MIN_END_TIME_INDEX;
    private final static int MAX_END_TIME_INDEX;

    static {
        TIME_LIST.add("05:00 PM");  // NUMBER = 1
        TIME_LIST.add("06:00 PM");  // NUMBER = 2
        TIME_LIST.add("07:00 PM");  // NUMBER = 3
        TIME_LIST.add("08:00 PM");  // NUMBER = 4
        TIME_LIST.add("09:00 PM");  // NUMBER = 5
        TIME_LIST.add("10:00 PM");  // NUMBER = 6
        TIME_LIST.add("11:00 PM");  // NUMBER = 7
        TIME_LIST.add("12:00 AM");  // NUMBER = 8
        TIME_LIST.add("01:00 AM");  // NUMBER = 9
        TIME_LIST.add("02:00 AM");  // NUMBER = 10
        TIME_LIST.add("03:00 AM");  // NUMBER = 11
        TIME_LIST.add("04:00 AM");  // NUMBER = 12
        NUMBER_LIST.add(1);
        NUMBER_LIST.add(2);
        NUMBER_LIST.add(3);
        NUMBER_LIST.add(4);
        NUMBER_LIST.add(5);
        NUMBER_LIST.add(6);
        NUMBER_LIST.add(7);
        NUMBER_LIST.add(8);
        NUMBER_LIST.add(9);
        NUMBER_LIST.add(10);
        NUMBER_LIST.add(11);
        NUMBER_LIST.add(12);

        MIN_START_TIME_INDEX = 0;
        MAX_START_TIME_INDEX = 10;
        MIN_BED_TIME_INDEX = 0;
        MAX_BED_TIME_INDEX = 11;
        MIN_END_TIME_INDEX = 1;
        MAX_END_TIME_INDEX = 11;


        // these constants are initialized with the values from the TIME_LIST and NUMBER_LIST
        // and using the indexes defined above
        MIN_VALID_START_TIME = NUMBER_LIST.get(MIN_START_TIME_INDEX);
        MAX_VALID_START_TIME = NUMBER_LIST.get(MAX_START_TIME_INDEX);
        MIN_VALID_BEDTIME_TIME = NUMBER_LIST.get(MIN_BED_TIME_INDEX);
        MAX_VALID_BEDTIME_TIME = NUMBER_LIST.get(MAX_BED_TIME_INDEX);
        MIN_VALID_END_TIME = NUMBER_LIST.get(MIN_END_TIME_INDEX);
        MAX_VALID_END_TIME = NUMBER_LIST.get(MAX_END_TIME_INDEX);

        MIN_VALID_START_TIME_STR = TIME_LIST.get(MIN_START_TIME_INDEX);
        MAX_VALID_START_TIME_STR = TIME_LIST.get(MAX_START_TIME_INDEX);
        MIN_VALID_BEDTIME_TIME_STR = TIME_LIST.get(MIN_BED_TIME_INDEX);
        MAX_VALID_BEDTIME_TIME_STR = TIME_LIST.get(MAX_BED_TIME_INDEX);
        MIN_VALID_END_TIME_STR = TIME_LIST.get(MIN_END_TIME_INDEX);
        MAX_VALID_END_TIME_STR = TIME_LIST.get(MAX_END_TIME_INDEX);
    }

    private TimeMap(){}

    // returns the number that maps to timeStr or 0 if timeStr is not found
    public static int map(String timeStr){

        for(int i = 0; i < TIME_LIST.size(); i++ ){
            if(TIME_LIST.get(i).equals(timeStr)){
                return NUMBER_LIST.get(i);
            }
        }
        return 0;
    }

    // returns the time string that maps to number or "0" if number is not found
    public static String map(Integer number){

        for(int i = 0; i < NUMBER_LIST.size(); i++ ){
            if(NUMBER_LIST.get(i).equals(number)){
                return TIME_LIST.get(i);
            }
        }
        return "0";
    }

    // get list of valid times for Start Times
    public static ArrayList<String> getStartTimeList(){

        // copy the values from the TIME_LIST that are valid start times
        ArrayList<String> timeList = new ArrayList<>();
        for(int i = MIN_START_TIME_INDEX; i <= MAX_START_TIME_INDEX; i++ ){
            timeList.add(TIME_LIST.get(i)) ;
        }

        return timeList;
    }

    // get list of valid numbers for Start Times
    public static ArrayList<Integer> getStartNumberList(){

        // copy the values from the NUMBER_LIST that map to valid start times
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = MIN_START_TIME_INDEX; i <= MAX_START_TIME_INDEX; i++ ){
            numberList.add(NUMBER_LIST.get(i)) ;
        }

        return numberList;
    }

    // get list of valid times for Bed Times
    public static ArrayList<String> getBedTimeList(){

        // copy the values from the TIME_LIST that are valid bed times
        ArrayList<String> timeList = new ArrayList<>();
        for(int i = MIN_BED_TIME_INDEX; i <= MAX_BED_TIME_INDEX; i++ ){
            timeList.add(TIME_LIST.get(i)) ;
        }

        return timeList;
    }

    // get list of valid numbers for Bed Times
    public static ArrayList<Integer> getBedNumberList(){

        // copy the values from the NUMBER_LIST that map to valid bed times
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = MIN_BED_TIME_INDEX; i <= MAX_BED_TIME_INDEX; i++ ){
            numberList.add(NUMBER_LIST.get(i)) ;
        }

        return numberList;
    }

    // get list of valid times for End Times
    public static ArrayList<String> getEndTimeList(){

        // copy the values from the TIME_LIST that are valid bed times
        ArrayList<String> timeList = new ArrayList<>();
        for(int i = MIN_END_TIME_INDEX; i <= MAX_END_TIME_INDEX; i++ ){
            timeList.add(TIME_LIST.get(i)) ;
        }

        return timeList;
    }

    // get list of valid numbers for End Times
    public static ArrayList<Integer> getEndNumberList(){

        // copy the values from the NUMBER_LIST that map to valid end times
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = MIN_END_TIME_INDEX; i <= MAX_END_TIME_INDEX; i++ ){
            numberList.add(NUMBER_LIST.get(i)) ;
        }

        return numberList;
    }

}
