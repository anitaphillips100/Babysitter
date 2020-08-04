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


    // ===========================================================
    // VALID INPUT DATA TESTS: correct amount should be returned
    // ===========================================================
    // arrive before child's bedtime and before midnight, leave after midnight
    @Test
    public void testValidInputData1(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("05:00 PM"), TimeMap.map("09:00 PM"), TimeMap.map("02:00 AM") );

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

    // arrive at child's bedtime and before midnight, leave after midnight
    @Test
    public void testValidInputData2(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("09:00 PM"), TimeMap.map("09:00 PM"), TimeMap.map("02:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("56.00", amount);
    }

    // arrive after child's bedtime and before midnight, leave after midnight
    @Test
    public void testValidInputData3(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("09:00 PM"), TimeMap.map("08:00 PM"), TimeMap.map("02:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("56.00", amount);
    }


    // arrive before child's bedtime and at midnight, leave after midnight
    @Test
    public void testValidInputData4(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("12:00 AM"), TimeMap.map("01:00 AM"), TimeMap.map("02:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("32.00", amount);
    }


    // arrive at child's bedtime and at midnight, and leave after midnight
    @Test
    public void testValidInputData5(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("12:00 AM"), TimeMap.map("12:00 AM"), TimeMap.map("04:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("64.00", amount);
    }

    // arrive after child's bedtime and at midnight, and leave after midnight
    @Test
    public void testValidInputData6(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("12:00 AM"), TimeMap.map("08:00 PM"), TimeMap.map("04:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("64.00", amount);
    }


    // arrive before child's bedtime and after midnight, leave after midnight
    @Test
    public void testValidInputData7(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("12:00 AM"), TimeMap.map("01:00 AM"), TimeMap.map("04:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("64.00", amount);
    }

    // arrive at child's bedtime and after midnight, and leave after midnight
    @Test
    public void testValidInputData8(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("01:00 AM"), TimeMap.map("01:00 AM"), TimeMap.map("04:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("48.00", amount);
    }

    // arrive after child's bedtime and after midnight, and leave after midnight
    @Test
    public void testValidInputData9(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("01:00 AM"), TimeMap.map("12:00 AM"), TimeMap.map("04:00 AM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("48.00", amount);
    }

    // arrive before child's bedtime and before midnight, leave before midnight
    @Test
    public void testValidInputData10(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("05:00 PM"), TimeMap.map("09:00 PM"), TimeMap.map("10:00 PM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("56.00", amount);
    }

    // arrive at child's bedtime and before midnight, leave before midnight
    @Test
    public void testValidInputData11(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("09:00 PM"), TimeMap.map("09:00 PM"), TimeMap.map("10:00 PM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("8.00", amount);
    }

    // arrive after child's bedtime and before midnight, leave before midnight
    @Test
    public void testValidInputData12(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("10:00 PM"), TimeMap.map("09:00 PM"), TimeMap.map("11:00 PM") );

        // when
        String amount = "";
        try {
            amount = service.calculateNightlyAmount(timeRecord);
        }catch(Exception e){
            fail("Unexpected exception when passing valid data: " + e.getMessage());
        }

        // then
        assertEquals("8.00", amount);
    }

    // ==============================================================================
    // INVALID INPUT DATA TESTS: exception should be thrown by CalculatorService
    // ==============================================================================

    // out of range arrival time
    @Test
    public void testInvalidInputData1(){
        // given
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("04:00 PM"), TimeMap.map("09:00 PM"), TimeMap.map("02:00 AM") );

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
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("05:00 PM"), TimeMap.map("04:00 PM"), TimeMap.map("02:00 AM") );

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
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("05:00 PM"), TimeMap.map("03:00 PM"), TimeMap.map("05:00 AM") );

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
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("05:00 PM"), TimeMap.map("08:00 PM"), TimeMap.map("05:00 PM") );

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
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("10:00 PM"), TimeMap.map("08:00 PM"), TimeMap.map("09:00 PM") );

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
        TimeRecord timeRecord = new TimeRecord( TimeMap.map("05:00 PM"), TimeMap.map("12:00 AM"), TimeMap.map("09:00 PM") );

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
