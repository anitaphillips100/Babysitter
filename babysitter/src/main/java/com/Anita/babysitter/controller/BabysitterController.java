package com.Anita.babysitter.controller;

import com.Anita.babysitter.model.TimeRecord;
import com.Anita.babysitter.service.CalculatorService;
import com.Anita.babysitter.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Slf4j
@Controller
public class BabysitterController {

    private final CalculatorService  calculatorService;

    @Autowired
    public BabysitterController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(MappingNames.NIGHTLY_CALCULATOR)
    public String getCalculator(){

        return ViewNames.NIGHTLY_CALCULATOR;
    }

    @PostMapping(MappingNames.NIGHTLY_CALCULATOR)
    public String calculateNightlyCharge(@RequestParam Map<String,String> requestParams, Model model){
        log.info("startTime = {}; bedtime = {}; endTime = {};",
                requestParams.get("startTime"), requestParams.get("bedTime"), requestParams.get("endTime")
        );

        TimeRecord timeRecord = null;
        String amount;

        try {
            timeRecord = new TimeRecord(
                    Integer.parseInt(requestParams.get("startTime")),
                    Integer.parseInt(requestParams.get("bedTime")),
                    Integer.parseInt(requestParams.get("endTime")) );
            amount = calculatorService.calculateNightlyAmount(timeRecord);
        }catch(CalculatorInvalidInputException e){
            handleInvalidInputException(e, model);
            return ViewNames.NIGHTLY_CALCULATOR;
        }catch(Exception e){
            handleInvalidInputException(e, model);
            return ViewNames.NIGHTLY_CALCULATOR;
        }

        model.addAttribute("errorMessage","");
        model.addAttribute("amount", amount);

        return ViewNames.NIGHTLY_RESULTS;
    }

    private void handleInvalidInputException(Exception e, Model model){
        // TODO: improve to allow for improved messaging to the user and logging
        log.info("Problem with input; redirecting to Calculator input page.");
        model.addAttribute("errorMessage", ErrorMessages.GENERIC_INVALID_INPUT_MSG);
    }


}
