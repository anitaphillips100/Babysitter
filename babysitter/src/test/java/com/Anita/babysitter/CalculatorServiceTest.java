package com.Anita.babysitter;

import com.Anita.babysitter.model.TimeRecord;
import com.Anita.babysitter.service.CalculatorService;
import com.Anita.babysitter.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorServiceTest {

    private CalculatorService service = new CalculatorServiceImpl();


    // ==========================================
    // test amount returned for valid input data
    // ==========================================
    @Test
    public void testValidInputData1(){
        // given
        TimeRecord timeRecord = new TimeRecord(5,"pm", 9, "pm", 2, "am");

        // when
        String amount = service.calculateNightlyAmount(timeRecord);

        // then
        assertEquals("104.00", amount);
    }


}
