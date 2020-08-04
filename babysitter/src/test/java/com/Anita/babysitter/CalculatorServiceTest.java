package com.Anita.babysitter;

import com.Anita.babysitter.model.TimeRecord;
import com.Anita.babysitter.service.CalculatorService;
import com.Anita.babysitter.service.CalculatorServiceImpl;
import com.Anita.babysitter.util.ErrorMessages;
import com.Anita.babysitter.util.TimeMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class CalculatorServiceTest {

    private CalculatorService service = new CalculatorServiceImpl();


    // ======================================================
    // test correct amount is returned for valid input data
    // ======================================================
    @Test
    // arrive before child's bedtime and before midnight, leave after midnight
    public void testValidInputData1(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.getStartNumber("05:00 PM"), TimeMap.getBedNumber("09:00 PM"), TimeMap.getEndNumber("02:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("104.00", amount);
    }

    // TODO: these tests need to be implemented
    // arrive at child's bedtime and before midnight, leave after midnight
    // arrive after child's bedtime and before midnight, leave after midnight

    // arrive before child's bedtime and at midnight, leave after midnight
    // arrive at child's bedtime and at midnight, and leave after midnight
    // arrive after child's bedtime and at midnight, and leave after midnight

    // arrive before child's bedtime and after midnight, leave after midnight
    // arrive at child's bedtime and after midnight, and leave after midnight
    // arrive after child's bedtime and after midnight, and leave after midnight

    // arrive before child's bedtime and before midnight, leave before midnight
    // arrive at child's bedtime and before midnight, leave before midnight
    // arrive after child's bedtime and before midnight, leave before midnight

    // ==============================================================================
    // test that exception is thrown by CalculatorService when input data is invalid
    // ==============================================================================

    // out of range arrival time
    @Test
    public void testInvalidInputData1(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.getStartNumber("04:00 PM"), TimeMap.getBedNumber("09:00 PM"), TimeMap.getEndNumber("02:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            // then
            assertEquals(ErrorMessages.GENERIC_INVALID_INPUT_MSG, e.getMessage());
            return;
        }

        // failure
        fail("CacluatorService should have throw an exception");
    }


    // out of range bedtime
    @Test
    public void testInvalidInputData2(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.getStartNumber("05:00 PM"), TimeMap.getBedNumber("04:00 PM"), TimeMap.getEndNumber("02:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            // then
            assertEquals(ErrorMessages.GENERIC_INVALID_INPUT_MSG, e.getMessage());
            return;
        }

        // failure
        fail("CacluatorService should have throw an exception");
    }

    // out of range leave time
    @Test
    public void testInvalidInputData3(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.getStartNumber("05:00 PM"), TimeMap.getBedNumber("03:00 PM"), TimeMap.getEndNumber("05:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            // then
            assertEquals(ErrorMessages.GENERIC_INVALID_INPUT_MSG, e.getMessage());
            return;
        }

        // failure
        fail("CacluatorService should have throw an exception");
    }

    // arrival time is equal to leave time
    @Test
    public void testInvalidInputData4(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.getStartNumber("05:00 PM"), TimeMap.getBedNumber("08:00 PM"), TimeMap.getEndNumber("05:00 PM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            // then
            assertEquals(ErrorMessages.GENERIC_INVALID_INPUT_MSG, e.getMessage());
            return;
        }

        // failure
        fail("CacluatorService should have throw an exception");
    }

    // arrival time is after leave time
    @Test
    public void testInvalidInputData5(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.getStartNumber("10:00 PM"), TimeMap.getBedNumber("08:00 PM"), TimeMap.getEndNumber("09:00 PM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            // then
            assertEquals(ErrorMessages.GENERIC_INVALID_INPUT_MSG, e.getMessage());
            return;
        }

        // failure
        fail("CacluatorService should have throw an exception");
    }

    // bed time is after leave time
    @Test
    public void testInvalidInputData6(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.getStartNumber("05:00 PM"), TimeMap.getBedNumber("12:00 AM"), TimeMap.getEndNumber("09:00 PM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            // then
            assertEquals(ErrorMessages.GENERIC_INVALID_INPUT_MSG, e.getMessage());
            return;
        }

        // failure
        fail("CacluatorService should have throw an exception");
    }
}
