package com.Anita.babysitter.service;

import com.Anita.babysitter.model.TimeRecord;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calculateNightlyAmount(TimeRecord timeRecord) {

        // TODO: this is where the logic to calculate the amount to charge for the the night goes

        // hard-code return value for now
        String chargeAmount = "36.00";
        
        return chargeAmount;
    }
}
