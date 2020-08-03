package com.Anita.babysitter.service;

import com.Anita.babysitter.model.TimeRecord;
import com.Anita.babysitter.util.CalculatorInvalidInputException;

public interface CalculatorService {
    public String calculateNightlyAmount(TimeRecord timeRecord) throws CalculatorInvalidInputException;
}
