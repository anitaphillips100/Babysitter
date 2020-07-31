package com.Anita.babysitter.service;

import com.Anita.babysitter.model.TimeRecord;

public interface CalculatorService {
    public String calculateNightlyAmount(TimeRecord timeRecord);
}
