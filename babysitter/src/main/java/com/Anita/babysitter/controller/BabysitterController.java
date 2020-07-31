package com.Anita.babysitter.controller;

import com.Anita.babysitter.model.TimeRecord;
import com.Anita.babysitter.service.CalculatorService;
import com.Anita.babysitter.util.MappingNames;
import com.Anita.babysitter.util.ViewNames;
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
        log.info("startTime = {} {}; bedtime = {}; {} endTime = {} {};",
                requestParams.get("startTime"), requestParams.get("startAmOrPm"),
                requestParams.get("bedTime"), requestParams.get("bedAmOrPm"),
                requestParams.get("endTime"), requestParams.get("endAmOrPm")
        );

        TimeRecord timeRecord = null;

        // TODO: validate parameters
        try {
                    timeRecord = new TimeRecord(
                    Integer.parseInt(requestParams.get("startTime")),
                    requestParams.get("startAmOrPM"),
                    Integer.parseInt(requestParams.get("bedTime")),
                    requestParams.get("bedAmOrPM"),
                    Integer.parseInt(requestParams.get("endTime")),
                    requestParams.get("endAmOrPM"));
        }catch(Exception e){
            log.info("Problem with input; redirecting to Calculator input page.");
            model.addAttribute("errorMessage", "Try again. Your input was invalid.");
            return ViewNames.NIGHTLY_CALCULATOR;
        }

        model.addAttribute("errorMessage","");
        model.addAttribute("amount", calculatorService.calculateNightlyAmount(timeRecord));

        return ViewNames.NIGHTLY_RESULTS;
    }



}
