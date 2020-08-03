package com.Anita.babysitter;

import com.Anita.babysitter.model.TimeRecord;
import com.Anita.babysitter.service.CalculatorService;
import com.Anita.babysitter.service.CalculatorServiceImpl;
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
        TimeRecord timeRecord = new TimeRecord(5,"pm", 9, "pm", 2, "am");

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
    // out of range bedtime
    // out of range leave time
    // arrival time is equal to leave time
    // arrival time is after leave time
}
