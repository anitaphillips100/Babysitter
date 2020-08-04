package com.Anita.babysitter.service;

import com.Anita.babysitter.model.TimeRecord;
import com.Anita.babysitter.util.CalculatorInvalidInputException;
import com.Anita.babysitter.util.TimeMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calculateNightlyAmount(TimeRecord timeRecord) throws CalculatorInvalidInputException {

        log.info("calculate for time record: " + timeRecord.toString() );

        if( !valid(timeRecord) ){
            Exception e = new CalculatorInvalidInputException("Input is invalid");
        }
        // TODO: this is where the logic to calculate the amount to charge for the the night goes

        // hard-code return value for now
        String chargeAmount = "36.00";

        return chargeAmount;
    }

    private boolean valid(TimeRecord timeRecord){
        // TODO: need some way to let user know what fields are not valid.
        // for now if anything is invalid return false
        boolean validFlag = true;

        int startTime = timeRecord.getStartTime();
        if( !(startTime >= TimeMap.MIN_VALID_START_TIME && timeRecord.getStartTime() <= TimeMap.MAX_VALID_START_TIME) ){
            log.info("Start Time {}({}) is out of range", TimeMap.getStartTime(startTime), startTime);
            validFlag = false;
        }

        int bedTime = timeRecord.getBedTime();
        if( !(bedTime >= TimeMap.MIN_VALID_BEDTIME_TIME && bedTime <=  TimeMap.MAX_VALID_BEDTIME_TIME) ){
            log.info("Bed Time {}({}) is out of range", TimeMap.getBedTime(bedTime), bedTime);
            validFlag = false;
        }

        int endTime = timeRecord.getEndTime();
        if( !(endTime >= TimeMap.MIN_VALID_END_TIME && endTime <= TimeMap.MAX_VALID_END_TIME)){
            log.info("End Time {}({}) is out of range", TimeMap.getEndTime(endTime), endTime);
            validFlag = false;
        }



        return true;
    }

}
