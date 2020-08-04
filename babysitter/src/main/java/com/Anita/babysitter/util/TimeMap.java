package com.Anita.babysitter.util;

import java.util.ArrayList;

public final class TimeMap {

    // class that maps a time string to a number using 2 corresponding ArrayList's.
    // *_TIME_LIST and *_NUMBER_LIST are corresponding ArrayList's where the ith
    // element of *_TIME_LIST corresponds to the ith element of *_NUMBER_LIST;
    // These lists hold the valid times for start, bedtime, and end times.

    // This class also contains constants used to define valid time ranges

    public final static ArrayList<String> START_TIME_LIST = new ArrayList<>();
    private final static ArrayList<Integer> START_NUMBER_LIST = new ArrayList<>();
    public final static ArrayList<String> BED_TIME_LIST = new ArrayList<>();
    private final static ArrayList<Integer> BED_NUMBER_LIST = new ArrayList<>();
    public final static ArrayList<String> END_TIME_LIST = new ArrayList<>();
    private final static ArrayList<Integer> END_NUMBER_LIST = new ArrayList<>();
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
    public final static int TIME_VALUE_NOT_SELECTED = 0;

    static {
        START_TIME_LIST.add("05:00 PM");  // NUMBER = 1
        START_TIME_LIST.add("06:00 PM");  // NUMBER = 2
        START_TIME_LIST.add("07:00 PM");  // NUMBER = 3
        START_TIME_LIST.add("08:00 PM");  // NUMBER = 4
        START_TIME_LIST.add("09:00 PM");  // NUMBER = 5
        START_TIME_LIST.add("10:00 PM");  // NUMBER = 6
        START_TIME_LIST.add("11:00 PM");  // NUMBER = 7
        START_TIME_LIST.add("12:00 AM");  // NUMBER = 8
        START_TIME_LIST.add("01:00 AM");  // NUMBER = 9
        START_TIME_LIST.add("02:00 AM");  // NUMBER = 10
        START_TIME_LIST.add("03:00 AM");  // NUMBER = 11

        START_NUMBER_LIST.add(1);
        START_NUMBER_LIST.add(2);
        START_NUMBER_LIST.add(3);
        START_NUMBER_LIST.add(4);
        START_NUMBER_LIST.add(5);
        START_NUMBER_LIST.add(6);
        START_NUMBER_LIST.add(7);
        START_NUMBER_LIST.add(8);
        START_NUMBER_LIST.add(9);
        START_NUMBER_LIST.add(10);
        START_NUMBER_LIST.add(11);

        BED_TIME_LIST.add("05:00 PM");  // NUMBER = 1
        BED_TIME_LIST.add("06:00 PM");  // NUMBER = 2
        BED_TIME_LIST.add("07:00 PM");  // NUMBER = 3
        BED_TIME_LIST.add("08:00 PM");  // NUMBER = 4
        BED_TIME_LIST.add("09:00 PM");  // NUMBER = 5
        BED_TIME_LIST.add("10:00 PM");  // NUMBER = 6
        BED_TIME_LIST.add("11:00 PM");  // NUMBER = 7
        BED_TIME_LIST.add("12:00 AM");  // NUMBER = 8
        BED_TIME_LIST.add("01:00 AM");  // NUMBER = 9
        BED_TIME_LIST.add("02:00 AM");  // NUMBER = 10
        BED_TIME_LIST.add("03:00 AM");  // NUMBER = 11
        BED_TIME_LIST.add("04:00 AM");  // NUMBER = 12

        BED_NUMBER_LIST.add(1);
        BED_NUMBER_LIST.add(2);
        BED_NUMBER_LIST.add(3);
        BED_NUMBER_LIST.add(4);
        BED_NUMBER_LIST.add(5);
        BED_NUMBER_LIST.add(6);
        BED_NUMBER_LIST.add(7);
        BED_NUMBER_LIST.add(8);
        BED_NUMBER_LIST.add(9);
        BED_NUMBER_LIST.add(10);
        BED_NUMBER_LIST.add(11);
        BED_NUMBER_LIST.add(12);

        END_TIME_LIST.add("06:00 PM");  // NUMBER = 1
        END_TIME_LIST.add("07:00 PM");  // NUMBER = 2
        END_TIME_LIST.add("08:00 PM");  // NUMBER = 3
        END_TIME_LIST.add("09:00 PM");  // NUMBER = 4
        END_TIME_LIST.add("10:00 PM");  // NUMBER = 5
        END_TIME_LIST.add("11:00 PM");  // NUMBER = 6
        END_TIME_LIST.add("12:00 AM");  // NUMBER = 7
        END_TIME_LIST.add("01:00 AM");  // NUMBER = 8
        END_TIME_LIST.add("02:00 AM");  // NUMBER = 9
        END_TIME_LIST.add("03:00 AM");  // NUMBER = 10
        END_TIME_LIST.add("04:00 AM");  // NUMBER = 11

        END_NUMBER_LIST.add(1);
        END_NUMBER_LIST.add(2);
        END_NUMBER_LIST.add(3);
        END_NUMBER_LIST.add(4);
        END_NUMBER_LIST.add(5);
        END_NUMBER_LIST.add(6);
        END_NUMBER_LIST.add(7);
        END_NUMBER_LIST.add(8);
        END_NUMBER_LIST.add(9);
        END_NUMBER_LIST.add(10);
        END_NUMBER_LIST.add(11);

        // these constants are initialized with the values from the start and end of the list
        MIN_VALID_START_TIME = START_NUMBER_LIST.get(0);
        MAX_VALID_START_TIME = START_NUMBER_LIST.get(START_NUMBER_LIST.size()-1);
        MIN_VALID_BEDTIME_TIME = BED_NUMBER_LIST.get(0);
        MAX_VALID_BEDTIME_TIME = BED_NUMBER_LIST.get(BED_NUMBER_LIST.size()-1);
        MIN_VALID_END_TIME = END_NUMBER_LIST.get(0);
        MAX_VALID_END_TIME = END_NUMBER_LIST.get(END_NUMBER_LIST.size()-1);
        MIN_VALID_START_TIME_STR = START_TIME_LIST.get(0);
        MAX_VALID_START_TIME_STR = START_TIME_LIST.get(START_TIME_LIST.size()-1);
        MIN_VALID_BEDTIME_TIME_STR = BED_TIME_LIST.get(0);
        MAX_VALID_BEDTIME_TIME_STR = BED_TIME_LIST.get(BED_TIME_LIST.size()-1);
        MIN_VALID_END_TIME_STR = END_TIME_LIST.get(0);
        MAX_VALID_END_TIME_STR = END_TIME_LIST.get(END_TIME_LIST.size()-1);
    }

