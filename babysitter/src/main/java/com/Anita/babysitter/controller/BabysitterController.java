package com.Anita.babysitter.controller;

import com.Anita.babysitter.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class BabysitterController {

        @GetMapping("calculateNightlyCharge")
        public String calculateNightlyCharge(){
            log.info("calculateNightlyCharge");
            return ViewNames.NIGHTLY_CALCULATOR;
        }
}
