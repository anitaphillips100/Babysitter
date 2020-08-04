package com.Anita.babysitter.service;

import com.Anita.babysitter.model.TimeRecord;
import com.Anita.babysitter.util.CalculatorInvalidInputException;
import com.Anita.babysitter.util.ErrorMessages;
import com.Anita.babysitter.util.TimeMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculatorServiceImpl implements CalculatorService {

    // For now hourly rates are in whole dollars
    private static final int EVENING_RATE = 12;
    private static final int BED_TIME_RATE = 8;
    private static final int AFTER_MIDNIGHT_RATE = 16;
    private static final int EVENING_START = TimeMap.MIN_VALID_START_TIME;
    private static final int AFTER_MIDNIGHT_START = TimeMap.map("12:00 AM");


    @Override
    public String calculateNightlyAmount(TimeRecord timeRecord) throws CalculatorInvalidInputException {



        log.info("calculate for time record: " + timeRecord.toString() );

        // validate input
        if( !valid(timeRecord) ){
            throw new CalculatorInvalidInputException(ErrorMessages.GENERIC_INVALID_INPUT_MSG);
        }

        // calculate the amount to charge for the night
        String amount = "";
        int startTime = timeRecord.getStartTime();
        int bedTime = timeRecord.getBedTime();
        int endTime = timeRecord.getEndTime();
        int totalHours = endTime - startTime;
        int eveningHours;
        int bedTimeHours;
        int afterMidnightHours;

        if(startTime >= AFTER_MIDNIGHT_START) {
            // all hours will be charged at the after midnight rate
            amount = Integer.toString(totalHours * AFTER_MIDNIGHT_RATE);
        }else if(startTime >= bedTime){
            // child was in bed when babysitter arrived
            if(endTime <= AFTER_MIDNIGHT_START){
                // all hours are at the bed time rate
                amount = Integer.toString(totalHours * BED_TIME_RATE);
            }else{
                // combination of bed time hours and after midnight hours
                bedTimeHours = AFTER_MIDNIGHT_START - startTime;
                afterMidnightHours = endTime - AFTER_MIDNIGHT_START;
                amount = Integer.toString((bedTimeHours*BED_TIME_RATE)+(afterMidnightHours*AFTER_MIDNIGHT_RATE));
            }
        }else if( bedTime >= endTime){
            // child was not in bed at all
            if(endTime >= AFTER_MIDNIGHT_START ){
                // combination of evening hours and after midnight hours
                eveningHours = AFTER_MIDNIGHT_START - startTime;
                afterMidnightHours = endTime - AFTER_MIDNIGHT_START;
                amount = Integer.toString((eveningHours*EVENING_RATE)+(afterMidnightHours*AFTER_MIDNIGHT_RATE));
            }else{
                // all hours are at the evening rate
                eveningHours = endTime - startTime;
                amount = Integer.toString(eveningHours*EVENING_RATE);
            }
        }else{
            // there will be some bed time hours
            if(endTime <= AFTER_MIDNIGHT_START){
                // combination of evening and bedtime hours
                eveningHours = bedTime - startTime;
                bedTimeHours = endTime - bedTime;
                amount = Integer.toString((eveningHours*EVENING_RATE)+(bedTimeHours*BED_TIME_RATE));
            }else{
                // combination of time periods
                afterMidnightHours = endTime - AFTER_MIDNIGHT_START;
                bedTimeHours = AFTER_MIDNIGHT_START - bedTime;
                eveningHours = bedTime - startTime;
                amount = Integer.toString((afterMidnightHours*AFTER_MIDNIGHT_RATE)
                        +(bedTimeHours*BED_TIME_RATE)+
                        (eveningHours*EVENING_RATE));
            }
        }
        return amount+".00";
    }

    private boolean valid(TimeRecord timeRecord){
        // TODO: need some way to let user know what fields are not valid.
        // for now if anything is invalid return false
        boolean inputIsValid = true;

        int startTime = timeRecord.getStartTime();
        if( !(startTime >= TimeMap.MIN_VALID_START_TIME && startTime <= TimeMap.MAX_VALID_START_TIME) ){
            log.info("Start Time {}({}) is out of range", TimeMap.map(startTime), startTime);
            inputIsValid = false;
        }

        int bedTime = timeRecord.getBedTime();
        if( !(bedTime >= TimeMap.MIN_VALID_BEDTIME_TIME && bedTime <=  TimeMap.MAX_VALID_BEDTIME_TIME) ){
            log.info("Bed Time {}({}) is out of range", TimeMap.map(bedTime), bedTime);
            inputIsValid = false;
        }

        int endTime = timeRecord.getEndTime();
        if( !(endTime >= TimeMap.MIN_VALID_END_TIME && endTime <= TimeMap.MAX_VALID_END_TIME)){
            log.info("End Time {}({}) is out of range", TimeMap.map(endTime), endTime);
            inputIsValid = false;
        }


        if( inputIsValid ){
            if( startTime >= endTime ){
                log.info("Start Time {}({}) is greater than or equal to End Time {}({})",
                        TimeMap.map(startTime), startTime, TimeMap.map(endTime), endTime);
                inputIsValid = false;
            }

            if( bedTime > endTime ){
                log.info("Bed Time {}({}) is greater than End Time {}({})",
                        TimeMap.map(bedTime), bedTime, TimeMap.map(endTime), endTime);
                inputIsValid = false;
            }
        }

        return inputIsValid;
    }

}