    private TimeMap(){}

    // returns the number that maps to timeStr or 0 if timeStr is not found
    public static int getStartNumber(String timeStr){

        for(int i = 0; i < START_TIME_LIST.size(); i++ ){
            if(START_TIME_LIST.get(i).equals(timeStr)){
                return START_NUMBER_LIST.get(i);
            }
        }
        return 0;
    }

    // returns the time string that maps to number or "0" if number is not found
    public static String getStartTime(Integer number){

        for(int i = 0; i < START_NUMBER_LIST.size(); i++ ){
            if(START_NUMBER_LIST.get(i).equals(number)){
                return START_TIME_LIST.get(i);
            }
        }
        return "0";
    }

    // returns the number that maps to timeStr or 0 if timeStr is not found
    public static int getBedNumber(String timeStr){

        for(int i = 0; i < START_TIME_LIST.size(); i++ ){
            if(START_TIME_LIST.get(i).equals(timeStr)){
                return START_NUMBER_LIST.get(i);
            }
        }
        return 0;
    }

    // returns the time string that maps to number or "0" if number is not found
    public static String getBedTime(Integer number){

        for(int i = 0; i < START_NUMBER_LIST.size(); i++ ){
            if(START_NUMBER_LIST.get(i).equals(number)){
                return START_TIME_LIST.get(i);
            }
        }
        return "0";
    }

    // returns the number that maps to timeStr or 0 if timeStr is not found
    public static int getEndNumber(String timeStr){

        for(int i = 0; i < START_TIME_LIST.size(); i++ ){
            if(START_TIME_LIST.get(i).equals(timeStr)){
                return START_NUMBER_LIST.get(i);
            }
        }
        return 0;
    }

    // returns the time string that maps to number or "0" if number is not found
    public static String getEndTime(Integer number){

        for(int i = 0; i < START_NUMBER_LIST.size(); i++ ){
            if(START_NUMBER_LIST.get(i).equals(number)){
                return START_TIME_LIST.get(i);
            }
        }
        return "0";
    }

}
